package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.Config
import uk.co.markormesher.easymaps.engine.data.ParsedLogFile
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.structures.DisjointSet
import uk.co.markormesher.easymaps.engine.structures.SparseSquareMatrix
import java.io.PrintWriter

fun generateObservedNetwork(parsedLogFiles: List<ParsedLogFile>, cfg: Config) {

	printSubHeader("Generating Observed Network")

	val coOccurrenceMatrix = generateCoOccurrenceMatrix(parsedLogFiles, cfg)
	val clusterSets = generateClusterSets(coOccurrenceMatrix, cfg)
	val adjMatrix = generateClusterAdjacencyMatrix(clusterSets, parsedLogFiles, cfg)
	populateTraitToClusterMap(clusterSets, cfg)
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
	printSubInfo("Density: ${String.format("%.2f", coMatrix.density * 100)}%")

	return coMatrix
}

private fun generateClusterSets(coMatrix: SparseSquareMatrix, cfg: Config): DisjointSet {

	printInfo("Building disjoint set of trait clusters...")

	val clusterSets = DisjointSet(cfg.traitTranslator.size)
	coMatrix.forEachNonZero { row, col, value ->
		if (value >= cfg.optionProvider.coOccurrencesRequiredPerTraitLink) {
			clusterSets.join(row, col)
		}
	}
	printSubInfo("Created ${clusterSets.setCount} clusters")

	clusterSets.generateRootPositions()

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
			val thisNode = logEntry.traits.map({ i -> clusterSets.findRootPosition(i) }).getMajorityElement(-1)
			val thisNodeSeenAt = logEntry.timestamp
			if (thisNode < 0) {
				printSubWarning("Could not determine majority trait in file $fileId; skipping entry")
				lastNode = -1
				lastNodeSeenAt = -1L
				return@logFiles
			}

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

private fun populateTraitToClusterMap(clusterSets: DisjointSet, cfg: Config) {

	printInfo("Mapping individual traits to cluster IDs...")

	cfg.traitTranslator.forAllTraits { trait, i ->
		cfg.traitTranslator.setClusterIdForTrait(trait, clusterSets.findRootPosition(i))
	}
}

// TODO: change this call into "generateObservedNetwork" and move graph output to helper
private fun writeObservedNetworkToFile(adjMatrix: SparseSquareMatrix, config: Config) {

	// create observed network as dot file
	val sb = StringBuilder()
	sb.append("graph Map {\n")
	//sb.append("node[shape = point, label = \"\"];\n")
	//sb.append("node[shape = point];\n")
	adjMatrix.forEachNonZero { row, col, value -> sb.append("$row -- $col;\n") }
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