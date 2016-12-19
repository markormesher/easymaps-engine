package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.dataset_generator.generateDatasets
import uk.co.markormesher.easymaps.engine.dataset_generator.generateNetworks

fun runDatasetGenerator(args: Array<String>) {
	val cfg = DatasetGeneratorConfig(
			datasetGeneratorOptionProvider = selectDatasetGeneratorOptionProvider(),
			outputFolderPath = enterPath("Enter path to output folder", "outputFolderPath", PATH_TYPE_FOLDER)
	)

	// just to be sure...
	println()
	printWarning("This will delete everything in '${cfg.outputFolderPath}'!")
	if (selectYesNo("Are you sure you want to continue?", "")) {
		clearDirectory(cfg.outputFolderPath, true)
	} else {
		printSubHeader("Aborted")
		return
	}
	println()

	var timer = -System.currentTimeMillis()

	try {
		val networks = generateNetworks(cfg)
		generateDatasets(networks, cfg)
		printSubHeader("Done!")
	} catch (e: PrematureFailureException) {
		printError("Premature failure")
		println()
	}

	timer += System.currentTimeMillis()
	printInfo("Execution took $timer ms")
	println()
}
