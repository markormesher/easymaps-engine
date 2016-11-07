package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine.algorithms.structures.Matrix
import uk.co.markormesher.easymaps.engine.helpers.printInfo

fun multiplyMatrices(a: Matrix, b: Matrix, result: Matrix) {
	if (a.width != b.height || a.width != result.width || b.height != result.height) {
		throw IllegalArgumentException("Dimensions do not agree")
	}

	for (row in 0..result.height - 1) {
		for (col in 0..result.width - 1) {
			result[row, col] = 0.0
		}
	}

	for (i in 0..a.height - 1) {
		for (j in 0..b.width - 1) {
			for (k in 0..a.width - 1) {
				result[i, j] += a[i, k] * b[k, j]
			}
		}
	}
}

fun raiseMatrixToPower(matrix: Matrix, power: Int) {
	if (matrix.width != matrix.height) throw IllegalArgumentException("Not valid for non-square matrices")

	val result = matrix.copy()
	var workingCopy = matrix.copy()
	for (i in 1..power) {
		printInfo("Power cycle $i")
		multiplyMatrices(workingCopy, matrix, result)
		workingCopy = result.copy()
	}
}