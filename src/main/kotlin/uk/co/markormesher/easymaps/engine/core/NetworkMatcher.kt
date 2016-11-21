package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.helpers.printSubInfo
import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*
import kotlin.comparisons.compareBy

val tries = HashSet<String>()

fun matchNetworks(observedNetwork: Network, knownNetwork: Network): List<MutableMap<Int, Int>> {

	printSubHeader("Matching Networks")

	val isomorphisms = initSearch(observedNetwork, knownNetwork)
	printInfo("Found ${isomorphisms.size} possible isomorphism(s)")
	return isomorphisms
}

private fun initSearch(observedNetwork: Network, knownNetwork: Network): List<MutableMap<Int, Int>> {
	// sort nodes of the observed network in the order we will pivot on them (highest degree first)
	val observedNetworkPivotOrder = Array(observedNetwork.nodeCount, { i -> Pair(i, observedNetwork.nodeDegree(i)) })
			.sortedWith(compareBy { i -> i.second })
			.reversed()
			.map({ i -> i.first })

	val isomorphisms = ArrayList<MutableMap<Int, Int>>()
	search(observedNetwork, observedNetworkPivotOrder, knownNetwork, HashMap<Int, Int>(), isomorphisms)
	return isomorphisms
}

private fun search(
		observedNetwork: Network,
		observedNetworkPivotOrder: List<Int>,
		knownNetwork: Network,
		assignments: MutableMap<Int, Int>,
		isomorphisms: ArrayList<MutableMap<Int, Int>>): Boolean {

	// check that assignments so far don't create edges that shouldn't exist
	var failed = false
	observedNetwork.forEachEdge { from, to ->
		if (!failed && assignments.containsKey(from) && assignments.containsKey(to)) {
			if (!knownNetwork.hasEdge(assignments[from]!!, assignments[to]!!)) {
				failed = true
				return@forEachEdge
			}
		}
	}
	if (failed) return false

	// if all nodes of the observed network have assignments, we're done
	if (assignments.size == observedNetwork.nodeCount) {
		//if (assignments.size == 12) {
		printInfo("Isomorphism found!")
		val clone = HashMap<Int, Int>()
		clone.putAll(assignments)
		isomorphisms.add(clone)
		return true
	}

	// the node in the observed network that we are trying to assign
	val pivotNode = observedNetworkPivotOrder[assignments.size]

	// go through all possible assignments for the pivot node
	val possibleAssignments = Array(knownNetwork.nodeCount, { i -> i })
			.filter { i -> !assignments.containsValue(i) }
			.filter { i -> observedNetwork.nodeDegree(pivotNode) <= knownNetwork.nodeDegree(i) }
	for (a in possibleAssignments) {
		assignments.put(pivotNode, a)
		val t = assignments.values.map({ i -> String.format("%03d", i) }).joinToString(", ")
		assert(!tries.contains(t))
		tries.add(t)
		printSubInfo("${tries.size}  $t")
		if (search(observedNetwork, observedNetworkPivotOrder, knownNetwork, assignments, isomorphisms)) return true
		assignments.remove(pivotNode)
	}

	return false
}