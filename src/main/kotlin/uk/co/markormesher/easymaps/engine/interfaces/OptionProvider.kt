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
	 * Minimum time gap between clusters (within one trait log) to imply a connection between them.
	 * Set to -1 for no minimum.
	 */
	abstract val minTimeGapBetweenClusters: Long

	/**
	 * Maximum time gap between clusters (within one trait log) to imply a connection between them.
	 * Set to -1 for no maximum.
	 */
	abstract val maxTimeGapBetweenClusters: Long

}