package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine._mocks.MockNetwork
import uk.co.markormesher.easymaps.engine._mocks.getMockNetwork

class BruteForceIsomorphismFinderTests: IsomorphismFinderAlgorithmTests() {

	override fun makeFinder(candidate: MockNetwork, master: MockNetwork): IsomorphismFinder {
		return BruteForceIsomorphismFinder(getMockNetwork(candidate), getMockNetwork(master))
	}
}
