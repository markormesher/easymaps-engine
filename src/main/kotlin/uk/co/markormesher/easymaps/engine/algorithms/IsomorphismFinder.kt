package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*

abstract class IsomorphismFinder(val candidate: Network, val master: Network) {

	protected val isomorphisms = ArrayList<Map<Int, Int>>()

	fun findIsomorphisms(): List<Map<Int, Int>> {
		isomorphisms.clear()
		beginSearch()
		return isomorphisms
	}

	abstract fun beginSearch()

	// check that the assignment created so far don't create any edges that should not exist
	open fun validateAssignment(assignment: Map<Int, Int>, lastAssigned: Int = -1): Boolean {
		var failed = false
		candidate.forEachEdge { from, to ->
			if (failed) return@forEachEdge
			if (from == lastAssigned || to == lastAssigned) {
				val assignedFrom = assignment[from] ?: return@forEachEdge
				val assignedTo = assignment[to] ?: return@forEachEdge
				if (!master.hasEdge(assignedFrom, assignedTo)) {
					failed = true
				}
			}
		}
		return !failed
	}

	open fun submitResult(assignment: Map<Int, Int>) = synchronized(isomorphisms, {
		val clone = HashMap<Int, Int>(candidate.nodeCount)
		clone.putAll(assignment)
		isomorphisms.add(clone)
	})

}
