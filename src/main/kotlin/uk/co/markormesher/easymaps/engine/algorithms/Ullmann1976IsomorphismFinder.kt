package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubInfo
import uk.co.markormesher.easymaps.engine.structures.Network
import uk.co.markormesher.easymaps.engine.structures.SparseMatrix
import java.util.*

/*
Approach: use a boolean matrix to track possible assignments: a 1 at [r, c] indicates that
candidate node r could possible be assigned to master node c. Depth first search is used,
with the search space being pruned at each step, as explained below.
*/

class Ullmann1976IsomorphismFinder(val candidate: Network, val master: Network): IsomorphismFinder {

	val isomorphisms = ArrayList<Map<Int, Int>>()

	override fun findIsomorphisms(): List<Map<Int, Int>> {
		isomorphisms.clear()
		search(HashSet<Int>(), 0, createInitialMatrix())
		return isomorphisms
	}

	private fun createInitialMatrix(): SparseMatrix {
		val m = SparseMatrix(master.nodeCount, candidate.nodeCount)
		(0..candidate.nodeCount - 1).forEach { cNode ->
			(0..master.nodeCount - 1).forEach { mNode ->
				if (master.nodeDegree(mNode) >= candidate.nodeDegree(cNode)) m[cNode, mNode] = 1.0
			}
		}
		return m
	}

	private fun search(usedColumns: MutableSet<Int>, currentRow: Int, assignmentMatrix: SparseMatrix) {

		printInfo("$currentRow")

		if (currentRow == assignmentMatrix.height) {
			// condense the assignment matrix into a single assignment map
			val assignment = HashMap<Int, Int>(candidate.nodeCount)
			assignmentMatrix.forEachNonZero { cNode, mNode, v -> assignment.put(cNode, mNode) }

			// validate the assignment
			var valid = true
			candidate.forEachEdge { from, to ->
				if (!valid) return@forEachEdge
				val assignedFrom = assignment[from]
				val assignedTo = assignment[to]
				if (assignedFrom != null && assignedTo != null) {
					if (!master.hasEdge(assignedFrom, assignedTo)) {
						valid = false
					}
				}
			}

			// save valid isomorphisms
			if (valid) isomorphisms.add(assignment)

			return
		}

		val assignmentMatrixClone = assignmentMatrix.clone()
		// prune mP

		val unusedColumns = (0..master.nodeCount - 1).toList().filter { !usedColumns.contains(it) }
		printSubInfo("Unused: $unusedColumns")
		unusedColumns.forEach { col ->
			assignmentMatrixClone.clearRow(currentRow)
			assignmentMatrixClone[currentRow, col] = 1.0
			usedColumns.add(col)
			search(usedColumns, currentRow + 1, assignmentMatrixClone)
			usedColumns.remove(col)
		}
	}

}
