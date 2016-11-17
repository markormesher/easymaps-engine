package uk.co.markormesher.easymaps.engine.walker

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import uk.co.markormesher.easymaps.engine._mocks.getMockWalkerConfig
import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*
import java.util.regex.Pattern
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WalkGeneratorTests {

	@Rule @JvmField
	val tempFolder = TemporaryFolder()

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
	fun generateWalkLogShouldUseAppropriateScanGap() {
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
	fun generateWalkLogShouldSpendAppropriateTimeInNode() {
		val walk = generateWalkLog(
				Network(5),
				arrayListOf(0, 1, 0, 1, 0, 1, 0, 1, 0),
				1000L, "mark",
				getMockWalkerConfig()
		)
		var fileEmpty = true
		var entryScanTime = 1000L
		var lastNode = 0
		walk.split("\n").forEach { line ->
			if (line.isBlank()) return@forEach
			val scanTime = line.drop(6).split(';')[0].toLong()
			val node = if (line.contains("0_")) 0 else 1

			if (node != lastNode) {
				val timeInLastNode = scanTime - entryScanTime
				assertTrue(timeInLastNode >= getMockWalkerConfig().walkerOptionProvider.minTimePerNode, "time in node $timeInLastNode")
				assertTrue(timeInLastNode <= getMockWalkerConfig().walkerOptionProvider.maxTimePerNode, "time in node $timeInLastNode")
				entryScanTime = scanTime
			}
			lastNode = node

			fileEmpty = false
		}
		assertFalse(fileEmpty)
	}

	@Test
	fun generateWalkLogShouldUseAppropriateNumberOfTraits() {
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