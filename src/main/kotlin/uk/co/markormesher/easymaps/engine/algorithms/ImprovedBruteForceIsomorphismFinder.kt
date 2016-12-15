package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*
import kotlin.comparisons.compareBy

/*
Approach: perform a depth-first-search of all possible node assignments, pruning branches
when an impossible assignment is reached and limiting the search space by, pivoting on nodes
in descending degree order, and for each pivot node in the candidate graph selecting only
the nodes from the master graph with greater or equal degree.
*/

class ImprovedBruteForceIsomorphismFinder(val candidate: Network, val master: Network): IsomorphismFinder {

	val isomorphisms = ArrayList<Map<Int, Int>>()
	val candidatePivotOrder by lazy { calcCandidatePivotOrder() }
	val initialPossibleAssignments by lazy { calcInitialPossibleAssignments() }

	override fun findIsomorphisms(): List<Map<Int, Int>> {
		isomorphisms.clear()
		search(HashMap<Int, Int>(candidate.nodeCount))
		return isomorphisms
	}

	// calc the order the candidate nodes should be selected as pivots, using the highest-degree nodes first
	private fun calcCandidatePivotOrder() = Array(candidate.nodeCount, { i -> Pair(i, candidate.nodeDegree(i)) })
			.sortedWith(compareBy { i -> i.second })
			.reversed()
			.map({ i -> i.first })

	// for all candidate nodes, calc the list of master nodes that are of equal or higher degree
	private fun calcInitialPossibleAssignments() = Array(candidate.nodeCount, { cNode ->
		Array(master.nodeCount, { i -> i })
				.filter { i -> candidate.nodeDegree(cNode) <= master.nodeDegree(i) }
				.toTypedArray()
	})

	private fun search(assignments: MutableMap<Int, Int>): Boolean {
		// check that the assignments don't create non-existent edges
		var failed = false
		candidate.forEachEdge { from, to ->
			if (failed) return@forEachEdge
			val assignedFrom = assignments[from]
			val assignedTo = assignments[to]
			if (assignedFrom != null && assignedTo != null) {
				if (!master.hasEdge(assignedFrom, assignedTo)) {
					failed = true
				}
			}
		}
		if (failed) return false

		// if all nodes of the candidate network have assignments, we're done
		if (assignments.size == candidate.nodeCount) {
			val clone = HashMap<Int, Int>(candidate.nodeCount)
			clone.putAll(assignments)
			isomorphisms.add(clone)
			return true
		}

		// the node in the candidate network that we are trying to assign
		val pivotNode = candidatePivotOrder[assignments.size]

		// find possible assignments for the pivot node
		val possibleAssignments = initialPossibleAssignments[pivotNode].filter { i -> !assignments.containsValue(i) }

		// try all possible assignments for the pivot node
		for (a in possibleAssignments) {
			assignments.put(pivotNode, a)
			search(assignments)
			assignments.remove(pivotNode)
		}

		return false
	}

}
