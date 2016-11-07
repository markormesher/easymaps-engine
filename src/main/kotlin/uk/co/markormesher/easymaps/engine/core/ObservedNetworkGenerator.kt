package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.Config
import uk.co.markormesher.easymaps.engine.structures.DisjointSet
import uk.co.markormesher.easymaps.engine.structures.SparseSquareMatrix
import uk.co.markormesher.easymaps.engine.data.ParsedLogFile
import uk.co.markormesher.easymaps.engine.helpers.*
import java.io.PrintWriter

fun generateObservedNetwork(parsedLogFiles: List<ParsedLogFile>, cfg: Config) {

	printSubHeader("Generating Observed Network")

	val coOccurrenceMatrix = generateCoOccurrenceMatrix(parsedLogFiles, cfg)
	val clusterSets = generateClusterSets(coOccurrenceMatrix, cfg)
	val adjMatrix = generateClusterAdjacencyMatrix(clusterSets, parsedLogFiles, cfg)
	writeObservedNetworkToFile(adjMatrix, cfg)
}

private fun generateCoOccurrenceMatrix(parsedLogFiles: List<ParsedLogFile>, cfg: Config): SparseSquareMatrix {

	printInfo("Generating trait co-occurrence matrix...")

	val coMatrix = SparseSquareMatrix(cfg.traitTranslator.size)
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
	printSubInfo("Density: ${coMatrix.density}")

	return coMatrix
}

private fun generateClusterSets(coMatrix: SparseSquareMatrix, cfg: Config): DisjointSet {

	printInfo("Building disjoint set of trait clusters...")

	val clusterSets = DisjointSet(cfg.traitTranslator.size)
	coMatrix.forAllNonZeroRowsAndCols { row, col, value ->
		if (value >= cfg.optionProvider.coOccurrencesRequiredPerTraitLink) {
			clusterSets.join(row, col)
		}
	}
	printSubInfo("Created ${clusterSets.setCount} clusters")

	return clusterSets
}

private fun generateClusterAdjacencyMatrix(clusterSets: DisjointSet, parsedLogFiles: List<ParsedLogFile>, cfg: Config): SparseSquareMatrix {

	printInfo("Generating cluster adjacency matrix...")

	val adjMatrix = SparseSquareMatrix(cfg.traitTranslator.size)
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
				if (cfg.optionProvider.minTimeGapBetweenClusters >= 0 && timeGap < cfg.optionProvider.minTimeGapBetweenClusters) {
					printSubWarning("Minimum time gap not met in file $fileId (gap: $timeGap); skipping rest of file")
					return@logFiles
				}
				if (cfg.optionProvider.maxTimeGapBetweenClusters >= 0 && timeGap > cfg.optionProvider.maxTimeGapBetweenClusters) {
					printSubWarning("Maximum time gap exceeded in file $fileId (gap: $timeGap); skipping rest of file")
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
	printSubInfo("Cluster adjacency matrix contains ${adjMatrix.nonZeroValues} edges")

	return adjMatrix
}

// TODO: change this call into "generateObservedNetwork" and move graph output to helper
private fun writeObservedNetworkToFile(adjMatrix: SparseSquareMatrix, config: Config) {

	// create observed network as dot file
	val sb = StringBuilder()
	sb.append("graph Map {\n")
	sb.append("node[shape = point, label = \"\"];\n")
	adjMatrix.forAllNonZeroRowsAndCols { row, col, value -> sb.append("$row -- $col;\n") }
	sb.append("}")

	// write observed network to files
	printInfo("Writing observed network to file...")
	val dotFile = "${config.outputPath}/observed-map.dot"
	val pngFile = "${config.outputPath}/observed-map.png"
	with(PrintWriter(dotFile, "UTF-8")) {
		print(sb.toString())
		close()
	}
	Runtime.getRuntime().exec("${config.dotExec} -Tpng -o $pngFile $dotFile").waitFor()
	printSubInfo("Written to $dotFile")
	printSubInfo("Diagram in $pngFile")
}