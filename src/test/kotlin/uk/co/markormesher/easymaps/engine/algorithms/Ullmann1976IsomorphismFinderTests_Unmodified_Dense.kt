package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine._mocks.MockNetwork
import uk.co.markormesher.easymaps.engine._mocks.getMockNetwork

class Ullmann1976IsomorphismFinderTests_Unmodified_Dense: IsomorphismFinderAlgorithmTests() {

	override fun makeFinder(candidate: MockNetwork, master: MockNetwork): IsomorphismFinder {
		return Ullmann1976IsomorphismFinder(
				getMockNetwork(candidate),
				getMockNetwork(master),
				Ullmann1976IsomorphismFinder.Mode.UNMODIFIED_DENSE
		)
	}
}
