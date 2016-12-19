package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.network_generator.generateNetworks

fun runNetworkGenerator(args: Array<String>) {
	val cfg = NetworkGeneratorConfig(
			networkGeneratorOptionProvider = selectNetworkGeneratorOptionProvider(),
			outputFolderPath = enterPath("Enter path to output folder", "outputFolderPath", PATH_TYPE_FOLDER)
	)

	// just to be sure...
	println()
	printWarning("This will delete everything in '${cfg.outputFolderPath}'!")
	if (!selectYesNo("Are you sure you want to continue?", "")) {
		printSubHeader("Aborted")
		return
	} else {
		clearDirectory(cfg.outputFolderPath)
	}
	println()

	var timer = -System.currentTimeMillis()

	try {
		generateNetworks(cfg)
		printSubHeader("Done!")
	} catch (e: PrematureFailureException) {
		printError("Premature failure")
		println()
	}

	timer += System.currentTimeMillis()
	printInfo("Execution took $timer ms")
	println()
}
