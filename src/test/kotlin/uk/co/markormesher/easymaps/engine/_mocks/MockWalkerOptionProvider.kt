package uk.co.markormesher.easymaps.engine._mocks

import uk.co.markormesher.easymaps.engine.helpers.randomInt
import uk.co.markormesher.easymaps.engine.interfaces.WalkerOptionProvider

class MockWalkerOptionProvider : WalkerOptionProvider() {

	override val walkLengths = arrayOf(1, 2, 3)
	override val userIds = arrayOf("a", "b", "c")
	override val minVisitsPerNode = 5
	override val minTimePerNode = 30000L // 30 seconds
	override val maxTimePerNode = 240000L // 240 seconds
	override val minScanGap = 15000L // 15 seconds
	override val maxScanGap = 30000L // 30 seconds
	override val minTraitsPerScan = 1
	override val maxTraitsPerScan = 20

	override fun getNextNode(prev: Int, current: Int, successors: List<Int>): Int {
		return super.getNextNode(prev, current, successors)
	}

	override fun generateLogLine(userId: String, timestamp: Long, traits: List<String>) = "$userId; $timestamp; ${traits.joinToString(", ")}"

	override fun generateTrait(nodeLabel: String) = "${nodeLabel}_${randomInt(0, 100)}"

	override fun generateLogFileName(userId: String, timestamp: Long, index: Int): String {
		return super.generateLogFileName(userId, timestamp, index)
	}
}