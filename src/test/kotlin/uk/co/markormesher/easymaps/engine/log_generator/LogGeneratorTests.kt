package uk.co.markormesher.easymaps.engine.log_generator

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import uk.co.markormesher.easymaps.engine._mocks.getMockLogGeneratorConfig
import uk.co.markormesher.easymaps.engine.helpers.randomLong
import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*
import java.util.regex.Pattern
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LogGeneratorTests {

	/**
	 * NOTE: throughout these tests, values are compared to the min... constraints,
	 * because the mock option provider gives equal min/max values for all
	 * constraints (see mockLogGeneratorOptionsShouldHaveEqualMinMax()), thereby
	 * eliminating the random element without invalidating the tests.
	 */

	@Rule @JvmField
	val tempFolder = TemporaryFolder()

	@Test
	fun mockLogGeneratorOptionsShouldHaveEqualMinMax() {
		val generatorOpts = getMockLogGeneratorConfig().logGeneratorOptionProvider
		assertTrue(generatorOpts.minTimePerNode == generatorOpts.maxTimePerNode)
		assertTrue(generatorOpts.minGapBetweenNodes == generatorOpts.maxGapBetweenNodes)
		assertTrue(generatorOpts.minScanGap == generatorOpts.maxScanGap)
	}

	@Test
	fun generateLogsShouldCreateFile() {
		val paths = ArrayList<List<Int>>()
		paths.add(arrayListOf(0, 1, 2))
		generateLogs(Network(5), paths, getMockLogGeneratorConfig(logFolderPath = tempFolder.root.absolutePath))
		assertEquals(1, tempFolder.root.listFiles().size)
	}

	@Test
	fun generateSingleLogShouldCreateValidFormat() {
		val log = generateSingleLog(
				Network(5),
				arrayListOf(0),
				0L, "mark",
				getMockLogGeneratorConfig()
		)
		val pattern = Pattern.compile("mark; \\d+; (0_(\\d+)(, )?)+")
		var fileEmpty = true
		log.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			assertTrue(pattern.matcher(line).matches())
			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

	@Test
	fun generateSingleLogShouldUseNodeLabels() {
		val network = Network(5)
		network.setNodeLabel(3, "three")
		val log = generateSingleLog(
				network,
				arrayListOf(3),
				0L, "mark",
				getMockLogGeneratorConfig()
		)
		val pattern = Pattern.compile("mark; \\d+; (three_(\\d+)(, )?)+")
		var fileEmpty = true
		log.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			assertTrue(pattern.matcher(line).matches())
			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

	@Test
	fun generateSingleLogShouldObeyMinMaxGapBetweenNodes() {
		val generatorOpts = getMockLogGeneratorConfig().logGeneratorOptionProvider

		val log = generateSingleLog(
				Network(5),
				arrayListOf(0, 1, 0, 1, 0, 1, 0, 1, 0),
				randomLong(0L, 100000L),
				"mark",
				getMockLogGeneratorConfig()
		)

		var fileEmpty = true
		var lastNode = 0
		var lastNodeExitTime = 0L
		log.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			val scanTime = line.drop(6).split(';')[0].toLong()
			val node = if (line.contains("0_")) 0 else 1

			if (node != lastNode) {
				val gapBetweenNodes = (scanTime - lastNodeExitTime) - generatorOpts.minScanGap
				assertEquals(generatorOpts.minGapBetweenNodes, gapBetweenNodes)
			}

			lastNode = node
			lastNodeExitTime = scanTime

			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

	@Test
	fun generateSingleLogShouldObeyMinMaxTimePerNode() {
		val generatorOpts = getMockLogGeneratorConfig().logGeneratorOptionProvider

		var entryScanTime = randomLong(0L, 100000L)
		val log = generateSingleLog(
				Network(5),
				arrayListOf(0, 1, 0, 1, 0, 1, 0, 1, 0),
				entryScanTime,
				"mark",
				getMockLogGeneratorConfig()
		)

		var fileEmpty = true
		var lastNode = 0
		log.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			val scanTime = line.drop(6).split(';')[0].toLong()
			val node = if (line.contains("0_")) 0 else 1

			if (node != lastNode) {
				val timeInLastNode = (scanTime - entryScanTime) - generatorOpts.minGapBetweenNodes
				assertEquals(generatorOpts.minTimePerNode, timeInLastNode)
				entryScanTime = scanTime
			}
			lastNode = node

			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

	@Test
	fun generateSingleLogShouldObeyMinMaxScanGap() {
		val log = generateSingleLog(
				Network(5),
				arrayListOf(3),
				1000L, "mark",
				getMockLogGeneratorConfig()
		)
		var fileEmpty = true
		var lastScan = 0L
		log.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			val scanTime = line.drop(6).split(';')[0].toLong()
			if (lastScan != 0L) {
				val scanGap = scanTime - lastScan
				lastScan = scanTime
				assertTrue(scanGap >= getMockLogGeneratorConfig().logGeneratorOptionProvider.minScanGap)
				assertTrue(scanGap <= getMockLogGeneratorConfig().logGeneratorOptionProvider.maxScanGap)
			}
			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

	@Test
	fun generateSingleLogShouldObeyMinMaxTraitsPerScan() {
		val log = generateSingleLog(
				Network(5),
				arrayListOf(3),
				1000L, "mark",
				getMockLogGeneratorConfig()
		)
		var fileEmpty = true
		log.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			val traits = line.drop(6).split(';')[1].split(',')
			assertTrue(traits.size >= getMockLogGeneratorConfig().logGeneratorOptionProvider.minTraitsPerScan)
			assertTrue(traits.size <= getMockLogGeneratorConfig().logGeneratorOptionProvider.maxTraitsPerScan)
			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

}
