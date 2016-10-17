package uk.co.markormesher.easymaps.engine.trait_translation

import uk.co.markormesher.easymaps.engine.data.Trait
import java.util.*

class TraitTranslator {

	val traitToIdMap = HashMap<Trait, Int>()
	val idToTraitMap = HashMap<Int, Trait>()

	fun offer(trait: Trait) {
		toId(trait) // run toId but ignore result
	}

	fun toId(trait: Trait): Int {
		if (traitToIdMap.containsKey(trait)) return traitToIdMap[trait]!!

		val id = traitToIdMap.size
		traitToIdMap.put(trait, id)
		idToTraitMap.put(id, trait)
		return id
	}

	fun fromId(id: Int): Trait {
		if (idToTraitMap.containsKey(id)) return idToTraitMap[id]!!
		throw InvalidTraitIdException("Invalid ID given: ID was $id and " +
				" map sizes are ${traitToIdMap.size} and ${idToTraitMap.size}")
	}

	var size: Int = 0
		get() = traitToIdMap.size

}

class InvalidTraitIdException(message: String) : Exception(message)