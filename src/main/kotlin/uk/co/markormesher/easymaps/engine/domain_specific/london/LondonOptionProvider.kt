package uk.co.markormesher.easymaps.engine.domain_specific.london

import uk.co.markormesher.easymaps.engine.interfaces.OptionProvider

class LondonOptionProvider : OptionProvider() {

	override val uniqueObserversRequiredPerTrait = 1
	override val coOccurrencesRequiredPerTraitLink = 1
	override val edgeStrengthRequired = 1
	override val minTimeGapBetweenClusters = 10000L // 10s
	override val maxTimeGapBetweenClusters = 150000L // 150s

}
