package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.algorithms.structures.DisjointSet
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

	// create adjacency matrix to count co-occurrences of traits
	printInfo("Generating trait co-occurrence matrix...")
	val coMatrix = SparseSquareMatrix(traitTranslator.size)
	parsedLogFiles.forEach { logFile ->
		logFile.logEntries.forEach { logEntry ->
			logEntry.traits.forAllPairs { a, b ->
				if (a < b) {
					coMatrix[a, b] = coMatrix[a, b] + 1
					coMatrix[b, a] = coMatrix[b, a] + 1
				}
			}
		}
	}
	printSubMessage("Size: ${coMatrix.width}")
	printSubMessage("Density: ${coMatrix.density}")

	// create disjoint set for actual clustering
	printInfo("Building disjoint set of trait clusters...")
	val clusterSets = DisjointSet(traitTranslator.size)
	coMatrix.forAllNonZeroRowsAndCols { row, col, value ->
		if (value >= optionProvider.coOccurrencesRequiredPerTraitLink) {
			clusterSets.join(row, col)
		}
	}
	printSubMessage("Created ${clusterSets.setCount} clusters")

	// create adjacency matrix to count cluster connections
	printInfo("Generating cluster adjacency matrix...")
	val adjMatrix = SparseSquareMatrix(traitTranslator.size)
	var fileId = 0
	parsedLogFiles.forEach logFiles@ { logFile ->
		++fileId
		var lastNode = -1
		var lastNodeSeenAt = -1L

		logFile.logEntries.forEach logEntries@ { logEntry ->
			val thisNode = clusterSets.find(logEntry.traits[0]) // todo: use majority
			val thisNodeSeenAt = logEntry.timestamp

			if (lastNode < 0) {
				lastNode = thisNode
				lastNodeSeenAt = thisNodeSeenAt
				return@logEntries
			}

			if (lastNode != thisNode) {
				val timeGap = thisNodeSeenAt - lastNodeSeenAt
				if (optionProvider.minTimeGapBetweenClusters >= 0 && timeGap < optionProvider.minTimeGapBetweenClusters) {
					printWarning("Minimum time gap not met in file $fileId (gap: $timeGap); skipping rest of file")
					return@logFiles
				}
				if (optionProvider.maxTimeGapBetweenClusters >= 0 && timeGap > optionProvider.maxTimeGapBetweenClusters) {
					printWarning("Maximum time gap exceeded in file $fileId (gap: $timeGap); skipping rest of file")
					return@logFiles
				}

				// assumes that the graph is non-directional
				val from = Math.max(lastNode, thisNode)
				val to = Math.min(lastNode, thisNode)
				adjMatrix[from, to] = adjMatrix[from, to] + 1
			}
			lastNode = thisNode
			lastNodeSeenAt = thisNodeSeenAt
		}
	}
	printInfo("Cluster adjacency matrix contains ${adjMatrix.nonZeroValues} edges")

	// post-cluster graph
	val sb = StringBuilder()
	sb.append("graph Map {\n")
	sb.append("node[shape = point, label = \"\"];\n")
	adjMatrix.forAllNonZeroRowsAndCols { row, col, value -> sb.append("$row -- $col;\n") }
	sb.append("}")
	with(PrintWriter("$outputPath/observed-map.dot", "UTF-8")) {
		print(sb.toString())
		close()
	}
}