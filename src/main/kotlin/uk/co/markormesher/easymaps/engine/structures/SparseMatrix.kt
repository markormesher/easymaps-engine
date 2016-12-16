package uk.co.markormesher.easymaps.engine.structures

class SparseMatrix<E>(override val width: Int, override val height: Int, private val default: E): Matrix<E> {

	init {
		if (width <= 0) throw IllegalArgumentException("Width must be greater than zero")
		if (height <= 0) throw IllegalArgumentException("Height must be greater than zero")
	}

	private val rows = Array(height, { SparseVector(width, default) })

	val size: Int
		get() = width * height

	val realSize: Int
		get() = rows.fold(0, { sum, row -> sum + row.realSize })

	val density: Double
		get() = realSize / size.toDouble()

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

	override fun getRow(row: Int): SparseVector<E> {
		validateIndex(row, width, "row")

		return rows[row].clone()
	}

	override fun getColumn(column: Int): SparseVector<E> {
		validateIndex(column, width, "col")

		val tempColumn = SparseVector(height, default)
		forEachNonDefault { r, c, v -> if (column == c) tempColumn[r] = v }
		return tempColumn
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

	fun forEachNonDefaultOnRow(row: Int, exec: (Int, E) -> Unit) {
		getRow(row).forEachNonDefault { pos, value -> exec(pos, value) }
	}

	override fun forEachOnColumn(column: Int, exec: (Int, E) -> Unit) {
		getColumn(column).forEach { pos, value -> exec(pos, value) }
	}

	fun forEachNonDefaultOnColumn(column: Int, exec: (Int, E) -> Unit) {
		getColumn(column).forEachNonDefault { pos, value -> exec(pos, value) }
	}

	override fun clear() {
		rows.forEach { it.clear() }
	}

	override fun clearRow(row: Int) {
		validateIndex(row, height, "row")
		rows[row].clear()
	}

	override fun clearColumn(column: Int) {
		validateIndex(column, width, "column")
		(0..height - 1).forEach { row -> set(row, column, default) }
	}

	override fun clone(): SparseMatrix<E> {
		val output = SparseMatrix(width, height, default)
		forEachNonDefault { row, column, value -> output[row, column] = value }
		return output
	}

}
