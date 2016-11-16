package uk.co.markormesher.easymaps.engine.interfaces

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

/**
 * These tests are just to silence warnings from JaCoCo.
 */
class WalkerOptionProviderTests {

	class WalkerOptionProviderMock : WalkerOptionProvider() {

		override val walkLengths = arrayOf(1, 2, 3)
		override val userIds = arrayOf("a", "b", "c")
		override val minVisitsPerNode = 1
		override val minTimePerNode = 2L
		override val maxTimePerNode = 3L
		override val minScanGap = 4L
		override val maxScanGap = 5L
		override val minTraitsPerScan = 6
		override val maxTraitsPerScan = 7

		override fun getNextNode(prev: Int, current: Int, successors: List<Int>): Int {
			return super.getNextNode(prev, current, successors)
		}

		override fun generateLogLine(userId: String, timestamp: Long, traits: List<String>) = "$userId; $timestamp; ${traits.joinToString(", ")}"

		override fun generateTrait(nodeLabel: String) = nodeLabel

		override fun generateLogFileName(userId: String, timestamp: Long, index: Int): String {
			return super.generateLogFileName(userId, timestamp, index)
		}
	}

	@Test
	fun defaultPropertiesShouldExist() {
		val mock = WalkerOptionProviderMock()
		assertNotNull(mock.walkLengths)
		assertNotNull(mock.userIds)
		assertNotNull(mock.minVisitsPerNode)
		assertNotNull(mock.minTimePerNode)
		assertNotNull(mock.maxTimePerNode)
		assertNotNull(mock.minScanGap)
		assertNotNull(mock.maxScanGap)
		assertNotNull(mock.minTraitsPerScan)
		assertNotNull(mock.maxTraitsPerScan)
		assertEquals(1, mock.getNextNode(0, 0, arrayListOf(1)))
		assertEquals("a; 1; b, c", mock.generateLogLine("a", 1L, arrayListOf("b", "c")))
		assertEquals("test", mock.generateTrait("test"))
		assertEquals("a-1-2.txt", mock.generateLogFileName("a", 1L, 2))
	}

}