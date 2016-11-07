package uk.co.markormesher.easymaps.engine.option_providers

abstract class OptionProvider {

	/**
	 * The minimum number of observers required for a trait to be considered.
	 * Useful for rejecting spurious traits captured by very few observers.
	 */
	val uniqueObserversRequiredPerTrait = 1

	/**
	 * The minimum number of scans in which traits must co-occur in order to be clustered together.
	 * Useful for preventing sparsely-linked clusters from becoming joined.
	 */
	val coOccurrencesRequiredPerTraitLink = 1

	/**
	 * The minimum time gap between clusters (within one trait log) to imply a connection between them.
	 * Set to -1 for no minimum.
	 */
	val minTimeGapBetweenClusters = 10000L // 10s

	/**
	 * The maximum time gap between clusters (within one trait log) to imply a connection between them.
	 * Set to -1 for no maximum.
	 */
	val maxTimeGapBetweenClusters = 120000L // 120s

}