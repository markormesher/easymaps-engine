package uk.co.markormesher.easymaps.engine.structures

import java.util.*

class Network(private val n: Int) {

	private val adj = SparseSquareMatrix(n)
	val nodeLabels = Array(n, { i -> "$i" })

	internal fun validateIndex(index: Int, label: String = "index") {
		if (index < 0 || index >= n) throw IndexOutOfBoundsException("$label = $index, size = $n")
	}

	fun addEdge(from: Int, to: Int) {
		validateIndex(from, "from")
		validateIndex(to, "to")

		if (adj[from, to] == 0.0) {
			adj[from, to] = 1.0
			++_edgeCount
		}
	}

	fun hasEdge(from: Int, to: Int): Boolean {
		validateIndex(from, "from")
		validateIndex(to, "to")

		return adj[from, to] != 0.0
	}

	fun forEachEdge(exec: (from: Int, to: Int) -> Unit) {
		adj.forEachNonZero { from, to, weight -> exec(from, to) }
	}

	fun getSuccessors(from: Int): List<Int> {
		val row = adj.getRow(from)
		val successors = ArrayList<Int>(row.nonZeroSize)
		row.forEach { to, weight -> successors.add(to) }
		return successors
	}

	val nodeCount: Int
		get() = n

	private var _edgeCount = 0
	val edgeCount: Int
		get() = _edgeCount

}