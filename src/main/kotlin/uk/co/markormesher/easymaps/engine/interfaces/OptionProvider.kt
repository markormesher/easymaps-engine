package uk.co.markormesher.easymaps.engine.interfaces

abstract class OptionProvider {

	/**
	 * Minimum number of observers required for a trait to be considered.
	 * Useful for rejecting spurious traits captured by very few observers.
	 */
	abstract val uniqueObserversRequiredPerTrait: Int

	/**
	 * Minimum number of scans in which traits must co-occur in order to be clustered together.
	 * Useful for preventing sparsely-linked clusters from becoming joined.
	 */
	abstract val coOccurrencesRequiredPerTraitLink: Int

	/**
	 * Minimum number of times an edge must be indicated before it is created in the observed network.
	 * Useful for preventing one-off edges from being created.
	 */
	abstract val edgeStrengthRequired: Int

	/**
	 * Minimum time gap between clusters (within one trait log) to imply a connection between them.
	 * Set to -1 for no minimum.
	 */
	abstract val minTimeGapBetweenClusters: Long

	/**
	 * Maximum time gap between clusters (within one trait log) to imply a connection between them.
	 * Set to -1 for no maximum.
	 */
	abstract val maxTimeGapBetweenClusters: Long

	/**
	 * Create the line to add to a labelling to represent the link between a trait and a node in the known network.
	 */
	abstract fun getLabellingLine(trait: Trait, knownNetworkLabel: String): String

}
