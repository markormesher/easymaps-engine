package uk.co.markormesher.easymaps.engine.interfaces

import uk.co.markormesher.easymaps.engine.helpers.randomElement

abstract class LogGeneratorOptionProvider {

	/**
	 * Possible lengths of paths generated.
	 * A length will be selected at random.
	 */
	abstract val pathLengths: Array<Int>

	/**
	 * Possible user IDs for logs generated.
	 * An ID will be selected at random.
	 */
	abstract val userIds: Array<String>

	/**
	 * Minimum number of times each node must be visited, across all paths.
	 */
	abstract val minVisitsPerNode: Int

	/**
	 * Minimum time gap between visits to each node.
	 */
	abstract val minGapBetweenNodes: Long

	/**
	 * Maximum time gap between visits to each node.
	 */
	abstract val maxGapBetweenNodes: Long

	/**
	 * Minimum time to spend "in" each node.
	 */
	abstract val minTimePerNode: Long

	/**
	 * Maximum time to spend "in" each node.
	 */
	abstract val maxTimePerNode: Long

	/**
	 * Minimum time to wait between scans.
	 */
	abstract val minScanGap: Long

	/**
	 * Maximum time to wait between scans.
	 */
	abstract val maxScanGap: Long

	/**
	 * Minimum number of traits to capture in each scan.
	 */
	abstract val minTraitsPerScan: Int

	/**
	 * Maximum number of traits to capture in each scan.
	 */
	abstract val maxTraitsPerScan: Int

	/**
	 * Returns the next node to visit, given the previous node, the current node, and the current node's successors.
	 * By default, this selects a random successor.
	 */
	open fun getNextNode(prev: Int, current: Int, successors: List<Int>): Int = successors.randomElement()

	/**
	 * Generates a string representation of a trait, given the node label.
	 * Example implementation: return "nodeLabel_${randomInt(0,10)}"
	 */
	abstract fun generateTrait(nodeLabel: String): String

	/**
	 * Generate a log entry, given the user ID, timestamp and list of scanned traits.
	 */
	abstract fun generateLogLine(userId: String, timestamp: Long, traits: List<String>): String

	/**
	 * Generates a file name, given the user ID, timestamp and path index.
	 */
	open fun generateLogFileName(userId: String, timestamp: Long, index: Int): String = "$userId-$timestamp-$index.txt"

}
