package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.dataset_generator.generateDatasets
import uk.co.markormesher.easymaps.engine.dataset_generator.generateNetworks
import uk.co.markormesher.easymaps.engine.helpers.*

fun runDatasetGenerator(args: Array<String>) {
	if (args.contains("--force")) entryPointOptions.put("force", "y")

	val cfg = DatasetGeneratorConfig(
			datasetGeneratorOptionProvider = selectDatasetGeneratorOptionProvider(),
			outputFolderPath = enterPath("Enter path to output folder", "outputFolderPath", PATH_TYPE_FOLDER)
	)

	// just to be sure...
	if ((entryPointOptions["force"] ?: "n") != "y") {
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

	println()
	try {
		val networks = generateNetworks(cfg)
		generateDatasets(networks, cfg, args)
		printSubHeader("Done!")
	} catch (e: PrematureFailureException) {
		printError("Premature failure")
		println()
	}

	timer += System.currentTimeMillis()
	printInfo("Execution took $timer ms")
	println()
}
