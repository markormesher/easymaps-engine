package uk.co.markormesher.easymaps.engine.structures

interface Matrix {

	val width: Int

	val height: Int

	operator fun set(row: Int, col: Int, value: Double)

	operator fun get(row: Int, col: Int): Double

	fun getRow(row: Int): Vector

	fun getColumn(column: Int): Vector

	fun forEachOnRow(row: Int, exec: (Int, Double) -> Unit)

	fun forEachOnColumn(column: Int, exec: (Int, Double) -> Unit)

	fun clear()

	fun clearRow(row: Int)

	fun clearColumn(column: Int)

	fun clone(): Matrix

}
