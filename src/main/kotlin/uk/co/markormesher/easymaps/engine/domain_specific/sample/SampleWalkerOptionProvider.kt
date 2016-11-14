package uk.co.markormesher.easymaps.engine.domain_specific.sample

import uk.co.markormesher.easymaps.engine.helpers.randomInt
import uk.co.markormesher.easymaps.engine.interfaces.WalkerOptionProvider

class SampleWalkerOptionProvider : WalkerOptionProvider() {

	private val traitsPerNode = 30

	override val walkLengths = arrayOf(1, 5, 10, 15, 20)

	override val userIds = arrayOf("abcdef")

	override val minVisitsPerNode = 10

	override val minTimePerNode = 30000L // 30 seconds
	override val maxTimePerNode = 240000L // 240 seconds

	override val minScanGap = 15000L // 15 seconds
	override val maxScanGap = 30000L // 30 seconds

	override val minTraitsPerScan = 1
	override val maxTraitsPerScan = 20

	override fun generateTrait(nodeLabel: String): String {
		val cleanLabel = nodeLabel.toLowerCase().replace(Regex("[^a-z]"), "")
		val number = randomInt(0, traitsPerNode)
		return "${cleanLabel}_$number"
	}

	override fun generateLogLine(timestamp: Long, userId: String, traits: List<String>): String {
		return "[$userId,$timestamp,${traits.joinToString(",")}]"
	}
}