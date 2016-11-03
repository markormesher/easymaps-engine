package uk.co.markormesher.easymaps.engine.helpers

class SparseSquareMatrix<T>(private val n: Int, private val default: T) {

	init {
		if (n <= 0) throw IllegalArgumentException("Size must be greater than zero")
	}

	private val rows = Array(n, { SparseVector(n, default) })

	operator fun get(row: Int, col: Int) = rows[row][col]

	operator fun set(row: Int, col: Int, value: T) {
		rows[row][col] = value
	}

	val size: Int
		get() = n

	val possibleValues: Int
		get() = n * n

	val nonDefaultValues: Int
		get() = rows.fold(0, { sum, row -> sum + row.nonDefaultValues })

	val density: Double
		get() = nonDefaultValues / possibleValues.toDouble()

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