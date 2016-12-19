package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.core.parseKnownNetwork
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.log_generator.generateLogs
import uk.co.markormesher.easymaps.engine.log_generator.generateRandomPaths

fun runLogGenerator(args: Array<String>) {
	if (args.size == 1) readOptionsFile(args[0])

	val cfg = LogGeneratorConfig(
			logGeneratorOptionProvider = selectLogGeneratorOptionProvider(),
			knownNetworkFilePath = enterPath("Enter path to known network file", "knownNetworkFilePath", PATH_TYPE_FILE),
			logFolderPath = enterPath("Enter path to log folder", "logFolderPath", PATH_TYPE_FOLDER),
			outputFolderPath = enterPath("Enter path to output folder", "outputFolderPath", PATH_TYPE_FOLDER),
			graphvizExec = enterPath("Enter path to GraphViz drawing executable (probably dot or neato)", "graphvizExec", PATH_TYPE_FILE),
			drawGraphs = selectYesNo("Draw graphs?", "drawGraphs")
	)

	// just to be sure...
	println()
	printWarning("This will delete everything in '${cfg.logFolderPath}'!")
	if (!selectYesNo("Are you sure you want to continue?", "")) {
		printSubHeader("Aborted")
		return
	} else {
		clearDirectory(cfg.logFolderPath)
	}
	println()

	var timer = -System.currentTimeMillis()

	try {
		val network = parseKnownNetwork(cfg)
		val paths = generateRandomPaths(network, cfg)
		generateLogs(network, paths, cfg)
		printSubHeader("Done!")
	} catch (e: PrematureFailureException) {
		printError("Premature failure")
		println()
	}

	timer += System.currentTimeMillis()
	printInfo("Execution took $timer ms")
	println()
}
