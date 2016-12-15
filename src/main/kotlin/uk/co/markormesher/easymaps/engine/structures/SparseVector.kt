package uk.co.markormesher.easymaps.engine.structures

import java.util.*

class SparseVector(private val n: Int) : Vector {

	private val map = TreeMap<Int, Double>()

	init {
		if (n <= 0) throw IllegalArgumentException("Size must be greater than zero")
	}

	override operator fun set(i: Int, value: Double) {
		validateIndex(i, n, "i")

		if (value == 0.0) {
			map.remove(i)
			return
		}
		map.put(i, value)
	}

	override operator fun get(i: Int): Double {
		validateIndex(i, n, "i")

		return map[i] ?: 0.0
	}

	override fun clear() = map.clear()

	override val size: Int
		get() = n

	val nonZeroSize: Int
		get() = map.size

	val nonZeroValues: MutableCollection<Double>
		get() = map.values

	fun forEach(exec: (position: Int, value: Double) -> Unit) = map.forEach(exec)

}
