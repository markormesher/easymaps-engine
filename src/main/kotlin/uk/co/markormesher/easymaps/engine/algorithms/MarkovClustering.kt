package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine.algorithms.structures.Matrix
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubMessage

/**
 * Applies the Markov Clustering (MCL) algorithm.
 */
fun applyMarkovClustering(
		adjMatrix: Matrix,
		addSelfLoops: Boolean = true,
		maxLoopCount: Int = 2,
		expansionFactor: Int = 2,
		inflationFactor: Double = 2.0,
		pruneThreshold: Double = 0.01) {

	// sorry, squares only
	if (adjMatrix.width != adjMatrix.height) throw IllegalArgumentException("Expected square matrix")

	// prepare adjacency matrix
	printInfo("Preparing matrix for Markov clustering")
	if (addSelfLoops) {
		printSubMessage("Adding self-loops...")
		addSelfLoops(adjMatrix)
	}
	printSubMessage("Normalising columns...")
	normaliseColumns(adjMatrix)

	for (i in 1..maxLoopCount) {
		printInfo("Markov Clustering Loop $i")

		//raiseMatrixToPower(adjMatrix, expansionFactor)

		printSubMessage("Inflating...")
		inflateMatrix(adjMatrix, inflationFactor)

		printSubMessage("Normalising columns...")
		normaliseColumns(adjMatrix)

		printSubMessage("Pruning...")
		pruneMatrix(adjMatrix, pruneThreshold)
	}
}

private fun addSelfLoops(adjMatrix: Matrix, value: Double = 1.0) {
	if (adjMatrix.width != adjMatrix.height) throw IllegalArgumentException("Expected square matrix")
	for (i in 0..adjMatrix.width - 1) adjMatrix[i, i] = value
}

private fun normaliseColumns(matrix: Matrix) {
	for (col in 0..matrix.width - 1) {
		var columnSum = 0.0
		for (row in 0..matrix.height - 1) columnSum += matrix[row, col]
		if (columnSum > 0) {
			for (row in 0..matrix.height - 1) matrix[row, col] = matrix[row, col] / columnSum
		}
	}
}

private fun inflateMatrix(matrix: Matrix, inflationFactor: Double) {
	matrix.forAllRowsAndCols { row, col -> matrix[row, col] = Math.pow(matrix[row, col], inflationFactor) }
}

private fun pruneMatrix(matrix: Matrix, pruneThreshold: Double, replacement: Double = 0.0) {
	matrix.forAllRowsAndCols { row, col -> if (matrix[row, col] < pruneThreshold) matrix[row, col] = replacement }
}