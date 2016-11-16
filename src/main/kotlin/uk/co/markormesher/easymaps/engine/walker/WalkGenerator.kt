package uk.co.markormesher.easymaps.engine.walker

import uk.co.markormesher.easymaps.engine.WalkerConfig
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.randomElement
import uk.co.markormesher.easymaps.engine.helpers.randomInt
import uk.co.markormesher.easymaps.engine.helpers.randomLong
import uk.co.markormesher.easymaps.engine.structures.Network
import java.io.PrintWriter
import java.util.*

// TODO: break out walk string generation
// TODO: tests for walk generation
fun generateWalks(network: Network, paths: List<List<Int>>, cfg: WalkerConfig) {
	val opts = cfg.walkerOptionProvider

	printInfo("Generating and writing walks")

	// for every path...
	paths.forEachIndexed { i, path ->
		var timestamp = System.currentTimeMillis()
		val firstTimestamp = timestamp
		val userId = opts.userIds.randomElement()

		val sb = StringBuilder()

		// for every node in this path...
		path.forEach { node ->
			var timeInThisNode = randomLong(opts.minTimePerNode, opts.maxTimePerNode)

			// for every scan in this node...
			while (timeInThisNode > 0) {
				// collect traits
				val traitsInThisScan = randomInt(opts.minTraitsPerScan, opts.maxTraitsPerScan)
				val traits = HashSet<String>()
				while (traits.size < traitsInThisScan) traits.add(opts.generateTrait(network.nodeLabels[node]))

				// add log line
				sb.append(opts.generateLogLine(userId, timestamp, traits.toList())).append("\n")

				// advance time
				val timeStep = randomLong(opts.minScanGap, opts.maxScanGap)
				timeInThisNode -= timeStep
				timestamp += timeStep
			}
		}

		writeWalkLog(cfg.walkerOptionProvider.generateLogFileName(userId, firstTimestamp, i), sb, cfg)
	}
}

private fun writeWalkLog(name: String, sb: StringBuilder, cfg: WalkerConfig) {
	val file = "${cfg.logFolderPath}/$name"
	with(PrintWriter(file, "UTF-8")) {
		print(sb.toString())
		close()
	}
}