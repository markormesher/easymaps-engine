package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.core.parseKnownNetwork
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.log_generator.generateLogs
import uk.co.markormesher.easymaps.engine.log_generator.generateRandomPaths

fun runLogGenerator(args: Array<String>) {
	if (args.isNotEmpty()) readOptionsFile(args[0])

	if (args.contains("--graphs")) entryPointOptions.put("drawGraphs", "y")
	if (args.contains("--no-graphs")) entryPointOptions.put("drawGraphs", "n")
	if (args.contains("--force")) entryPointOptions.put("force", "y")

	val logGeneratorOptionProvider = selectLogGeneratorOptionProvider()
	val knownNetworkFilePath = enterPath("Enter path to known network file", "knownNetworkFilePath", PATH_TYPE_FILE)
	val logFolderPath = enterPath("Enter path to log folder", "logFolderPath", PATH_TYPE_FOLDER)
	val outputFolderPath = enterPath("Enter path to output folder", "outputFolderPath", PATH_TYPE_FOLDER)
	val drawGraphs = selectYesNo("Draw graphs with GraphViz?", "drawGraphs")
	val graphvizExec: String
	if (drawGraphs) {
		graphvizExec = enterPath("Enter path to GraphViz drawing executable (probably dot or neato)", "graphvizExec", PATH_TYPE_FILE)
	} else {
		graphvizExec = ""
	}
	val cfg = LogGeneratorConfig(
			logGeneratorOptionProvider = logGeneratorOptionProvider,
			knownNetworkFilePath = knownNetworkFilePath,
			logFolderPath = logFolderPath,
			outputFolderPath = outputFolderPath,
			graphvizExec = graphvizExec,
			drawGraphs = drawGraphs
	)

	// just to be sure...
	if ((entryPointOptions["force"] ?: "n") != "y") {
		println()
		printWarning("This will delete everything in '${cfg.logFolderPath}'!")
		if (selectYesNo("Are you sure you want to continue?", "")) {
			clearDirectory(cfg.logFolderPath)
		} else {
			printSubHeader("Aborted")
			return
		}
	}

	var timer = -System.currentTimeMillis()

	println()
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
