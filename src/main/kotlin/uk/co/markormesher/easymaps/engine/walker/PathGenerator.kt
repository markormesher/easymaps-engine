package uk.co.markormesher.easymaps.engine.walker

import uk.co.markormesher.easymaps.engine.WalkerConfig
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubInfo
import uk.co.markormesher.easymaps.engine.helpers.randomElement
import uk.co.markormesher.easymaps.engine.helpers.randomInt
import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*

// TODO: tests for generateRandomPaths()
fun generateRandomPaths(network: Network, cfg: WalkerConfig): List<List<Int>> {

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
		val pathLength = cfg.walkerOptionProvider.walkLengths.randomElement()
		for (i in 2..pathLength) {
			val successors = network.getSuccessors(curNode)
			if (successors.isEmpty()) break
			curNode = successors.randomElement() // TODO: break out next node selection
			path.add(curNode)
			++visits[curNode]
		}

		// remove nodes from the need-to-visit list if the threshold has passed
		nodesToVisit.removeIf { node -> visits[node] >= cfg.walkerOptionProvider.minVisitsPerNode }

		paths.add(path)
	}

	printSubInfo("Generated ${paths.size} path(s)")

	return paths
}