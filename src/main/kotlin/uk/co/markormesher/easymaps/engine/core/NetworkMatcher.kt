package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.algorithms.BruteForceIsomorphismFinder
import uk.co.markormesher.easymaps.engine.algorithms.Ullmann1976IsomorphismFinder
import uk.co.markormesher.easymaps.engine.helpers.printError
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.helpers.printSubInfo
import uk.co.markormesher.easymaps.engine.structures.Network

fun matchNetworks(observedNetwork: Network, knownNetwork: Network): List<Map<Int, Int>> {

	printSubHeader("Matching Networks")

	printInfo("Brute-force:")
	var timer = -System.currentTimeMillis()
	BruteForceIsomorphismFinder(observedNetwork, knownNetwork).findIsomorphisms()
	timer += System.currentTimeMillis()
	printSubInfo("$timer ms")

	printInfo("Ullmann:")
	timer = -System.currentTimeMillis()
	val isomorphisms = Ullmann1976IsomorphismFinder(observedNetwork, knownNetwork).findIsomorphisms()
	timer += System.currentTimeMillis()
	printSubInfo("$timer ms")

	//val isomorphismFinder = Ullmann1976IsomorphismFinder(observedNetwork, knownNetwork)
	//val isomorphisms = isomorphismFinder.findIsomorphisms()

	if (isomorphisms.isEmpty()) {
		printError("Found no possible isomorphisms")
	} else {
		printInfo("Found ${isomorphisms.size} possible isomorphism(s)")
	}
	return isomorphisms
}
