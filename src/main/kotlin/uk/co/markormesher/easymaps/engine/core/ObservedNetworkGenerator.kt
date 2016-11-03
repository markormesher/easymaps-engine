package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.algorithms.applyMarkovClustering
import uk.co.markormesher.easymaps.engine.entities.ParsedLogFile
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.option_providers.OptionProvider
import uk.co.markormesher.easymaps.engine.algorithms.structures.SparseSquareMatrix

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
	val adjMatrix = SparseSquareMatrix(traitTranslator.size)
	parsedLogFiles.forEach { logFile ->
		logFile.logEntries.forEach { logEntry ->
			logEntry.traits.forAllPairs { a, b ->
				if (a < b) {
					adjMatrix[a, b] = adjMatrix[a, b] + 1
					adjMatrix[b, a] = adjMatrix[b, a] + 1
					adjMatrix[a, a] = 1.0
					adjMatrix[b, b] = 1.0
				}
			}
		}
	}
	printInfo("Generated trait adjacency matrix")
	printSubMessage("Density: ${adjMatrix.density}")

	applyMarkovClustering(adjMatrix)

}