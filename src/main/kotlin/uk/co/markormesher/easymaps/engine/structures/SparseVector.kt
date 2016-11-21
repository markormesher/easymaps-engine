package uk.co.markormesher.easymaps.engine.structures

import java.util.*

class SparseVector(private val n: Int) : Vector {

	private val map = TreeMap<Int, Double>()

	init {
		if (n <= 0) throw IllegalArgumentException("Size must be greater than zero")
	}

	override operator fun set(i: Int, value: Double) {
		if (i < 0 || i >= n) throw IndexOutOfBoundsException("index = $i; size = $n")
		if (value == 0.0) {
			map.remove(i)
			return
		}
		map.put(i, value)
	}

	override operator fun get(i: Int): Double {
		if (i < 0 || i >= n) throw IndexOutOfBoundsException("index = $i; size = $n")
		return map[i] ?: 0.0
	}

	override val size: Int
		get() = n

	val nonZeroSize: Int
		get() = map.size

	val nonZeroValues: MutableCollection<Double>
		get() = map.values

	fun forEach(exec: (position: Int, value: Double) -> Unit) = map.forEach(exec)

	override fun toString(): String {
		val sb = StringBuilder()
		sb.append("[")
		sb.append(get(0))
		for (i in 1..n - 1) {
			sb.append(", ").append(get(i))
		}
		sb.append("]")
		return sb.toString()
	}

}