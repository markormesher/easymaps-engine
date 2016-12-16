package uk.co.markormesher.easymaps.engine.structures

import java.util.*

class SparseVector<E>(private val n: Int, private val default: E) : Vector<E> {

	private val map = HashMap<Int, E>()

	init {
		if (n <= 0) throw IllegalArgumentException("Size must be greater than zero")
	}

	override val size: Int
		get() = n

	val realSize: Int
		get() = map.size

	override operator fun set(i: Int, value: E) {
		validateIndex(i, n, "i")

		if (value == default) {
			map.remove(i)
			return
		}
		map.put(i, value)
	}

	override operator fun get(i: Int): E {
		validateIndex(i, n, "i")

		return map[i] ?: default
	}

	val nonDefaultValues: MutableCollection<E>
		get() = map.values

	override fun forEach(exec: (position: Int, value: E) -> Unit) {
		for (position in 0..size - 1) {
			exec(position, get(position))
		}
	}

	fun forEachNonDefault(exec: (position: Int, value: E) -> Unit) = map.forEach(exec)

	override fun clear() = map.clear()

	override fun clone(): SparseVector<E> {
		val output = SparseVector(n, default)
		forEachNonDefault { position, value -> output[position] = value }
		return output
	}

}
