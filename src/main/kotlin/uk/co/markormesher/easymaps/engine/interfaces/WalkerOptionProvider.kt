package uk.co.markormesher.easymaps.engine.interfaces

import uk.co.markormesher.easymaps.engine.helpers.randomElement

abstract class WalkerOptionProvider {

	abstract val walkLengths: Array<Int>

	abstract val userIds: Array<String>

	abstract val minVisitsPerNode: Int

	abstract val minGapBetweenNodes: Long
	abstract val maxGapBetweenNodes: Long

	abstract val minTimePerNode: Long
	abstract val maxTimePerNode: Long

	abstract val minScanGap: Long
	abstract val maxScanGap: Long

	abstract val minTraitsPerScan: Int
	abstract val maxTraitsPerScan: Int

	open fun getNextNode(prev: Int, current: Int, successors: List<Int>): Int = successors.randomElement()

	abstract fun generateTrait(nodeLabel: String): String

	abstract fun generateLogLine(userId: String, timestamp: Long, traits: List<String>): String

	open fun generateLogFileName(userId: String, timestamp: Long, index: Int): String = "$userId-$timestamp-$index.txt"

}