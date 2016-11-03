package uk.co.markormesher.easymaps.engine.core_algo

import uk.co.markormesher.easymaps.engine.data.ParsedLogFile
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.option_providers.OptionProvider
import uk.co.markormesher.easymaps.engine.trait_translation.TraitTranslator

fun generateObservedNetwork(
		parsedLogFiles: List<ParsedLogFile>,
		outputPath: String,
		optionProvider: OptionProvider,
		traitTranslator: TraitTranslator) {

	printSubHeader("Generating Observed Network")

	printWarning("Work in progress!")

	// construct symmetrical weighted adjacency matrix of traits
	// higher weight = more co-occurrences
	// also adds self-loops for all traits
	val matrix = SparseSquareMatrix(traitTranslator.size, 0.0)
	parsedLogFiles.forEach { logFile ->
		logFile.logEntries.forEach { logEntry ->
			logEntry.traits.forAllPairs { a, b ->
				if (a < b) {
					matrix[a, b] = matrix[a, b] + 1
					matrix[b, a] = matrix[b, a] + 1
					matrix[a, a] = 1.0
					matrix[b, b] = 1.0
				}
			}
		}
	}
	printInfo("Generated trait adjacency matrix")
	printSubMessage("Density: ${matrix.density}")

}