package uk.co.markormesher.easymaps.engine.log_generator

import uk.co.markormesher.easymaps.engine.LogGeneratorConfig
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubInfo
import uk.co.markormesher.easymaps.engine.helpers.randomElement
import uk.co.markormesher.easymaps.engine.helpers.randomInt
import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*

fun generateRandomPaths(network: Network, cfg: LogGeneratorConfig): List<List<Int>> {

	printInfo("Generating random paths")

	// count visits per node and store the nodes that haven't met the threshold
	val visits = Array(network.nodeCount, { 0 })
	val nodesToVisit = ArrayList<Int>(network.nodeCount)
	nodesToVisit += 0..network.nodeCount - 1

	val paths = ArrayList<ArrayList<Int>>()

	// while some nodes are below the threshold, generate a path
	while (nodesToVisit.isNotEmpty()) {
		val path = ArrayList<Int>()

		// select starting node as one that still needs to be visited
		val startIndex = randomInt(0, nodesToVisit.size)
		val startNode = nodesToVisit[startIndex]

		// visit the node
		path.add(startNode)
		++visits[startNode]

		// visit some more nodes
		var curNode = startNode
		var prevNode = -1
		val pathLength = cfg.logGeneratorOptionProvider.pathLengths.randomElement()
		for (i in 2..pathLength) {
			val successors = network.getSuccessors(curNode)
			if (successors.isEmpty()) break

			val nextNode = cfg.logGeneratorOptionProvider.getNextNode(prevNode, curNode, successors)
			prevNode = curNode
			curNode = nextNode

			path.add(curNode)
			++visits[curNode]
		}

		// remove nodes from the need-to-visit list if the threshold has passed
		nodesToVisit.removeIf { node -> visits[node] >= cfg.logGeneratorOptionProvider.minVisitsPerNode }

		paths.add(path)
	}

	printSubInfo("Generated ${paths.size} path(s)")

	return paths
}
