package uk.co.markormesher.easymaps.engine.dataset_generator

import uk.co.markormesher.easymaps.engine.DatasetGeneratorConfig
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.interfaces.DatasetGeneratorOptionProvider
import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*

fun generateNetworks(cfg: DatasetGeneratorConfig): List<Network> {
	printSubHeader("Generating Networks")
	val opts = cfg.datasetGeneratorOptionProvider
	val networks = ArrayList<Network>()
	for (size in opts.sizes) {
		printInfo("Size: $size")
		val network = generateNetwork(size, opts)
		printSubInfo("Edges: ${network.edgeCount}")
		printSubInfo("Connectivity: ${String.format("%.2f", network.edgeCount / network.nodeCount.toDouble())}")
		networks.add(network)
	}
	return networks
}

internal fun generateNetwork(size: Int, opts: DatasetGeneratorOptionProvider): Network {
	val network = Network(size)

	// chains
	var skippedLastEdge = false
	for (i in 1..size - 1) {
		// make sure every node is part of a chain
		val canSkipEdge = !skippedLastEdge && i != 1 && i != size - 1

		if (!canSkipEdge || randomDouble() > opts.chainBreakChance) {
			if (randomDouble() > opts.singleDirectionChance) {
				network.addEdge(i - 1, i)
				network.addEdge(i, i - 1)
			} else {
				network.addEdge(i - 1, i)
			}
			skippedLastEdge = false
		} else {
			skippedLastEdge = true
		}
	}

	// more edges
	val targetEdges = Math.round(size * randomDouble(opts.minConnectivity, opts.maxConnectivity)).toInt()
	while (network.edgeCount < targetEdges) {
		val from = randomInt(0, size)
		val to = randomInt(0, size)
		if (randomDouble() > opts.singleDirectionChance) {
			network.addEdge(from, to)
			network.addEdge(to, from)
		} else {
			network.addEdge(from, to)
		}
	}

	return network
}
