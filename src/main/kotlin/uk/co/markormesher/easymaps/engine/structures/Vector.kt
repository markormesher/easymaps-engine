package uk.co.markormesher.easymaps.engine.structures

interface Vector<E> {

	val size: Int

	operator fun set(i: Int, value: E)

	operator fun get(i: Int): E

	fun forEach(exec: (position: Int, value: E) -> Unit)

	fun clear()

	fun clone(): Vector<E>

}
