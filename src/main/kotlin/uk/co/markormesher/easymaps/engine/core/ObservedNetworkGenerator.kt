package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.algorithms.applyMarkovClustering
import uk.co.markormesher.easymaps.engine.algorithms.structures.SparseSquareMatrix
import uk.co.markormesher.easymaps.engine.entities.ParsedLogFile
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.option_providers.OptionProvider
import java.io.PrintWriter

fun generateObservedNetwork(
		parsedLogFiles: List<ParsedLogFile>,
		outputPath: String,
		optionProvider: OptionProvider,
		traitTranslator: TraitTranslator) {

	printSubHeader("Generating Observed Network")

	printWarning("Work in progress!")

	// construct symmetrical weighted adjacency matrix of traits
	// higher weight = more co-occurrences
	val adjMatrix = SparseSquareMatrix(traitTranslator.size)
	parsedLogFiles.forEach { logFile ->
		logFile.logEntries.forEach { logEntry ->
			logEntry.traits.forAllPairs { a, b ->
				if (a < b) {
					adjMatrix[a, b] = adjMatrix[a, b] + 1
					adjMatrix[b, a] = adjMatrix[b, a] + 1
				}
			}
		}
	}
	printInfo("Generated trait adjacency matrix")
	printSubMessage("Density: ${adjMatrix.density}")


	// graph 1
	val sb = StringBuilder()
	sb.append("graph Map {\n")
	sb.append("node[shape = point, label = \"\"];\n")
	adjMatrix.forAllRowsAndCols { row, col -> if (row > col && adjMatrix[row, col] > 0) sb.append("$row -- $col;\n") }
	sb.append("}")
	val writer1 = PrintWriter("$outputPath/map1.dot", "UTF-8")
	writer1.print(sb.toString())
	writer1.close()

	applyMarkovClustering(adjMatrix,
			addSelfLoops = true,
			maxLoopCount = 10,
			expansionFactor = 2,
			inflationFactor = 2.0,
			pruneThreshold = 0.001)

	// graph 1
	sb.setLength(0)
	sb.append("graph Map {\n")
	sb.append("node[shape = point, label = \"\"];\n")
	adjMatrix.forAllRowsAndCols { row, col -> if (row > col && adjMatrix[row, col] > 0) sb.append("$row -- $col;\n") }
	sb.append("}")
	val writer2 = PrintWriter("$outputPath/map2.dot", "UTF-8")
	writer2.print(sb.toString())
	writer2.close()

}