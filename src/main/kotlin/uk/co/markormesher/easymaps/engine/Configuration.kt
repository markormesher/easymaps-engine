package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.core.TraitTranslator
import uk.co.markormesher.easymaps.engine.log_readers.LogReader
import uk.co.markormesher.easymaps.engine.option_providers.OptionProvider

data class Configuration(
		val logReader: LogReader,
		val optionProvider: OptionProvider,
		val traitTranslator: TraitTranslator,
		val logPath: String,
		val outputPath: String,
		val dotExec: String
)