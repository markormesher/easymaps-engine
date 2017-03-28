package uk.co.markormesher.easymaps.engine.domain_specific.sample

import uk.co.markormesher.easymaps.engine.interfaces.OptionProvider
import uk.co.markormesher.easymaps.engine.interfaces.Trait

class SampleOptionProvider : OptionProvider() {

	override val uniqueObserversRequiredPerTrait = 1
	override val coOccurrencesRequiredPerTraitLink = 1
	override val edgeStrengthRequired = 1
	override val minTimeGapBetweenClusters = 10000L // 10s
	override val maxTimeGapBetweenClusters = 130000L // 130s

	override fun getLabellingLine(trait: Trait, knownNetworkLabel: String) = "\"${(trait as SampleTrait).trait}\" = \"$knownNetworkLabel\""

}
