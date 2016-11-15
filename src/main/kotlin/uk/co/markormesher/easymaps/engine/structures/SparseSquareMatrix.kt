package uk.co.markormesher.easymaps.engine.structures

class SparseSquareMatrix(private val n: Int) : Matrix {

	init {
		if (n <= 0) throw IllegalArgumentException("Size must be greater than zero")
	}

	private val rows = Array(n, { SparseVector(n) })

	override operator fun get(row: Int, col: Int): Double {
		if (row < 0 || row >= n) throw IndexOutOfBoundsException("row = $row; size = $n")
		if (col < 0 || col >= n) throw IndexOutOfBoundsException("col = $col; size = $n")
		return rows[row][col]
	}

	override operator fun set(row: Int, col: Int, value: Double) {
		if (row < 0 || row >= n) throw IndexOutOfBoundsException("row = $row; size = $n")
		if (col < 0 || col >= n) throw IndexOutOfBoundsException("col = $col; size = $n")
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

	// TODO: tests for getRow()
	fun getRow(row: Int): SparseVector {
		if (row < 0 || row >= n) throw IndexOutOfBoundsException("row = $row; size = $n")
		return rows[row]
	}

	// TODO: implement getColumn()
	// TODO: tests for getColumn()
	fun getColumn(col: Int): SparseVector {
		throw Exception("Unimplemented")
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