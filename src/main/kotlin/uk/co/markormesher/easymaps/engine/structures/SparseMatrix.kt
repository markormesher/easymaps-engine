package uk.co.markormesher.easymaps.engine.structures

class SparseMatrix<E>(val width: Int, val height: Int, private val default: E): Matrix<E> {

	init {
		if (width <= 0) throw IllegalArgumentException("Width must be greater than zero")
		if (height <= 0) throw IllegalArgumentException("Height must be greater than zero")
	}

	private val rows = Array(height, { SparseVector(width, default) })

	val storedValueCount: Int
		get() = rows.fold(0, { sum, row -> sum + row.realSize })

	val density: Double
		get() = storedValueCount / (width * height).toDouble()

	override operator fun set(row: Int, col: Int, value: E) {
		validateIndex(row, height, "row")
		validateIndex(col, width, "col")
		rows[row][col] = value
	}

	override operator fun get(row: Int, col: Int): E {
		validateIndex(row, height, "row")
		validateIndex(col, width, "col")
		return rows[row][col]
	}

	fun getRow(row: Int): SparseVector<E> {
		validateIndex(row, width, "row")
		return rows[row].clone()
	}

	override fun forEach(exec: (Int, Int, E) -> Unit) {
		for (row in 0..height - 1) {
			for (column in 0..width - 1) {
				exec(row, column, get(row, column))
			}
		}
	}

	fun forEachNonDefault(exec: (Int, Int, E) -> Unit) {
		for (row in 0..height - 1) {
			rows[row].forEachNonDefault { column, value -> exec(row, column, value) }
		}
	}

	override fun forEachOnRow(row: Int, exec: (Int, E) -> Unit) {
		getRow(row).forEach { pos, value -> exec(pos, value) }
	}

	override fun forEachNonDefaultOnRow(row: Int, exec: (Int, E) -> Unit) {
		getRow(row).forEachNonDefault { pos, value -> exec(pos, value) }
	}

	override fun clearRow(row: Int) {
		validateIndex(row, height, "row")
		rows[row].clear()
	}

	override fun clone(): SparseMatrix<E> {
		val output = SparseMatrix(width, height, default)
		forEachNonDefault { row, column, value -> output[row, column] = value }
		return output
	}

}
