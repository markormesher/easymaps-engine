package uk.co.markormesher.easymaps.engine.data

import uk.co.markormesher.easymaps.engine.structures.SparseSquareMatrix

class Network(private val n: Int) {

	private val adj = SparseSquareMatrix(n)

	fun addEdge(from: Int, to: Int) {
		if (from < 0 || from >= n) throw IndexOutOfBoundsException("from = $from, size = $n")
		if (to < 0 || to >= n) throw IndexOutOfBoundsException("to = $to, size = $n")

		adj[from, to] = 1.0
	}

	fun hasEdge(from: Int, to: Int): Boolean {
		if (from < 0 || from >= n) throw IndexOutOfBoundsException("from = $from, size = $n")
		if (to < 0 || to >= n) throw IndexOutOfBoundsException("to = $to, size = $n")

		return adj[from, to] != 0.0
	}

	fun forEachEdge(exec: (from: Int, to: Int) -> Unit) {
		adj.forEachNonZero { from, to, weight -> exec(from, to) }
	}

}