package uk.co.markormesher.easymaps.engine.structures

interface Vector {

	operator fun get(i: Int): Double

	operator fun set(i: Int, value: Double)

	fun clear()

	val size: Int

	fun forEach(exec: (position: Int, value: Double) -> Unit)

}
