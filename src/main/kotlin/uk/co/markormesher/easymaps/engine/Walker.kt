package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.core.parseKnownNetwork
import uk.co.markormesher.easymaps.engine.helpers.INPUT_PROMPT
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.helpers.printWarning
import uk.co.markormesher.easymaps.engine.walker.generateRandomPaths
import uk.co.markormesher.easymaps.engine.walker.generateWalks

fun runWalker(optionFile: String? = null) {
	if (optionFile != null) readOptionsFile(optionFile)
	val cfg = WalkerConfig(
			optionProvider = selectOptionProvider(),
			walkerOptionProvider = selectWalkerOptionProvider(),
			logFolderPath = enterPath("Enter path to log folder", "logFolderPath", PATH_TYPE_FOLDER),
			knownNetworkFilePath = enterPath("Enter path to known network file", "knownNetworkFilePath", PATH_TYPE_FILE),
			outputFolderPath = enterPath("Enter path to output folder", "outputFolderPath", PATH_TYPE_FOLDER),
			dotExec = enterPath("Enter path to GraphViz drawing executable (probably dot or neato)", "dotExec", PATH_TYPE_FILE)
	)

	// just to be sure...
	println()
	printWarning("This will delete everything in ${cfg.logFolderPath} - are you sure you want to continue? [y/n]")
	print(INPUT_PROMPT)
	val choice = readLine()!!.trim()
	if (choice != "y") {
		printSubHeader("Aborted")
		return
	}

	var timer = -System.currentTimeMillis()

	val network = parseKnownNetwork(cfg)
	val paths = generateRandomPaths(network, cfg)
	generateWalks(network, paths, cfg)
	printSubHeader("Done!")

	timer += System.currentTimeMillis()
	printInfo("Execution took $timer ms")
	println()
}