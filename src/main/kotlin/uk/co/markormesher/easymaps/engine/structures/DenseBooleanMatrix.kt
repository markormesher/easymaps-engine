package uk.co.markormesher.easymaps.engine.structures

class DenseBooleanMatrix(val width: Int, val height: Int) {

	private val data: Array<Array<Boolean>>

	init {
		if (width <= 0) throw IllegalArgumentException("Width must be greater than zero")
		if (height <= 0) throw IllegalArgumentException("Height must be greater than zero")
		data = Array(height, { Array(width, { false }) })
	}

	operator fun set(row: Int, col: Int, value: Boolean) {
		validateIndex(row, height, "row")
		validateIndex(col, width, "col")
		data[row][col] = value
	}

	operator fun get(row: Int, col: Int): Boolean {
		validateIndex(row, height, "row")
		validateIndex(col, width, "col")
		return data[row][col]
	}

	fun forEach(exec: (Int, Int, Boolean) -> Unit) {
		for (row in 0..height - 1) {
			for (column in 0..width - 1) {
				exec(row, column, get(row, column))
			}
		}
	}

	fun forEachOnRow(row: Int, exec: (Int, Boolean) -> Unit) {
		validateIndex(row, width, "row")
		data[row].forEachIndexed { pos, value -> exec(pos, value) }
	}

	fun clearRow(row: Int) {
		validateIndex(row, height, "row")
		data[row].fill(false)
	}

	fun clone(): DenseBooleanMatrix {
		val output = DenseBooleanMatrix(width, height)
		forEach { row, column, value -> output[row, column] = value }
		return output
	}

}
