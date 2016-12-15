package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*

/*
Approach: perform a depth-first-search of all possible node assignments, pruning branches
when an impossible assignment is reached.
*/

class BruteForceIsomorphismFinder(val candidate: Network, val master: Network): IsomorphismFinder {

	val isomorphisms = ArrayList<Map<Int, Int>>()

	override fun findIsomorphisms(): List<Map<Int, Int>> {
		search(HashMap<Int, Int>(candidate.nodeCount))
		return isomorphisms
	}

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
		val pivotNode = assignments.size

		// find possible assignments for the pivot node
		val possibleAssignments = Array(master.nodeCount, { i -> i }).filter { i -> !assignments.containsValue(i) }

		// try all possible assignments for the pivot node
		for (a in possibleAssignments) {
			assignments.put(pivotNode, a)
			search(assignments)
			assignments.remove(pivotNode)
		}

		return false
	}

}
