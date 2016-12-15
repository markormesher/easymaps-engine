package uk.co.markormesher.easymaps.engine.algorithms

import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*

class Ullmann1976IsomorphismFinder(val candidate: Network, val master: Network): IsomorphismFinder {

	val isomorphisms = ArrayList<Map<Int, Int>>()


	override fun findIsomorphisms(): List<Map<Int, Int>> {
		isomorphisms.clear()
		return isomorphisms
	}

}
