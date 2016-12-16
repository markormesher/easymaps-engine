package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.algorithms.Ullmann1976IsomorphismFinder
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.structures.Network

fun matchNetworks(observedNetwork: Network, knownNetwork: Network): List<Map<Int, Int>> {

	printSubHeader("Matching Networks")

	var timer: Long
	var timerTotal: Long
	val loops = 10



	printInfo("Ullmann:")
	timerTotal = 0
	Ullmann1976IsomorphismFinder(observedNetwork, knownNetwork).findIsomorphisms()
	for (i in 1..loops) {
		timer = -System.currentTimeMillis()
		Ullmann1976IsomorphismFinder(observedNetwork, knownNetwork).findIsomorphisms()
		timer += System.currentTimeMillis()
		printSubInfo("$timer ms")
		timerTotal += timer
	}
	printSubWarning("Average: ${timerTotal / loops} ms")



	val isomorphismFinder = Ullmann1976IsomorphismFinder(observedNetwork, knownNetwork)
	val isomorphisms = isomorphismFinder.findIsomorphisms()

	if (isomorphisms.isEmpty()) {
		printError("Found no possible isomorphisms")
	} else {
		printInfo("Found ${isomorphisms.size} possible isomorphism(s)")
	}
	return isomorphisms
}
