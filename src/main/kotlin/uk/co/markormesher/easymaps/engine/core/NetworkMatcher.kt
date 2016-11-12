package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.data.Network
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import java.util.*

// maps are "observed node id" -> "known node id"
fun matchNetworks(observedNetwork: Network, knownNetwork: Network): List<Map<Int, Int>> {

	printSubHeader("Matching to Known Network")

	val isomorphisms = ArrayList<Map<Int, Int>>()

	// TODO: remove dummy code
	val iso = TreeMap<Int, Int>()
	iso.put(14, 0)
	iso.put(1, 1)
	isomorphisms.add(iso)

	printInfo("Found ${isomorphisms.size} possible isomorphism(s)")

	return isomorphisms
}