package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.algorithms.Ullmann1976IsomorphismFinder_SparseMatrix
import uk.co.markormesher.easymaps.engine.helpers.printError
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.structures.Network

fun matchNetworks(observedNetwork: Network, knownNetwork: Network): List<Map<Int, Int>> {

	printSubHeader("Matching Networks")

	//timedExecution("Ullmann (Dense)", 2, 5, {
	//	Ullmann1976IsomorphismFinder_DenseMatrix(observedNetwork, knownNetwork).findIsomorphisms()
	//})
	//timedExecution("Ullmann (Sparse)", 2, 5, {
	//	Ullmann1976IsomorphismFinder_SparseMatrix(observedNetwork, knownNetwork).findIsomorphisms()
	//})
	//timedExecution("Brute-force", 2, 5, {
	//	BruteForceIsomorphismFinder(observedNetwork, knownNetwork).findIsomorphisms()
	//})

	val isomorphismFinder = Ullmann1976IsomorphismFinder_SparseMatrix(observedNetwork, knownNetwork)
	val isomorphisms = isomorphismFinder.findIsomorphisms()

	if (isomorphisms.isEmpty()) {
		printError("Found no possible isomorphisms")
	} else {
		printInfo("Found ${isomorphisms.size} possible isomorphism(s)")
	}
	return isomorphisms
}
