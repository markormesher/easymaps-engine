package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine.algorithms.structures.Matrix

fun applyMarkovClustering(adjMatrix: Matrix) {
	normaliseColumns(adjMatrix)
}

/**
 * Normalises a matrix so that each non-empty column sums to 1.
 */
private fun normaliseColumns(matrix: Matrix) {
	for (col in 0..matrix.width - 1) {
		var columnSum = 0.0
		for (row in 0..matrix.height - 1) columnSum += matrix[row, col]
		if (columnSum > 0) {
			for (row in 0..matrix.height - 1) matrix[row, col] = matrix[row, col] / columnSum
		}
	}
}