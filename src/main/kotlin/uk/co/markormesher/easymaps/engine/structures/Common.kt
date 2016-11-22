package uk.co.markormesher.easymaps.engine.structures

fun validateIndex(index: Int, n: Int, label: String = "index") {
	if (index < 0 || index >= n) throw IndexOutOfBoundsException("$label = $index, size = $n")
}