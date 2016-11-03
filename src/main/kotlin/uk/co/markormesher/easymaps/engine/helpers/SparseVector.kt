package uk.co.markormesher.easymaps.engine.helpers

import java.util.*

class SparseVector<T>(private val n: Int, private val default: T) {

	private val map = TreeMap<Int, T>()

	init {
		if (n <= 0) throw IllegalArgumentException("Size must be greater than zero")
	}

	operator fun set(i: Int, value: T) {
		if (i < 0 || i >= n) throw IndexOutOfBoundsException("index = $i; n = $n")
		if (value == default) remove(i)
		map.put(i, value)
	}

	operator fun get(i: Int): T {
		if (i < 0 || i >= n) throw IndexOutOfBoundsException("index = $i; n = $n")
		return map[i] ?: default
	}

	fun remove(i: Int) {
		map.remove(i)
	}

	val size: Int
		get() = n

	val nonDefaultValues: Int
		get() = map.size

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