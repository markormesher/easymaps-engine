package uk.co.markormesher.easymaps.engine.structures

interface Matrix<E> {

	val width: Int

	val height: Int

	operator fun set(row: Int, col: Int, value: E)

	operator fun get(row: Int, col: Int): E

	fun getRow(row: Int): Vector<E>

	fun getColumn(column: Int): Vector<E>

	fun forEach(exec: (row: Int, column: Int, value: E) -> Unit)

	fun forEachOnRow(row: Int, exec: (column: Int, value: E) -> Unit)

	fun forEachOnColumn(column: Int, exec: (row: Int, value: E) -> Unit)

	fun clear()

	fun clearRow(row: Int)

	fun clearColumn(column: Int)

	fun clone(): Matrix<E>

}
