package uk.co.markormesher.easymaps.engine.walker

import uk.co.markormesher.easymaps.engine.WalkerConfig
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.randomElement
import uk.co.markormesher.easymaps.engine.helpers.randomInt
import uk.co.markormesher.easymaps.engine.helpers.randomLong
import uk.co.markormesher.easymaps.engine.structures.Network
import java.io.PrintWriter
import java.util.*

fun generateWalks(network: Network, paths: List<List<Int>>, cfg: WalkerConfig) {
	val opts = cfg.walkerOptionProvider

	printInfo("Generating and writing walks")

	// for every path...
	paths.forEachIndexed { i, path ->
		val timestamp = System.currentTimeMillis()
		val userId = opts.userIds.randomElement()
		val walk = generateWalkLog(network, path, timestamp, userId, cfg)
		writeWalkLog(cfg.walkerOptionProvider.generateLogFileName(userId, timestamp, i), walk, cfg)
	}
}

internal fun generateWalkLog(network: Network, path: List<Int>, timestamp: Long, userId: String, cfg: WalkerConfig): String {
	val opts = cfg.walkerOptionProvider
	var _timestamp = timestamp

	val sb = StringBuilder()

	// for every node in this path...
	path.forEach { node ->
		var timeRemainingInThisNode = randomLong(opts.minTimePerNode, opts.maxTimePerNode)

		// for every scan in this node...
		while (timeRemainingInThisNode > 0) {
			// collect traits
			val traitsInThisScan = randomInt(opts.minTraitsPerScan, opts.maxTraitsPerScan)
			val traits = HashSet<String>()
			while (traits.size < traitsInThisScan) traits.add(opts.generateTrait(network.nodeLabel(node)))

			// add log line
			sb.append(opts.generateLogLine(userId, _timestamp, traits.toList())).append("\n")

			// advance time
			val timeStep = randomLong(opts.minScanGap, opts.maxScanGap)
			timeRemainingInThisNode -= timeStep
			_timestamp += timeStep
		}

		// spend some time travelling to the next node
		_timestamp += randomLong(opts.minGapBetweenNodes, opts.maxGapBetweenNodes)
	}

	return sb.toString()
}

internal fun writeWalkLog(name: String, log: String, cfg: WalkerConfig) {
	val file = "${cfg.logFolderPath}/$name"
	with(PrintWriter(file, "UTF-8")) {
		print(log)
		close()
	}
}