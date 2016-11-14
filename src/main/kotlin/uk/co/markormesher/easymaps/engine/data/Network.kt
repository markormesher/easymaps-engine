package uk.co.markormesher.easymaps.engine.data

import uk.co.markormesher.easymaps.engine.structures.SparseSquareMatrix

class Network(private val n: Int) {

	private val adj = SparseSquareMatrix(n)
	val nodeLabels = Array(n, { i -> "$i" })

	fun addEdge(from: Int, to: Int) {
		if (from < 0 || from >= n) throw IndexOutOfBoundsException("from = $from, size = $n")
		if (to < 0 || to >= n) throw IndexOutOfBoundsException("to = $to, size = $n")

		if (adj[from, to] == 0.0) {
			adj[from, to] = 1.0
			++edgeCount
		}
	}

	fun hasEdge(from: Int, to: Int): Boolean {
		if (from < 0 || from >= n) throw IndexOutOfBoundsException("from = $from, size = $n")
		if (to < 0 || to >= n) throw IndexOutOfBoundsException("to = $to, size = $n")

		return adj[from, to] != 0.0
	}

	fun forEachEdge(exec: (from: Int, to: Int) -> Unit) {
		adj.forEachNonZero { from, to, weight -> exec(from, to) }
	}

	val nodeCount: Int
		get() = n

	var edgeCount = 0
		private set

}