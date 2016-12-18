package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine._mocks.MockNetwork
import uk.co.markormesher.easymaps.engine._mocks.getMockNetwork

class Ullmann1976IsomorphismFinder_SparseMatrixTests: IsomorphismFinderAlgorithmTests() {

	override fun makeFinder(candidate: MockNetwork, master: MockNetwork): IsomorphismFinder {
		return Ullmann1976IsomorphismFinder_SparseMatrix(getMockNetwork(candidate), getMockNetwork(master))
	}
}
