package uk.co.markormesher.easymaps.engine.interfaces

import uk.co.markormesher.easymaps.engine.helpers.randomElement

abstract class WalkerOptionProvider {

	abstract val walkLengths: Array<Int>

	abstract val userIds: Array<String>

	abstract val minVisitsPerNode: Int

	abstract val minTimePerNode: Long

	abstract val maxTimePerNode: Long

	abstract val minScanGap: Long

	abstract val maxScanGap: Long

	abstract val minTraitsPerScan: Int

	abstract val maxTraitsPerScan: Int

	open fun getNextNode(prev: Int, current: Int, successors: List<Int>): Int = successors.randomElement()

	abstract fun generateTrait(nodeLabel: String): String

	abstract fun generateLogLine(timestamp: Long, userId: String, traits: List<String>): String

	fun generateLogFileName(index: Int, timestamp: Long, userId: String): String = "$userId-$timestamp-$index.txt"

}