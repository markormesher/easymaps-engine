package uk.co.markormesher.easymaps.engine.structures

import org.junit.Test
import uk.co.markormesher.easymaps.engine.domain_specific.SampleTrait
import uk.co.markormesher.easymaps.engine.interfaces.Trait
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TraitTranslatorTests {

	private val TRAIT_1 = SampleTrait("trait 01")
	private val TRAIT_2 = SampleTrait("trait 02")
	private val TRAIT_3 = SampleTrait("trait 03")

	@Test
	fun offerShouldAcceptDuplicateTraits() {
		val tt = TraitTranslator()
		tt.offerTrait(TRAIT_1)
		tt.offerTrait(TRAIT_1)
		tt.offerTrait(TRAIT_1)
	}

	@Test
	fun traitsShouldGetIncrementalIds() {
		val tt = TraitTranslator()
		tt.offerTrait(TRAIT_1)
		tt.offerTrait(TRAIT_2)
		tt.offerTrait(TRAIT_3)
		assertEquals(0, tt.getIdForTrait(TRAIT_1))
		assertEquals(1, tt.getIdForTrait(TRAIT_2))
		assertEquals(2, tt.getIdForTrait(TRAIT_3))
	}

	@Test
	fun duplicateOffersShouldNotAffectId() {
		val tt = TraitTranslator()
		tt.offerTrait(TRAIT_1)
		val expectedId = tt.getIdForTrait(TRAIT_1)
		tt.offerTrait(TRAIT_1)
		tt.offerTrait(TRAIT_1)
		val actualId = tt.getIdForTrait(TRAIT_1)
		assertEquals(expectedId, actualId)
	}

	@Test
	fun getIdForTraitShouldReturnInvalidIdForUnknownTrait() {
		val tt = TraitTranslator()
		assertEquals(tt.INVALID_ID, tt.getIdForTrait(TRAIT_1))
	}

	@Test
	fun clusterIdsForTraitsShouldBeStored() {
		val tt = TraitTranslator()
		tt.offerTrait(TRAIT_1)
		tt.offerTrait(TRAIT_2)
		tt.offerTrait(TRAIT_3)
		tt.setClusterIdForTrait(TRAIT_1, 7)
		tt.setClusterIdForTrait(TRAIT_2, 8)
		tt.setClusterIdForTrait(TRAIT_3, 9)
		assertEquals(7, tt.getClusterIdForTrait(TRAIT_1))
		assertEquals(8, tt.getClusterIdForTrait(TRAIT_2))
		assertEquals(9, tt.getClusterIdForTrait(TRAIT_3))
	}

	@Test
	fun setClusterIdShouldOverrideExistingValues() {
		val tt = TraitTranslator()
		tt.offerTrait(TRAIT_1)
		tt.setClusterIdForTrait(TRAIT_1, 7)
		tt.setClusterIdForTrait(TRAIT_1, 8)
		assertEquals(8, tt.getClusterIdForTrait(TRAIT_1))
	}

	@Test
	fun setClusterIdShouldRejectUnknownTraits() {
		val tt = TraitTranslator()
		assertFailsWith(InvalidTraitException::class, { tt.setClusterIdForTrait(TRAIT_1, 1) })
	}

	@Test
	fun forEachTraitShouldIncludeAllValues() {
		val tt = TraitTranslator()
		tt.offerTrait(TRAIT_1)
		tt.offerTrait(TRAIT_2)
		tt.offerTrait(TRAIT_3)

		val output = HashSet<Trait>()
		tt.forEachTrait { t, i -> output.add(t) }

		assertEquals(3, output.size)
	}

	@Test
	fun sizeShouldBeAccurate() {
		val tt = TraitTranslator()
		assertEquals(0, tt.size)
		tt.offerTrait(TRAIT_1)
		tt.offerTrait(TRAIT_2)
		tt.offerTrait(TRAIT_3)
		assertEquals(3, tt.size)
	}

}