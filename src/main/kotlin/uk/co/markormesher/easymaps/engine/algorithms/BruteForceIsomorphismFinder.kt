package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*

/*
Approach: perform a depth-first-search of all possible node assignments, pruning branches
when an impossible assignment is reached.
*/

class BruteForceIsomorphismFinder(candidate: Network, master: Network): IsomorphismFinder(candidate, master) {

	var searchCount = 0L

	override fun beginSearch() {
		search(HashMap<Int, Int>(candidate.nodeCount))
	}

	private fun search(assignment: MutableMap<Int, Int>) {
		++searchCount

		// if we reached an impossible assignment, backtrack
		if (!validateAssignment(assignment)) return

		// if all nodes of the candidate network have assignment, we're done
		if (assignment.size == candidate.nodeCount) {
			submitResult(assignment)
			return
		}

		val pivotNode = assignment.size
		val possibleAssignments = Array(master.nodeCount, { i -> i }).filter { i -> !assignment.containsValue(i) }
		for (a in possibleAssignments) {
			assignment.put(pivotNode, a)
			search(assignment)
			assignment.remove(pivotNode)
		}
	}

}
