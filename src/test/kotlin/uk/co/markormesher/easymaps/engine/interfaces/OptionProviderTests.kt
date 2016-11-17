package uk.co.markormesher.easymaps.engine.interfaces

import org.junit.Test
import uk.co.markormesher.easymaps.engine._mocks.MockOptionProvider
import kotlin.test.assertNotNull

/**
 * These tests are just to silence warnings from JaCoCo.
 */
class OptionProviderTests {

	@Test
	fun defaultPropertiesShouldExist() {
		val mock = MockOptionProvider()
		assertNotNull(mock.uniqueObserversRequiredPerTrait)
		assertNotNull(mock.coOccurrencesRequiredPerTraitLink)
		assertNotNull(mock.minTimeGapBetweenClusters)
		assertNotNull(mock.maxTimeGapBetweenClusters)
	}

}