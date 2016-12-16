package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.EngineConfig
import uk.co.markormesher.easymaps.engine.PrematureFailureException
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.structures.DisjointSet
import uk.co.markormesher.easymaps.engine.structures.Network
import uk.co.markormesher.easymaps.engine.structures.ParsedLogFile
import uk.co.markormesher.easymaps.engine.structures.SparseMatrix
import java.util.*

// TODO: tests for all segments of observed network generation
fun generateObservedNetwork(parsedLogFiles: List<ParsedLogFile>, cfg: EngineConfig): Network {

	printSubHeader("Generating Observed Network")

	val coOccurrenceMatrix = generateCoOccurrenceMatrix(parsedLogFiles, cfg)
	val clusterSets = generateClusterSets(coOccurrenceMatrix, cfg)
	val adjMatrix = generateClusterAdjacencyMatrix(clusterSets, parsedLogFiles, cfg)
	populateTraitToClusterMap(clusterSets, cfg)
	val network = generateNetwork(adjMatrix)
	printInfo("Writing observed network to file")
	generateNetworkImage(network, "observed-network", cfg)
	return network
}

private fun generateCoOccurrenceMatrix(parsedLogFiles: List<ParsedLogFile>, cfg: EngineConfig): SparseMatrix<Int> {

	printInfo("Generating trait co-occurrence matrix")

	val coMatrix = SparseMatrix(cfg.traitTranslator.size, cfg.traitTranslator.size, 0)
	parsedLogFiles.forEach { logFile ->
		logFile.logEntries.forEach { logEntry ->
			logEntry.traits.forEachPair { a, b ->
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

private fun generateClusterSets(coMatrix: SparseMatrix<Int>, cfg: EngineConfig): DisjointSet {

	printInfo("Building disjoint set of trait clusters")

	val clusterSets = DisjointSet(cfg.traitTranslator.size)
	coMatrix.forEachNonDefault { row, col, value ->
		if (value >= cfg.optionProvider.coOccurrencesRequiredPerTraitLink) {
			clusterSets.join(row, col)
		}
	}
	printSubInfo("Created ${clusterSets.setCount} clusters")

	clusterSets.generateRootPositions()

	return clusterSets
}

private fun generateClusterAdjacencyMatrix(clusterSets: DisjointSet, parsedLogFiles: List<ParsedLogFile>, cfg: EngineConfig): SparseMatrix<Int> {

	printInfo("Generating cluster adjacency matrix")

	val adjMatrix = SparseMatrix(clusterSets.setCount, clusterSets.setCount, 0)
	var fileId = 0
	parsedLogFiles.forEach logFiles@ { logFile ->
		++fileId
		var lastNode = -1
		var lastNodeSeenAt = -1L
		var lastNodeScanGaps = ArrayList<Long>()

		logFile.logEntries.forEach logEntries@ { logEntry ->
			val thisNode = logEntry.traits.map({ i -> clusterSets.findRootPosition(i) }).majorityElement(-1)
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
				val averageScanGapsInLastNode = lastNodeScanGaps.average()
				lastNodeScanGaps.clear()

				// gap may be artificially extended by the gap between scans
				val minNodeGap = thisNodeSeenAt - lastNodeSeenAt
				val maxNodeGap = (thisNodeSeenAt - lastNodeSeenAt) - averageScanGapsInLastNode

				if (cfg.optionProvider.minTimeGapBetweenClusters >= 0 && minNodeGap < cfg.optionProvider.minTimeGapBetweenClusters) {
					printSubWarning("Minimum time gap not met in file $fileId (gap: $minNodeGap); skipping rest of file")
					return@logFiles
				}
				if (cfg.optionProvider.maxTimeGapBetweenClusters >= 0 && maxNodeGap > cfg.optionProvider.maxTimeGapBetweenClusters) {
					printSubWarning("Maximum time gap exceeded in file $fileId (gap: $maxNodeGap); skipping rest of file")
					return@logFiles
				}

				adjMatrix[lastNode, thisNode] = adjMatrix[lastNode, thisNode] + 1
			} else {
				val scanGap = thisNodeSeenAt - lastNodeSeenAt
				lastNodeScanGaps.add(scanGap)
			}

			lastNode = thisNode
			lastNodeSeenAt = thisNodeSeenAt
		}
	}
	printSubInfo("Cluster adjacency matrix contains ${adjMatrix.storedValueCount} edges")

	return adjMatrix
}

private fun populateTraitToClusterMap(clusterSets: DisjointSet, cfg: EngineConfig) {

	printInfo("Mapping individual traits to cluster IDs")

	cfg.traitTranslator.forEachTrait { trait, i ->
		cfg.traitTranslator.setTraitCluster(trait, clusterSets.findRootPosition(i))
	}
}

private fun generateNetwork(adjMatrix: SparseMatrix<Int>): Network {

	printInfo("Generating final network")

	val network = Network(adjMatrix.width)
	adjMatrix.forEachNonDefault { row, col, value -> network.addEdge(row, col) }
	printSubInfo("Network has ${network.nodeCount} node(s)")
	printSubInfo("Network has ${network.edgeCount} edge(s)")

	if (network.edgeCount == 0) {
		printError("Cannot continue with 0 edges")
		throw PrematureFailureException()
	}

	return network
}
