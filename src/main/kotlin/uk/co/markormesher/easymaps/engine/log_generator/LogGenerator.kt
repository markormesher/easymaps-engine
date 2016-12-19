package uk.co.markormesher.easymaps.engine.log_generator

import uk.co.markormesher.easymaps.engine.LogGeneratorConfig
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.randomElement
import uk.co.markormesher.easymaps.engine.helpers.randomInt
import uk.co.markormesher.easymaps.engine.helpers.randomLong
import uk.co.markormesher.easymaps.engine.structures.Network
import java.io.PrintWriter
import java.util.*

fun generateLogs(network: Network, paths: List<List<Int>>, cfg: LogGeneratorConfig) {
	val opts = cfg.logGeneratorOptionProvider

	printInfo("Generating and writing logs")

	// for every path...
	paths.forEachIndexed { i, path ->
		val timestamp = System.currentTimeMillis()
		val userId = opts.userIds.randomElement()
		val log = generateSingleLog(network, path, timestamp, userId, cfg)
		writeSingleLog(cfg.logGeneratorOptionProvider.generateLogFileName(userId, timestamp, i), log, cfg)
	}
}

internal fun generateSingleLog(network: Network, path: List<Int>, timestamp: Long, userId: String, cfg: LogGeneratorConfig): String {
	val opts = cfg.logGeneratorOptionProvider
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

internal fun writeSingleLog(name: String, log: String, cfg: LogGeneratorConfig) {
	val file = "${cfg.logFolderPath}/$name"
	with(PrintWriter(file, "UTF-8")) {
		print(log)
		close()
	}
}
