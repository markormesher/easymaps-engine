package uk.co.markormesher.easymaps.engine.interfaces

import org.junit.Test
import uk.co.markormesher.easymaps.engine.domain_specific.sample.SampleOptionProvider
import kotlin.test.assertNotNull

/**
 * These tests are just to silence warnings from JaCoCo.
 */
class OptionProviderTests {

	@Test
	fun defaultPropertiesShouldExist() {
		val mock = SampleOptionProvider()
		assertNotNull(mock.uniqueObserversRequiredPerTrait)
		assertNotNull(mock.coOccurrencesRequiredPerTraitLink)
		assertNotNull(mock.edgeStrengthRequired)
		assertNotNull(mock.minTimeGapBetweenClusters)
		assertNotNull(mock.maxTimeGapBetweenClusters)
	}

}
