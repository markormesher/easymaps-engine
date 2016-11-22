package uk.co.markormesher.easymaps.engine.structures

class SparseSquareMatrix(private val n: Int) : Matrix {

	init {
		if (n <= 0) throw IllegalArgumentException("Size must be greater than zero")
	}

	private val rows = Array(n, { SparseVector(n) })

	override operator fun get(row: Int, col: Int): Double {
		validateIndex(row, n, "row")
		validateIndex(col, n, "col")

		return rows[row][col]
	}

	override operator fun set(row: Int, col: Int, value: Double) {
		validateIndex(row, n, "row")
		validateIndex(col, n, "col")

		rows[row][col] = value
	}

	override val width: Int
		get() = n

	override val height: Int
		get() = n

	val possibleValues: Int
		get() = n * n

	val nonZeroValues: Int
		get() = rows.fold(0, { sum, row -> sum + row.nonZeroSize })

	val density: Double
		get() = nonZeroValues / possibleValues.toDouble()

	override fun clone(): Matrix {
		val output = SparseSquareMatrix(n)
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
		validateIndex(row, n, "row")

		return rows[row]
	}

	fun getColumn(col: Int): SparseVector {
		validateIndex(col, n, "col")

		val tempColumn = SparseVector(n)
		forEachNonZero { r, c, v -> if (c == col) tempColumn[r] = v }
		return tempColumn
	}

}