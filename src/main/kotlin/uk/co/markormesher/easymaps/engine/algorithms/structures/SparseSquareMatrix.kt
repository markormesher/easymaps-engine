package uk.co.markormesher.easymaps.engine.algorithms.structures

class SparseSquareMatrix(private val n: Int) : Matrix() {

	init {
		if (n <= 0) throw IllegalArgumentException("Size must be greater than zero")
	}

	private val rows = Array(n, { SparseVector(n) })

	override operator fun get(row: Int, col: Int) = rows[row][col]

	override operator fun set(row: Int, col: Int, value: Double) {
		rows[row][col] = value
	}

	override val width: Int
		get() = n

	override val height: Int
		get() = n

	val possibleValues: Int
		get() = n * n

	val nonDefaultValues: Int
		get() = rows.fold(0, { sum, row -> sum + row.nonDefaultValues })

	val density: Double
		get() = nonDefaultValues / possibleValues.toDouble()

	override fun copy(): Matrix {
		val output = SparseSquareMatrix(n)
		forAllRowsAndCols { row, col -> output[row, col] = this[row, col] }
		return output
	}

	override fun toString(): String {
		val sb = StringBuilder()
		for (row in 0..n - 1) {
			for (col in 0..n - 1) {
				sb.append(this[row, col].toString()).append(" ")
			}
			sb.append("\n")
		}
		return sb.toString()
	}

}