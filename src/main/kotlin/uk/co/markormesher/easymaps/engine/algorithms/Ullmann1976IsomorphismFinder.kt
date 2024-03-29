package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine.structures.DenseMatrix
import uk.co.markormesher.easymaps.engine.structures.Matrix
import uk.co.markormesher.easymaps.engine.structures.Network
import uk.co.markormesher.easymaps.engine.structures.SparseMatrix
import java.util.*

/*
Approach: perform a depth-first-search of all possible node assignments, pruning branches
when an impossible assignment is reached, pivoting on nodes in descending degree order, and
limiting the search space by removing possible assignments in the manner described below.
*/

class Ullmann1976IsomorphismFinder(candidate: Network, master: Network, val mode: Mode): IsomorphismFinder(candidate, master) {

	val candidatePivotOrder by lazy { calcCandidatePivotOrder() }

	override fun beginSearch() {
		search(HashMap<Int, Int>(candidate.nodeCount), calcInitialPossibleAssignments())
	}

	// calc the order in which candidate nodes should be selected as pivots (descending degree order for modified search)
	private fun calcCandidatePivotOrder(): Array<Int> {
		if (mode == Mode.UNMODIFIED_DENSE || mode == Mode.UNMODIFIED_SPARSE) {
			return Array(candidate.nodeCount, { i -> i })
		} else {
			return Array(candidate.nodeCount, { i -> i }).sortedByDescending({ i -> candidate.nodeDegree(i) }).toTypedArray()
		}
	}

	// for all candidate nodes, calc the list of master nodes that are of equal or higher degree
	private fun calcInitialPossibleAssignments(): Matrix<Boolean> {
		val m: Matrix<Boolean>
		if (mode == Mode.UNMODIFIED_DENSE || mode == Mode.MODIFIED_DENSE) {
			m = DenseMatrix(master.nodeCount, candidate.nodeCount, false, { w, h -> Array(w * h, { false }) })
		} else {
			m = SparseMatrix(master.nodeCount, candidate.nodeCount, false)
		}
		for (cNode in 0..candidate.nodeCount - 1) {
			(0..master.nodeCount - 1)
					.filter { mNode -> candidate.nodeDegree(cNode) <= master.nodeDegree(mNode) }
					.forEach { mNode -> m[cNode, mNode] = true }
		}
		return m
	}

	private fun search(assignment: MutableMap<Int, Int>, possibleAssignments: Matrix<Boolean>, lastAssigned: Int = -1) {
		// if we reached an impossible assignment, backtrack
		if (!validateAssignment(assignment, lastAssigned)) return

		// if all nodes of the candidate network have assignment, we're done
		if (assignment.size == candidate.nodeCount) {
			submitResult(assignment)
			return
		}

		val pivotNode = candidatePivotOrder[assignment.size]
		prunePossibleAssignments(possibleAssignments)
		possibleAssignments.forEachNonDefaultOnRow(pivotNode, { possibleMNode, edge ->
			if (assignment.containsValue(possibleMNode)) return@forEachNonDefaultOnRow

			assignment.put(pivotNode, possibleMNode)

			val possibleAssignmentsClone = possibleAssignments.clone()
			possibleAssignmentsClone.clearRow(pivotNode)
			possibleAssignmentsClone[pivotNode, possibleMNode] = true
			search(assignment, possibleAssignmentsClone, pivotNode)

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
	private fun prunePossibleAssignments(possibleAssignments: Matrix<Boolean>) {
		var changes = true
		while (changes) {
			changes = false

			// for every candidate node (cNode)
			for (cNode in 0..candidate.nodeCount - 1) {

				// for every possible assignment (mNode) of cNode
				possibleAssignments.forEachNonDefaultOnRow(cNode, { mNode, edge ->

					// for each of cNode's neighbours...
					for (cNodeNeighbour in candidate.getSuccessors(cNode)) {

						// check whether mNode has a suitable neighbour
						val mNodeHasSuitableNeighbour = (0..master.nodeCount - 1).any { mNodeNeighbour ->
							possibleAssignments[cNodeNeighbour, mNodeNeighbour] && master.hasEdge(mNode, mNodeNeighbour)
						}

						// if not, remove the cNode => mNode possible assignment
						if (!mNodeHasSuitableNeighbour) {
							possibleAssignments[cNode, mNode] = false
							changes = true
							break
						}
					}
				})
			}
		}
	}

	enum class Mode {
		UNMODIFIED_DENSE,
		UNMODIFIED_SPARSE,
		MODIFIED_DENSE,
		MODIFIED_SPARSE
	}

}
