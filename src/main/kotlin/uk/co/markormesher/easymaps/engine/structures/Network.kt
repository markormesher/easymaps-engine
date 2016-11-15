package uk.co.markormesher.easymaps.engine.structures

import java.util.*

class Network(private val n: Int) {

	// TODO: tests for network creation
	private val adj = SparseSquareMatrix(n)
	val nodeLabels = Array(n, { i -> "$i" })

	// TODO: tests for addEdge()
	fun addEdge(from: Int, to: Int) {
		if (from < 0 || from >= n) throw IndexOutOfBoundsException("from = $from, size = $n")
		if (to < 0 || to >= n) throw IndexOutOfBoundsException("to = $to, size = $n")

		if (adj[from, to] == 0.0) {
			adj[from, to] = 1.0
			++edgeCount
		}
	}

	// TODO: tests for hasEdge()
	fun hasEdge(from: Int, to: Int): Boolean {
		if (from < 0 || from >= n) throw IndexOutOfBoundsException("from = $from, size = $n")
		if (to < 0 || to >= n) throw IndexOutOfBoundsException("to = $to, size = $n")

		return adj[from, to] != 0.0
	}

	// TODO: tests for edge iteration
	fun forEachEdge(exec: (from: Int, to: Int) -> Unit) {
		adj.forEachNonZero { from, to, weight -> exec(from, to) }
	}

	// TODO: tests for getSuccessors()
	fun getSuccessors(from: Int): List<Int> {
		val row = adj.getRow(from)
		val successors = ArrayList<Int>(row.nonZeroSize)
		row.forEach { to, weight -> successors.add(to) }
		return successors
	}

	// TODO: tests for node count value
	val nodeCount: Int
		get() = n

	// TODO: tests for edge count value
	var edgeCount = 0
		private set

}