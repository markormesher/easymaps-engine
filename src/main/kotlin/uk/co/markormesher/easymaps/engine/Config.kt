package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.interfaces.LogReader
import uk.co.markormesher.easymaps.engine.interfaces.OptionProvider
import uk.co.markormesher.easymaps.engine.interfaces.WalkerOptionProvider
import uk.co.markormesher.easymaps.engine.structures.TraitTranslator

open class SharedConfig(
		open val logFolderPath: String,
		open val knownNetworkFilePath: String,
		open val outputFolderPath: String,
		open val graphvizExec: String,
		open val drawGraphs: Boolean
)

class EngineConfig(
		val logReader: LogReader,
		val optionProvider: OptionProvider,
		val traitTranslator: TraitTranslator,
		override val logFolderPath: String,
		override val knownNetworkFilePath: String,
		override val outputFolderPath: String,
		override val graphvizExec: String,
		override val drawGraphs: Boolean
) : SharedConfig(
		logFolderPath,
		knownNetworkFilePath,
		outputFolderPath,
		graphvizExec,
		drawGraphs
)

class WalkerConfig(
		val walkerOptionProvider: WalkerOptionProvider,
		override val knownNetworkFilePath: String,
		override val logFolderPath: String,
		override val outputFolderPath: String,
		override val graphvizExec: String,
		override val drawGraphs: Boolean
) : SharedConfig(
		logFolderPath,
		knownNetworkFilePath,
		outputFolderPath,
		graphvizExec,
		drawGraphs
)