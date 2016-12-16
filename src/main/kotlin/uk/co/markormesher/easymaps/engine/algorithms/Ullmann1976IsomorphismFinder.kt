package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine.structures.Matrix
import uk.co.markormesher.easymaps.engine.structures.Network
import uk.co.markormesher.easymaps.engine.structures.SparseMatrix
import java.util.*

/*
Approach: perform a depth-first-search of all possible node assignments, pruning branches
when an impossible assignment is reached, pivoting on nodes in descending degree order, and
limiting the search space by removing possible assignments in the manner described below.
*/

class Ullmann1976IsomorphismFinder(candidate: Network, master: Network): IsomorphismFinder(candidate, master) {

	val candidatePivotOrder by lazy { calcCandidatePivotOrder() }

	override fun beginSearch() {
		search(HashMap<Int, Int>(candidate.nodeCount), calcInitialPossibleAssignments())
	}

	// calc the order in which candidate nodes should be selected as pivots (descending degree order)
	private fun calcCandidatePivotOrder() = Array(candidate.nodeCount, { i -> Pair(i, candidate.nodeDegree(i)) })
			.sortedByDescending { i -> i.second }
			.map { i -> i.first }

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

	private fun search(assignment: MutableMap<Int, Int>, possibleAssignments: Matrix) {
		// if we reached an impossible assignment, backtrack
		if (!validateAssignment(assignment)) return

		// if all nodes of the candidate network have assignment, we're done
		if (assignment.size == candidate.nodeCount) {
			submitResult(assignment)
			return
		}

		val pivotNode = candidatePivotOrder[assignment.size]
		prunePossibleAssignments(possibleAssignments)
		possibleAssignments.forEachOnRow(pivotNode, { possibleMNode, value ->
			if (value != 1.0 || assignment.containsValue(possibleMNode)) return@forEachOnRow

			assignment.put(pivotNode, possibleMNode)

			val possibleAssignmentsClone = possibleAssignments.clone()
			possibleAssignmentsClone.clearRow(pivotNode)
			possibleAssignmentsClone[pivotNode, possibleMNode] = 1.0
			search(assignment, possibleAssignmentsClone)

			assignment.remove(pivotNode)
		})
	}

	// prune possible assignments on the following logic:
	// for every candidate node (cNode), for every possible master node assignment (mNode), check
	// whether cNode's neighbours will have suitable neighbours from mNode (by checking for nodes
	// with a equal or greater degree that exist as possible assignments). if there would be no
	// suitable neighbours then cNode cannot be assigned to mNode, so remove mNode from cNode's
	// possible assignment list. this may cause other assignments to become impossible, so repeat
	// this process until no more changes are made.
	private fun prunePossibleAssignments(possibleAssignments: Matrix) {
		var changes = true
		while (changes) {
			changes = false

			// for every candidate node (cNode)
			for (cNode in 0..candidate.nodeCount - 1) {

				// for every possible assignment (mNode) of cNode
				possibleAssignments.forEachOnRow(cNode, { mNode, value ->
					if (value != 1.0) return@forEachOnRow

					// for each of cNode's neighbours...
					for (cNodeNeighbour in candidate.getSuccessors(cNode)) {
						// check whether mNode has a suitable neighbour
						val mNodeHasSuitableNeighbour = (0..master.nodeCount - 1).any { mNodeNeighbour ->
							possibleAssignments[cNodeNeighbour, mNodeNeighbour] == 1.0 && master.hasEdge(mNode, mNodeNeighbour)
						}

						// if not, remove the cNode => mNode possible assignment
						if (!mNodeHasSuitableNeighbour) {
							possibleAssignments[cNode, mNode] = 0.0
							changes = true
							break
						}
					}
				})
			}
		}
	}

}
