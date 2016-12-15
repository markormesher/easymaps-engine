package uk.co.markormesher.easymaps.engine.structures

class SparseMatrix(private val w: Int, private val h: Int): Matrix {

	init {
		if (w <= 0) throw IllegalArgumentException("Width must be greater than zero")
		if (h <= 0) throw IllegalArgumentException("Height must be greater than zero")
	}

	private val rows = Array(w, { SparseVector(w) })

	override val width: Int
		get() = w

	override val height: Int
		get() = h

	val maxSize: Int
		get() = width * height

	val nonZeroSize: Int
		get() = rows.fold(0, { sum, row -> sum + row.nonZeroSize })

	val density: Double
		get() = nonZeroSize / maxSize.toDouble()

	override operator fun set(row: Int, col: Int, value: Double) {
		validateIndex(row, height, "row")
		validateIndex(col, width, "col")

		rows[row][col] = value
	}

	override operator fun get(row: Int, col: Int): Double {
		validateIndex(row, height, "row")
		validateIndex(col, width, "col")

		return rows[row][col]
	}

	override fun getRow(row: Int): SparseVector {
		validateIndex(row, w, "row")

		// TODO: replace with .clone()
		val tempRow = SparseVector(w)
		rows[row].forEach { pos, value -> tempRow[pos] = value }
		return tempRow
	}

	override fun getColumn(column: Int): SparseVector {
		validateIndex(column, w, "col")

		val tempColumn = SparseVector(h)
		forEachNonZero { r, c, v -> if (c == column) tempColumn[r] = v }
		return tempColumn
	}

	override fun forEachOnRow(row: Int, exec: (Int, Double) -> Unit) {
		getRow(row).forEach { pos, value -> exec(pos, value) }
	}

	override fun forEachOnColumn(column: Int, exec: (Int, Double) -> Unit) {
		getColumn(column).forEach { pos, value -> exec(pos, value) }
	}

	fun forEachNonZero(operator: (Int, Int, Double) -> Unit) {
		for (row in 0..height - 1) {
			rows[row].forEach { col, value ->
				operator(row, col, value)
			}
		}
	}

	override fun clear() {
		rows.forEach { it.clear() }
	}

	override fun clearRow(row: Int) {
		validateIndex(row, h, "row")
		rows[row].clear()
	}

	override fun clearColumn(column: Int) {
		validateIndex(column, w, "column")
		(0..height - 1).forEach { row -> set(row, column, 0.0) }
	}

	override fun clone(): SparseMatrix {
		val output = SparseMatrix(w, h)
		forEachNonZero { row, col, value -> output[row, col] = value }
		return output
	}

}
