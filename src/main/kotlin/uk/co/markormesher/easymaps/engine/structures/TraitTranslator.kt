package uk.co.markormesher.easymaps.engine.structures

import com.google.common.collect.HashBiMap
import uk.co.markormesher.easymaps.engine.interfaces.Trait
import java.util.*

class TraitTranslator {

	val INVALID_ID = -1

	private val traitToTraitIdIdMap = HashBiMap.create<Trait, Int>()
	private val traitClusters = HashMap<Int, ArrayList<Trait>>() // cluster id -> list<trait>
	private val clusteredTraits = TreeSet<Int>()

	private var latestId = -1

	fun offerTrait(trait: Trait): Int {
		if (!traitToTraitIdIdMap.containsKey(trait)) {
			traitToTraitIdIdMap.put(trait, ++latestId)
		}
		return getTraitId(trait)
	}

	fun removeTrait(trait: Trait) {
		traitToTraitIdIdMap.remove(trait)
	}

	fun getTraitId(trait: Trait): Int {
		return traitToTraitIdIdMap[trait] ?: INVALID_ID
	}

	fun setTraitCluster(trait: Trait, clusterId: Int) {
		val traitId = getTraitId(trait)
		if (traitId == INVALID_ID) throw InvalidTraitException(trait)

		if (clusteredTraits.contains(traitId)) throw Exception("Trait $trait already has a cluster ID")
		clusteredTraits.add(traitId)

		if (!traitClusters.containsKey(clusterId)) {
			traitClusters[clusterId] = ArrayList<Trait>()
		}
		traitClusters[clusterId]?.add(trait)
	}

	fun getTraitsForCluster(clusterId: Int): ArrayList<Trait> {
		return traitClusters[clusterId] ?: throw InvalidClusterIdException(clusterId)
	}

	fun forEachTrait(exec: (trait: Trait, id: Int) -> Unit) {
		traitToTraitIdIdMap.entries.forEach { e -> exec(e.key, e.value) }
	}

	val size: Int
		get() = traitToTraitIdIdMap.size

}

class InvalidTraitException(trait: Trait) : Exception("The trait '$trait' is not a valid trait")

class InvalidClusterIdException(clusterId: Int) : Exception("The cluster ID '$clusterId' is not valid")