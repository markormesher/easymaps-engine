package uk.co.markormesher.easymaps.engine.domain_specific.sample

import uk.co.markormesher.easymaps.engine.helpers.randomElement
import uk.co.markormesher.easymaps.engine.helpers.randomInt
import uk.co.markormesher.easymaps.engine.interfaces.WalkerOptionProvider
import java.util.*

class SampleWalkerOptionProvider : WalkerOptionProvider() {

	private val traitsPerNode = 30

	override val walkLengths = arrayOf(1, 5, 10, 15, 20)

	override val userIds = arrayOf("abcdef")

	override val minVisitsPerNode = 10

	override val minTimePerNode = 30000L // 30 seconds
	override val maxTimePerNode = 240000L // 240 seconds

	override val minGapBetweenNodes = 10000L // 10 seconds
	override val maxGapBetweenNodes = 120000L // 120 seconds

	override val minScanGap = 15000L // 15 seconds
	override val maxScanGap = 30000L // 30 seconds

	override val minTraitsPerScan = 1
	override val maxTraitsPerScan = 20

	override fun getNextNode(prev: Int, current: Int, successors: List<Int>): Int {
		if (successors.size == 1) {
			return successors[0]
		} else {
			// reduce odds of backtracking by making all other nodes <scale> times as likely
			val scale = 3
			val successorsCopy = ArrayList<Int>()
			successorsCopy.addAll(successors)
			for (i in 1..scale - 1) successorsCopy.addAll(successors.filter({ n -> n != prev }))
			return successorsCopy.randomElement()
		}
	}

	override fun generateTrait(nodeLabel: String): String {
		val cleanLabel = nodeLabel.toLowerCase().replace(Regex("[^a-z]"), "")
		val number = randomInt(0, traitsPerNode)
		return "${cleanLabel}_$number"
	}

	override fun generateLogLine(userId: String, timestamp: Long, traits: List<String>): String {
		return "[$userId,$timestamp,${traits.joinToString(",")}]"
	}
}