package uk.co.markormesher.easymaps.engine.structures

import java.util.*

class DisjointSet(private val size: Int) {

	private val parent = IntArray(size, { i -> i })
	private val rank = IntArray(size, { i -> 1 })
	private val rootPositions = HashMap<Int, Int>()
	var setCount = size

	fun findRoot(i: Int): Int {
		if (i < 0 || i >= size) throw IndexOutOfBoundsException("index = $i, size = $size")

		if (parent[i] == i) {
			return i
		} else {
			// recursion with path compression
			return { parent[i] = findRoot(parent[i]); parent[i] }()
		}
	}

	fun findRootPosition(i: Int): Int {
		if (i < 0 || i >= size) throw IndexOutOfBoundsException("index = $i, size = $size")

		val root = findRoot(i)
		if (!rootPositions.containsKey(root)) throw Exception("No known position for root $root")
		return rootPositions[root]!!
	}

	fun join(a: Int, b: Int) {
		if (a < 0 || a >= size) throw IndexOutOfBoundsException("index = $a, size = $size")
		if (b < 0 || b >= size) throw IndexOutOfBoundsException("index = $b, size = $size")

		val aRoot = findRoot(a)
		val bRoot = findRoot(b)

		// join by rank heuristic
		if (aRoot != bRoot) {
			if (rank[aRoot] > rank[bRoot]) {
				parent[bRoot] = aRoot
			} else {
				parent[aRoot] = bRoot
				if (rank[aRoot] == rank[bRoot]) {
					rank[bRoot]++
				}
			}

			--setCount
		}
	}

	/**
	 * Generates a mapping from n root nodes to their positions in 0..n - 1.
	 */
	fun generateRootPositions() {
		rootPositions.clear()
		parent.forEachIndexed { i, p -> if (i == p) rootPositions[p] = rootPositions.size }
	}

}