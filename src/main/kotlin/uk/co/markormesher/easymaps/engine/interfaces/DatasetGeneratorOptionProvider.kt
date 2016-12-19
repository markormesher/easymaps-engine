package uk.co.markormesher.easymaps.engine.interfaces

abstract class DatasetGeneratorOptionProvider {

	/**
	 * Name of the log reader to write into option files.
	 */
	abstract val logReaderName: String

	/**
	 * Name of the option provider to write into option files.
	 */
	abstract val optionProviderName: String

	/**
	 * Name of the log generator option provider to write into option files.
	 */
	abstract val logGeneratorOptionProviderName: String

	/**
	 * List of graph sizes to generate.
	 */
	abstract val sizes: Collection<Int>

	/**
	 * Minimum node-to-edge ratio.
	 */
	abstract val minConnectivity: Double

	/**
	 * Maximum node-to-edge ratio.
	 */
	abstract val maxConnectivity: Double

	/**
	 * % chance of creating a single-direction edge.
	 */
	abstract val singleDirectionChance: Double

	/**
	 * % chance of breaking a chain.
	 */
	abstract val chainBreakChance: Double

	/**
	 * Generates the folder name for a given graph size.
	 */
	abstract fun generateGraphFolderName(size: Int): String

	/**
	 * Generate label for a given node.
	 */
	abstract fun generateGraphNodeLabel(size: Int, nodeId: Int): String

}
