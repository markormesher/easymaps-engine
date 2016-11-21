package uk.co.markormesher.easymaps.engine.structures

import java.util.*

class Network(private val n: Int) {

	private val adj = SparseSquareMatrix(n)
	private val nodeLabels = HashMap<Int, String>()

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

	fun removeEdge(from: Int, to: Int) {
		validateIndex(from, "from")
		validateIndex(to, "to")

		if (adj[from, to] != 0.0) {
			adj[from, to] = 0.0
			--_edgeCount
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
		validateIndex(from, "from")
		val row = adj.getRow(from)
		val successors = ArrayList<Int>(row.nonZeroSize)
		row.forEach { to, weight -> successors.add(to) }
		return successors
	}

	fun setNodeLabel(node: Int, label: String) {
		validateIndex(node, "node")
		nodeLabels.put(node, label)
	}

	fun nodeLabel(node: Int): String = nodeLabels[node] ?: node.toString()

	// TODO: tests
	fun reOrderByNodeDegree() {
		/*val mapping = Array(nodeCount, { i -> Pair(nodeDegree(i), i) })
				.sortedWith(compareBy { i -> i.first })
				.reversed()
				.map { i -> i.second }*/

		val mapping = Array(nodeCount, { i -> (i + 1) % nodeCount })

		// re-map edges
		val edges = ArrayList<Pair<Int, Int>>(edgeCount)
		forEachEdge { i, j -> edges.add(Pair(i, j)) }
		edges.forEach { e -> removeEdge(e.first, e.second) }
		edges.forEach { e -> addEdge(mapping[e.first], mapping[e.second]) }

		// re-map labels
		val nodeLabelsCopy = HashMap<Int, String>(nodeLabels)
		nodeLabels.clear()
		nodeLabelsCopy.forEach { node, label -> nodeLabels.put(mapping[node], label) }
	}

	fun nodeDegree(node: Int): Int {
		validateIndex(node, "node")
		return adj.getRow(node).nonZeroSize
	}

	val nodeCount: Int
		get() = n

	private var _edgeCount = 0
	val edgeCount: Int
		get() = _edgeCount

}