package uk.co.markormesher.easymaps.engine.structures

interface Matrix<E> {

	operator fun set(row: Int, col: Int, value: E)

	operator fun get(row: Int, col: Int): E

	fun forEach(exec: (Int, Int, E) -> Unit)

	fun forEachOnRow(row: Int, exec: (Int, E) -> Unit)

	fun forEachNonDefaultOnRow(row: Int, exec: (Int, E) -> Unit)

	fun clearRow(row: Int)

	fun clone(): Matrix<E>

}
