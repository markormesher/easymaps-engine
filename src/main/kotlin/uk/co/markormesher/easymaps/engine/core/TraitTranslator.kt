package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.entities.Trait
import java.util.*

class TraitTranslator {

	val traitToIdMap = HashMap<Trait, Int>()
	val idToTraitMap = HashMap<Int, Trait>()
	var latestId = -1

	fun offer(trait: Trait) {
		toId(trait) // run toId but ignore result
	}

	fun remove(trait: Trait) {
		if (!traitToIdMap.containsKey(trait)) return

		val id = traitToIdMap[trait]
		traitToIdMap.remove(trait)
		idToTraitMap.remove(id)
	}

	fun containsTrait(trait: Trait): Boolean = traitToIdMap.containsKey(trait)

	fun containsId(id: Int): Boolean = idToTraitMap.containsKey(id)

	fun toId(trait: Trait): Int {
		if (traitToIdMap.containsKey(trait)) return traitToIdMap[trait]!!

		val id = ++latestId
		traitToIdMap.put(trait, id)
		idToTraitMap.put(id, trait)
		return id
	}

	fun fromId(id: Int): Trait {
		if (idToTraitMap.containsKey(id)) return idToTraitMap[id]!!
		throw InvalidTraitIdException("The ID $id does not exist in this TraitTranslator")
	}

	var size: Int = 0
		get() = traitToIdMap.size

}

class InvalidTraitIdException(message: String) : Exception(message)