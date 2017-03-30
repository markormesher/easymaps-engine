package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.core.*
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.structures.TraitTranslator

fun runEngine(args: Array<String>) {
	if (args.isNotEmpty()) readOptionsFile(args[0])

	if (args.contains("--graphs")) entryPointOptions.put("drawGraphs", "y")
	if (args.contains("--no-graphs")) entryPointOptions.put("drawGraphs", "n")
	if (args.contains("--force")) entryPointOptions.put("force", "y")
	if (args.contains("--timed-matching")) entryPointOptions.put("timedMatching", "y")

	val logReader = selectLogReader()
	val optionProvider = selectOptionProvider()
	val traitTranslator = TraitTranslator()
	val logFolderPath = enterPath("Enter path to log input folder", "logFolderPath", PATH_TYPE_FOLDER)
	val knownNetworkFilePath = enterPath("Enter path to known network file", "knownNetworkFilePath", PATH_TYPE_FILE)
	val outputFolderPath = enterPath("Enter path to output folder", "outputFolderPath", PATH_TYPE_FOLDER)
	val drawGraphs = selectYesNo("Draw graphs with GraphViz?", "drawGraphs")
	val graphvizExec: String
	if (drawGraphs) {
		 graphvizExec = enterPath("Enter path to GraphViz drawing executable (probably dot or neato)", "graphvizExec", PATH_TYPE_FILE)
	} else {
		graphvizExec = ""
	}
	val cfg = EngineConfig(
			logReader = logReader,
			optionProvider = optionProvider,
			traitTranslator = traitTranslator,
			logFolderPath = logFolderPath,
			knownNetworkFilePath = knownNetworkFilePath,
			outputFolderPath = outputFolderPath,
			graphvizExec = graphvizExec,
			drawGraphs = drawGraphs
	)

	// just to be sure...
	if (entryPointOptions["force"] ?: "n" != "y") {
		println()
		printWarning("This will delete everything in '${cfg.outputFolderPath}'!")
		if (selectYesNo("Are you sure you want to continue?", "")) {
			clearDirectory(cfg.outputFolderPath)
		} else {
			printSubHeader("Aborted")
			return
		}
	}

	var timer = -System.currentTimeMillis()

	try {
		val parsedLogFiles = parseAndCleanData(cfg)
		val observedNetwork = generateObservedNetwork(parsedLogFiles, cfg)
		val knownNetwork = parseKnownNetwork(cfg)
		val isomorphisms: List<Map<Int, Int>>
		isomorphisms = matchNetworks(observedNetwork, knownNetwork, entryPointOptions["timedMatching"] ?: "n" == "y")
		writeOutput(knownNetwork, isomorphisms, cfg)
		printSubHeader("Done!")
	} catch (e: PrematureFailureException) {
		printError("Premature failure")
		println()
	}

	timer += System.currentTimeMillis()
	printInfo("Execution took $timer ms")
	println()
}
