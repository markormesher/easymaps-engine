package uk.co.markormesher.easymaps.engine.algorithms.structures

abstract class Matrix {

	operator abstract fun get(row: Int, col: Int): Double

	operator abstract fun set(row: Int, col: Int, value: Double)

	abstract val width: Int

	abstract val height: Int

	abstract fun copy(): Matrix

	fun forAllRowsAndCols(operator: (Int, Int) -> Unit) {
		for (row in 0..height - 1) {
			for (col in 0..width - 1) {
				operator(row, col)
			}
		}
	}

}