package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine.structures.Matrix
import uk.co.markormesher.easymaps.engine.structures.Network
import uk.co.markormesher.easymaps.engine.structures.SparseMatrix
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
	private fun calcInitialPossibleAssignments(): Matrix {
		val m = SparseMatrix(master.nodeCount, candidate.nodeCount)
		for (cNode in 0..candidate.nodeCount - 1) {
			(0..master.nodeCount - 1)
					.filter { mNode -> candidate.nodeDegree(cNode) <= master.nodeDegree(mNode) }
					.forEach { mNode -> m[cNode, mNode] = 1.0 }
		}
		return m
	}

	private fun search(assignments: MutableMap<Int, Int>, possibleAssignments: Matrix): Boolean {
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

		// update assignments
		updatePossibleAssignments(possibleAssignments)

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
		possibleAssignments.forEachOnRow(pivotNode, { possibleMNode, value ->
			if (value != 1.0 || assignments.containsValue(possibleMNode)) return@forEachOnRow

			assignments.put(pivotNode, possibleMNode)

			val possibleAssignmentsClone = possibleAssignments.clone()
			possibleAssignmentsClone.clearRow(pivotNode)
			possibleAssignmentsClone[pivotNode, possibleMNode] = 1.0

			search(assignments, possibleAssignmentsClone)
			assignments.remove(pivotNode)
		})

		return false
	}

	private fun updatePossibleAssignments(possibleAssignments: Matrix) {
		var changes = true
		while (changes) {
			changes = false

			for (cNode in 0..candidate.nodeCount - 1) {
				possibleAssignments.forEachOnRow(cNode, { cNodeAssignment, value ->
					if (value != 1.0) return@forEachOnRow

					for (cNodeSuccessor in candidate.getSuccessors(cNode)) {
						val possible = (0..master.nodeCount - 1).any { mNode ->
							possibleAssignments[cNodeSuccessor, mNode] == 1.0 && master.hasEdge(cNodeAssignment, mNode)
						}
						if (!possible) {
							possibleAssignments[cNode, cNodeAssignment] = 0.0
							changes = true
						}
					}
				})
			}
		}
	}

}
