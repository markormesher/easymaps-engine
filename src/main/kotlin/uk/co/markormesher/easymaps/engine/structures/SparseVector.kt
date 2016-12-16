package uk.co.markormesher.easymaps.engine.structures

import java.util.*

class SparseVector<E>(val size: Int, private val default: E) {

	private val map = HashMap<Int, E>()

	init {
		if (size <= 0) throw IllegalArgumentException("Size must be greater than zero")
	}

	val realSize: Int
		get() = map.size

	operator fun set(index: Int, value: E) {
		validateIndex(index, size)
		if (value == default) {
			map.remove(index)
		} else {
			map.put(index, value)
		}
	}

	operator fun get(index: Int): E {
		validateIndex(index, size)
		return map[index] ?: default
	}

	fun forEach(exec: (position: Int, value: E) -> Unit) {
		for (position in 0..size - 1) {
			exec(position, get(position))
		}
	}

	fun forEachNonDefault(exec: (position: Int, value: E) -> Unit) = map.forEach(exec)

	fun clear() = map.clear()

	fun clone(): SparseVector<E> {
		val output = SparseVector(size, default)
		forEachNonDefault { position, value -> output[position] = value }
		return output
	}

}
