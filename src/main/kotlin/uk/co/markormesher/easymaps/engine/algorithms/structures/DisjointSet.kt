package uk.co.markormesher.easymaps.engine.algorithms.structures

class DisjointSet(private val size: Int) {

	private val parent = IntArray(size, { i -> i })
	private val rank = IntArray(size, { i -> 1 })
	var setCount = size

	fun find(i: Int) : Int {
		if (parent[i] == i) {
			return i
		} else {
			// recursion with path compression
			return { parent[i] = find(parent[i]); parent[i] }()
		}
	}

	fun join(a: Int, b: Int) {
		if (a < 0 || a >= size) throw IndexOutOfBoundsException("a ($a) must be between 0 and ${size - 1}")
		if (b < 0 || b >= size) throw IndexOutOfBoundsException("b ($b) must be between 0 and ${size - 1}")

		val aRoot = find(a)
		val bRoot = find(b)

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

}