package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.core.*
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.structures.TraitTranslator

fun runEngine(optionFile: String? = null) {
	if (optionFile != null) readOptionsFile(optionFile)
	val cfg = EngineConfig(
			logReader = selectLogReader(),
			optionProvider = selectOptionProvider(),
			traitTranslator = TraitTranslator(),
			logFolderPath = enterPath("Enter path to log input folder", "logFolderPath", PATH_TYPE_FOLDER),
			knownNetworkFilePath = enterPath("Enter path to known network file", "knownNetworkFilePath", PATH_TYPE_FILE),
			outputFolderPath = enterPath("Enter path to output folder", "outputFolderPath", PATH_TYPE_FOLDER),
			graphvizExec = enterPath("Enter path to GraphViz drawing executable (probably dot or neato)", "graphvizExec", PATH_TYPE_FILE),
			drawGraphs = selectYesNo("Draw graphs?", "drawGraphs")
	)

	// just to be sure...
	println()
	printWarning("This will delete everything in ${cfg.outputFolderPath}!")
	if (!selectYesNo("Are you sure you want to continue?", "")) {
		printSubHeader("Aborted")
		return
	} else {
		clearDirectory(cfg.outputFolderPath)
	}

	var timer = -System.currentTimeMillis()

	try {
		val parsedLogFiles = parseAndCleanData(cfg)
		val observedNetwork = generateObservedNetwork(parsedLogFiles, cfg)
		val knownNetwork = parseKnownNetwork(cfg)
		val isomorphisms = matchNetworks(observedNetwork, knownNetwork)
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