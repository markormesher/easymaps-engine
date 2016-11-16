package uk.co.markormesher.easymaps.engine.interfaces

import org.junit.Test
import kotlin.test.assertNotNull

/**
 * These tests are just to silence warnings from JaCoCo.
 */
class OptionProviderTests {

	class OptionProviderMock : OptionProvider()

	@Test
	fun defaultPropertiesShouldExist() {
		val mock = OptionProviderMock()
		assertNotNull(mock.uniqueObserversRequiredPerTrait)
		assertNotNull(mock.coOccurrencesRequiredPerTraitLink)
		assertNotNull(mock.minTimeGapBetweenClusters)
		assertNotNull(mock.maxTimeGapBetweenClusters)
	}

}