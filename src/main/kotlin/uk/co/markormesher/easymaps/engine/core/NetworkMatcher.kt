package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.data.Network
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import java.util.*

fun matchNetworks(observedNetwork: Network, knownNetwork: Network): List<MutableMap<Int, Int>> {

	printSubHeader("Matching Networks")

	val isomorphisms = initSearch(observedNetwork, knownNetwork)
	printInfo("Found ${isomorphisms.size} possible isomorphism(s)")
	return isomorphisms
}

private fun initSearch(observedNetwork: Network, knownNetwork: Network): List<MutableMap<Int, Int>> {
	val isomorphisms = ArrayList<MutableMap<Int, Int>>()
	search(observedNetwork, knownNetwork, HashMap<Int, Int>(), isomorphisms)
	return isomorphisms
}

private fun search(
		observedNetwork: Network,
		knownNetwork: Network,
		assignments: MutableMap<Int, Int>,
		isomorphisms: ArrayList<MutableMap<Int, Int>>): Boolean {

	// the node in the observed network that we are trying to assign
	val pivotNode = assignments.size

	// check that assignments so far don't create edges that shouldn't exist
	var failed = false
	observedNetwork.forEachEdge { from, to ->
		if (!failed && from < pivotNode && to < pivotNode) {
			if (!knownNetwork.hasEdge(assignments[from]!!, assignments[to]!!)) {
				failed = true
				return@forEachEdge
			}
		}
	}
	if (failed) return false

	// if all nodes of the observed network have assignments, we're done
	if (assignments.size == observedNetwork.size) {
		printInfo("Isomorphism found!")
		val clone = HashMap<Int, Int>()
		clone.putAll(assignments)
		isomorphisms.add(clone)
	}

	// go through all possible assignments for the pivot node
	val possibleAssignments = Array(observedNetwork.size, { i -> i }) // TODO: keep optimised set
	for (j in possibleAssignments) {
		if (!assignments.containsValue(j)) {
			assignments.put(pivotNode, j)
			search(observedNetwork, knownNetwork, assignments, isomorphisms)
			assignments.remove(pivotNode)
		}
	}

	return false
}