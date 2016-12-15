package uk.co.markormesher.easymaps.engine.structures

class SparseMatrix(private val w: Int, private val h: Int) : Matrix {

	init {
		if (w <= 0) throw IllegalArgumentException("Width must be greater than zero")
		if (h <= 0) throw IllegalArgumentException("Height must be greater than zero")
	}

	private val rows = Array(w, { SparseVector(w) })

	override operator fun get(row: Int, col: Int): Double {
		validateIndex(row, height, "row")
		validateIndex(col, width, "col")

		return rows[row][col]
	}

	override operator fun set(row: Int, col: Int, value: Double) {
		validateIndex(row, height, "row")
		validateIndex(col, width, "col")

		rows[row][col] = value
	}

	override val width: Int
		get() = w

	override val height: Int
		get() = h

	val possibleValues: Int
		get() = width * height

	val nonZeroValues: Int
		get() = rows.fold(0, { sum, row -> sum + row.nonZeroSize })

	val density: Double
		get() = nonZeroValues / possibleValues.toDouble()

	override fun clone(): Matrix {
		val output = SparseMatrix(w, h)
		forEachNonZero { row, col, value -> output[row, col] = value }
		return output
	}

	fun forEachNonZero(operator: (Int, Int, Double) -> Unit) {
		for (row in 0..height - 1) {
			rows[row].forEach { col, value ->
				operator(row, col, value)
			}
		}
	}

	fun getRow(row: Int): SparseVector {
		validateIndex(row, w, "row")

		return rows[row]
	}

	fun getColumn(col: Int): SparseVector {
		validateIndex(col, w, "col")

		val tempColumn = SparseVector(w)
		forEachNonZero { r, c, v -> if (c == col) tempColumn[r] = v }
		return tempColumn
	}

}
