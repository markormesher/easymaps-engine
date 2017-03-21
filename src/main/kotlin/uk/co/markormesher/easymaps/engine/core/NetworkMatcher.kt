package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.algorithms.BruteForceIsomorphismFinder
import uk.co.markormesher.easymaps.engine.algorithms.Ullmann1976IsomorphismFinder
import uk.co.markormesher.easymaps.engine.helpers.printError
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.helpers.timedExecution
import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*

fun matchNetworks(observedNetwork: Network, knownNetwork: Network, timed: Boolean = false): List<Map<Int, Int>> {

	val isomorphisms: List<Map<Int, Int>>
	if (timed) {
		printSubHeader("Matching Networks (Timed)")
		isomorphisms = matchNetworksForTimeTrials(observedNetwork, knownNetwork)
	} else {
		printSubHeader("Matching Networks")
		val isomorphismFinder = Ullmann1976IsomorphismFinder(observedNetwork, knownNetwork, Ullmann1976IsomorphismFinder.Mode.MODIFIED_DENSE)
		isomorphisms = isomorphismFinder.findIsomorphisms()
	}

	if (isomorphisms.isEmpty()) {
		printError("Found no possible isomorphisms")
	} else {
		printInfo("Found ${isomorphisms.size} possible isomorphism(s)")
	}
	return isomorphisms
}

private fun matchNetworksForTimeTrials(observedNetwork: Network, knownNetwork: Network): List<Map<Int, Int>> {
	var isomorphisms: List<Map<Int, Int>> = ArrayList()
	timedExecution("Brute-force", 1, 3, {
		isomorphisms = BruteForceIsomorphismFinder(observedNetwork, knownNetwork).findIsomorphisms()
	})
	timedExecution("Ullmann (Modified, Dense)", 1, 3, {
		isomorphisms = Ullmann1976IsomorphismFinder(observedNetwork, knownNetwork, Ullmann1976IsomorphismFinder.Mode.MODIFIED_DENSE).findIsomorphisms()
	})
	timedExecution("Ullmann (Modified, Sparse)", 1, 3, {
		isomorphisms = Ullmann1976IsomorphismFinder(observedNetwork, knownNetwork, Ullmann1976IsomorphismFinder.Mode.MODIFIED_SPARSE).findIsomorphisms()
	})
	timedExecution("Ullmann (Unmodified, Dense)", 1, 3, {
		isomorphisms = Ullmann1976IsomorphismFinder(observedNetwork, knownNetwork, Ullmann1976IsomorphismFinder.Mode.UNMODIFIED_DENSE).findIsomorphisms()
	})
	timedExecution("Ullmann (Unmodified, Sparse)", 1, 3, {
		isomorphisms = Ullmann1976IsomorphismFinder(observedNetwork, knownNetwork, Ullmann1976IsomorphismFinder.Mode.UNMODIFIED_SPARSE).findIsomorphisms()
	})
	return isomorphisms
}
