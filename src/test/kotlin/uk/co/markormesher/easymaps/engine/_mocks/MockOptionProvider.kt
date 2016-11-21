package uk.co.markormesher.easymaps.engine._mocks

import uk.co.markormesher.easymaps.engine.interfaces.OptionProvider

class MockOptionProvider : OptionProvider() {

	override val uniqueObserversRequiredPerTrait = 1
	override val coOccurrencesRequiredPerTraitLink = 1
	override val minTimeGapBetweenClusters = 10000L // 10s
	override val maxTimeGapBetweenClusters = 125000L // 125s

}