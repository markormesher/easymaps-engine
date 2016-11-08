package uk.co.markormesher.easymaps.engine.structures

interface Matrix {

	operator fun get(row: Int, col: Int): Double

	operator fun set(row: Int, col: Int, value: Double)

	val width: Int

	val height: Int

	fun clone(): Matrix

}