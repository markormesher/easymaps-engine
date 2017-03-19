package uk.co.markormesher.easymaps.engine.structures

class DenseMatrix<E>(val width: Int, val height: Int, val default: E, val init: (Int, Int) -> Array<E>): Matrix<E> {

	private val data: Array<E>

	init {
		if (width <= 0) throw IllegalArgumentException("Width must be greater than zero")
		if (height <= 0) throw IllegalArgumentException("Height must be greater than zero")
		data = init(width, height)
		if (data.size != width * height) throw IllegalArgumentException("Initialiser created array of size ${data.size}; expected ${width * height}")
	}

	private fun index(row: Int, col: Int) = row * width + col

	override operator fun set(row: Int, col: Int, value: E) {
		validateIndex(row, height, "row")
		validateIndex(col, width, "col")
		data[index(row, col)] = value
	}

	override operator fun get(row: Int, col: Int): E {
		validateIndex(row, height, "row")
		validateIndex(col, width, "col")
		return data[index(row, col)]
	}

	override fun forEach(exec: (Int, Int, E) -> Unit) {
		for (row in 0..height - 1) {
			for (col in 0..width - 1) {
				exec(row, col, get(row, col))
			}
		}
	}

	override fun forEachOnRow(row: Int, exec: (Int, E) -> Unit) {
		for (col in 0..width - 1) {
			exec(col, get(row, col))
		}
	}

	override fun forEachNonDefaultOnRow(row: Int, exec: (Int, E) -> Unit) {
		for (col in 0..width - 1) {
			val v = get(row, col)
			if (v != default) {
				exec(col, v)
			}
		}
	}

	override fun clearRow(row: Int) {
		for (col in 0..width - 1) {
			set(row, col, default)
		}
	}

	override fun clone(): DenseMatrix<E> {
		val output = DenseMatrix(width, height, default, init)
		forEach { row, column, value -> output[row, column] = value }
		return output
	}

}
