package uk.co.markormesher.easymaps.engine.structures

interface Matrix {

	operator fun get(row: Int, col: Int): Double

	operator fun set(row: Int, col: Int, value: Double)

	fun clear()

	fun clearRow(row: Int)

	fun clearColumn(column: Int)

	val width: Int

	val height: Int

	fun clone(): Matrix

}
