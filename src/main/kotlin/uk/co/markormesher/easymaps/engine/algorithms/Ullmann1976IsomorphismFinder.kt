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

class Ullmann1976IsomorphismFinder(val candidate: Network, val master: Network): IsomorphismFinder {

	val isomorphisms = ArrayList<Map<Int, Int>>()
	val candidatePivotOrder by lazy { calcCandidatePivotOrder() }

	override fun findIsomorphisms(): List<Map<Int, Int>> {
		isomorphisms.clear()
		search(HashMap<Int, Int>(candidate.nodeCount), calcInitialPossibleAssignments())
		return isomorphisms
	}

	// calc the order the candidate nodes should be selected as pivots, using the highest-degree nodes first
	private fun calcCandidatePivotOrder() = Array(candidate.nodeCount, { i -> Pair(i, candidate.nodeDegree(i)) })
			.sortedWith(compareBy { i -> i.second })
			.reversed()
			.map({ i -> i.first })

	// for all candidate nodes, calc the list of master nodes that are of equal or higher degree
	private fun calcInitialPossibleAssignments() = Array(candidate.nodeCount, { cNode ->
		val matches = HashSet<Int>()
		matches.addAll((0..master.nodeCount - 1).filter { mNode -> candidate.nodeDegree(cNode) <= master.nodeDegree(mNode) })
		return@Array matches
	})

	private fun search(assignments: MutableMap<Int, Int>, possibleAssignments: Array<HashSet<Int>>): Boolean {
		// update assignments
		updatePossibleAssignments(possibleAssignments)

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

		// try all possible assignments for the pivot node
		for (a in possibleAssignments[pivotNode]) {
			if (assignments.containsValue(a)) continue

			// let's assume "pivotNode => a"
			assignments.put(pivotNode, a)

			// create a clone of our possible assignments, where pivotNode is only assigned to a
			val possibleAssignmentsClone = possibleAssignments.deepClone()
			possibleAssignmentsClone[pivotNode].clear()
			possibleAssignmentsClone[pivotNode].add(a)

			// search recursively
			search(assignments, possibleAssignmentsClone)

			// undo the assumption "pivotNode => a"
			assignments.remove(pivotNode)
		}

		return false
	}

	private fun updatePossibleAssignments(possibleAssignments: Array<HashSet<Int>>) {
		var changes = true
		while (changes) {
			changes = false

			for (cNode in 0..candidate.nodeCount - 1) {
				val removals = LinkedList<Pair<Int, Int>>()
				for (cNodeAssignment in possibleAssignments[cNode]) {
					for (cNodeSuccessor in candidate.getSuccessors(cNode)) {
						val match = (0..master.nodeCount - 1).any { mNode ->
							possibleAssignments[cNodeSuccessor].contains(mNode) && master.hasEdge(cNodeAssignment, mNode)
						}
						if (!match) {
							removals.add(Pair(cNode, cNodeAssignment))
							changes = true
						}
					}
				}
				removals.forEach { r -> possibleAssignments[r.first].remove(r.second) }
			}
		}
	}

}

fun <E> Array<HashSet<E>>.deepClone() = Array(this.size, { i ->
	val clone = HashSet<E>()
	clone.addAll(this[i])
	return@Array clone
})
