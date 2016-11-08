package uk.co.markormesher.easymaps.engine.structures

import uk.co.markormesher.easymaps.engine.interfaces.Trait
import java.util.*

class TraitTranslator {

	val INVALID_ID = -1

	private val traitToIdMap = HashMap<Trait, Int>()
	private val idToClusterIdMap = HashMap<Int, Int>()
	private var latestId = -1

	fun offerTrait(trait: Trait): Int {
		if (!traitToIdMap.containsKey(trait)) traitToIdMap.put(trait, ++latestId)
		return getIdForTrait(trait)
	}

	fun removeTrait(trait: Trait) {
		traitToIdMap.remove(trait)
	}

	fun getIdForTrait(trait: Trait): Int {
		return traitToIdMap[trait] ?: INVALID_ID
	}

	fun getClusterIdForTrait(trait: Trait): Int {
		val traitId = getIdForTrait(trait)
		return idToClusterIdMap[traitId] ?: INVALID_ID
	}

	fun setClusterIdForTrait(trait: Trait, clusterId: Int) {
		val traitId = getIdForTrait(trait)
		if (traitId == INVALID_ID) throw InvalidTraitException(trait)
		idToClusterIdMap[traitId] = clusterId
	}

	fun forEachTrait(exec: (trait: Trait, id: Int) -> Unit) {
		val allTraits = traitToIdMap.entries
		allTraits.forEach { e -> exec(e.key, e.value) }
	}

	var size: Int = 0
		get() = traitToIdMap.size

}

class InvalidTraitException(trait: Trait) : Exception("The trait '$trait' is not a valid trait")