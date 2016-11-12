package uk.co.markormesher.easymaps.engine.structures

import org.junit.Test
import uk.co.markormesher.easymaps.engine.domain_specific.SampleTrait
import uk.co.markormesher.easymaps.engine.interfaces.Trait
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

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
		assertEquals(0, tt.getTraitId(TRAIT_1))
		assertEquals(1, tt.getTraitId(TRAIT_2))
		assertEquals(2, tt.getTraitId(TRAIT_3))
	}

	@Test
	fun duplicateOffersShouldNotAffectId() {
		val tt = TraitTranslator()
		tt.offerTrait(TRAIT_1)
		val expectedId = tt.getTraitId(TRAIT_1)
		tt.offerTrait(TRAIT_1)
		tt.offerTrait(TRAIT_1)
		val actualId = tt.getTraitId(TRAIT_1)
		assertEquals(expectedId, actualId)
	}

	@Test
	fun removeTraitShouldRemoveTrait() {
		val tt = TraitTranslator()
		tt.offerTrait(TRAIT_1)
		tt.offerTrait(TRAIT_2)
		tt.offerTrait(TRAIT_3)
		assertEquals(3, tt.size)
		tt.removeTrait(TRAIT_1)
		tt.removeTrait(TRAIT_2)
		tt.removeTrait(TRAIT_3)
		assertEquals(0, tt.size)
	}

	@Test
	fun getIdForTraitShouldReturnInvalidIdForUnknownTrait() {
		val tt = TraitTranslator()
		assertEquals(tt.INVALID_ID, tt.getTraitId(TRAIT_1))
	}

	@Test
	fun setClusterShouldRejectDuplicateCalls() {
		val tt = TraitTranslator()
		tt.offerTrait(TRAIT_1)
		tt.setTraitCluster(TRAIT_1, 7)
		assertFailsWith(Exception::class, { tt.setTraitCluster(TRAIT_1, 8) })
	}

	@Test
	fun setClusterShouldRejectUnknownTraits() {
		val tt = TraitTranslator()
		assertFailsWith(InvalidTraitException::class, { tt.setTraitCluster(TRAIT_1, 1) })
	}

	@Test
	fun getTraitsForClusterShouldBeAccurate() {
		val tt = TraitTranslator()
		tt.offerTrait(TRAIT_1)
		tt.offerTrait(TRAIT_2)
		tt.offerTrait(TRAIT_3)
		tt.setTraitCluster(TRAIT_1, 1)
		tt.setTraitCluster(TRAIT_2, 1)
		tt.setTraitCluster(TRAIT_3, 1)
		val result = tt.getTraitsForCluster(1)
		assertEquals(3, result.size)
		assertTrue(result.contains(TRAIT_1))
		assertTrue(result.contains(TRAIT_2))
		assertTrue(result.contains(TRAIT_3))
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