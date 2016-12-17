package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine._mocks.MockNetwork
import uk.co.markormesher.easymaps.engine._mocks.getMockNetwork

class Ullmann1976IsomorphismFinder_DenseMatrixTests: IsomorphismFinderTests() {

	override fun makeFinder(candidate: MockNetwork, master: MockNetwork): IsomorphismFinder {
		return Ullmann1976IsomorphismFinder_DenseMatrix(getMockNetwork(candidate), getMockNetwork(master))
	}
}
