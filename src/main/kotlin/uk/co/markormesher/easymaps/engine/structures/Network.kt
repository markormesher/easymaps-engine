package uk.co.markormesher.easymaps.engine.structures

import java.util.*

class Network(private val n: Int) {

	private val adj = SparseMatrix(n, n, 0)
	private val nodeLabels = HashMap<Int, String>()

	fun addEdge(from: Int, to: Int) {
		validateIndex(from, n, "from")
		validateIndex(to, n, "to")

		if (adj[from, to] == 0) {
			adj[from, to] = 1
			++_edgeCount
		}
	}

	fun removeEdge(from: Int, to: Int) {
		validateIndex(from, n, "from")
		validateIndex(to, n, "to")

		if (adj[from, to] != 0) {
			adj[from, to] = 0
			--_edgeCount
		}
	}

	fun hasEdge(from: Int, to: Int): Boolean {
		validateIndex(from, n, "from")
		validateIndex(to, n, "to")

		return adj[from, to] != 0
	}

	fun forEachEdge(exec: (from: Int, to: Int) -> Unit) {
		adj.forEachNonDefault { from, to, weight -> exec(from, to) }
	}

	fun getSuccessors(from: Int): List<Int> {
		validateIndex(from, n, "from")

		val row = adj.getRow(from)
		val successors = ArrayList<Int>(row.realSize)
		row.forEachNonDefault { to, weight -> successors.add(to) }
		return successors
	}

	fun setNodeLabel(node: Int, label: String) {
		validateIndex(node, n, "node")

		nodeLabels.put(node, label)
	}

	fun nodeLabel(node: Int): String = nodeLabels[node] ?: node.toString()

	fun nodeDegree(node: Int): Int {
		validateIndex(node, n, "node")

		return adj.getRow(node).realSize
	}

	val nodeCount: Int
		get() = n

	private var _edgeCount = 0
	val edgeCount: Int
		get() = _edgeCount

}
