package uk.co.markormesher.easymaps.engine.walker

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import uk.co.markormesher.easymaps.engine._mocks.getMockWalkerConfig
import uk.co.markormesher.easymaps.engine.helpers.randomLong
import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*
import java.util.regex.Pattern
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WalkGeneratorTests {

	/**
	 * NOTE: throughout these tests, values are compared to the min... constraints,
	 * because the mock option provider gives equal min/max values for all
	 * constraints (see mockWalkerOptionsShouldHaveEqualMinMax()), thereby
	 * eliminating the random element without invalidating the tests.
	 */

	@Rule @JvmField
	val tempFolder = TemporaryFolder()

	@Test
	fun mockWalkerOptionsShouldHaveEqualMinMax() {
		val walkerOpts = getMockWalkerConfig().walkerOptionProvider
		assertTrue(walkerOpts.minTimePerNode == walkerOpts.maxTimePerNode)
		assertTrue(walkerOpts.minGapBetweenNodes == walkerOpts.maxGapBetweenNodes)
		assertTrue(walkerOpts.minScanGap == walkerOpts.maxScanGap)
	}

	@Test
	fun generateWalksShouldCreateFile() {
		val paths = ArrayList<List<Int>>()
		paths.add(arrayListOf(0, 1, 2))
		generateWalks(Network(5), paths, getMockWalkerConfig(logFolderPath = tempFolder.root.absolutePath))
		assertEquals(1, tempFolder.root.listFiles().size)
	}

	@Test
	fun generateWalkLogShouldCreateValidFormat() {
		val walk = generateWalkLog(
				Network(5),
				arrayListOf(0),
				0L, "mark",
				getMockWalkerConfig()
		)
		val pattern = Pattern.compile("mark; \\d+; (0_(\\d+)(, )?)+")
		var fileEmpty = true
		walk.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			assertTrue(pattern.matcher(line).matches())
			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

	@Test
	fun generateWalkLogShouldUseNodeLabels() {
		val network = Network(5)
		network.nodeLabels[3] = "three"
		val walk = generateWalkLog(
				network,
				arrayListOf(3),
				0L, "mark",
				getMockWalkerConfig()
		)
		val pattern = Pattern.compile("mark; \\d+; (three_(\\d+)(, )?)+")
		var fileEmpty = true
		walk.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			assertTrue(pattern.matcher(line).matches())
			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

	@Test
	fun generateWalkLogShouldObeyMinMaxGapBetweenNodes() {
		val walkerOpts = getMockWalkerConfig().walkerOptionProvider

		val walk = generateWalkLog(
				Network(5),
				arrayListOf(0, 1, 0, 1, 0, 1, 0, 1, 0),
				randomLong(0L, 100000L),
				"mark",
				getMockWalkerConfig()
		)

		var fileEmpty = true
		var lastNode = 0
		var lastNodeExitTime = 0L
		walk.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			val scanTime = line.drop(6).split(';')[0].toLong()
			val node = if (line.contains("0_")) 0 else 1

			if (node != lastNode) {
				val gapBetweenNodes = (scanTime - lastNodeExitTime) - walkerOpts.minScanGap
				assertEquals(walkerOpts.minGapBetweenNodes, gapBetweenNodes)
			}

			lastNode = node
			lastNodeExitTime = scanTime

			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

	@Test
	fun generateWalkLogShouldObeyMinMaxTimePerNode() {
		val walkerOpts = getMockWalkerConfig().walkerOptionProvider

		var entryScanTime = randomLong(0L, 100000L)
		val walk = generateWalkLog(
				Network(5),
				arrayListOf(0, 1, 0, 1, 0, 1, 0, 1, 0),
				entryScanTime,
				"mark",
				getMockWalkerConfig()
		)

		var fileEmpty = true
		var lastNode = 0
		walk.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			val scanTime = line.drop(6).split(';')[0].toLong()
			val node = if (line.contains("0_")) 0 else 1

			if (node != lastNode) {
				val timeInLastNode = (scanTime - entryScanTime) - walkerOpts.minGapBetweenNodes
				assertEquals(walkerOpts.minTimePerNode, timeInLastNode)
				entryScanTime = scanTime
			}
			lastNode = node

			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

	@Test
	fun generateWalkLogShouldObeyMinMaxScanGap() {
		val walk = generateWalkLog(
				Network(5),
				arrayListOf(3),
				1000L, "mark",
				getMockWalkerConfig()
		)
		var fileEmpty = true
		var lastScan = 0L
		walk.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			val scanTime = line.drop(6).split(';')[0].toLong()
			if (lastScan != 0L) {
				val scanGap = scanTime - lastScan
				lastScan = scanTime
				assertTrue(scanGap >= getMockWalkerConfig().walkerOptionProvider.minScanGap)
				assertTrue(scanGap <= getMockWalkerConfig().walkerOptionProvider.maxScanGap)
			}
			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

	@Test
	fun generateWalkLogShouldObeyMinMaxinTraitsPerScan() {
		val walk = generateWalkLog(
				Network(5),
				arrayListOf(3),
				1000L, "mark",
				getMockWalkerConfig()
		)
		var fileEmpty = true
		walk.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			val traits = line.drop(6).split(';')[1].split(',')
			assertTrue(traits.size >= getMockWalkerConfig().walkerOptionProvider.minTraitsPerScan)
			assertTrue(traits.size <= getMockWalkerConfig().walkerOptionProvider.maxTraitsPerScan)
			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

}