package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.log_readers.LogReader
import uk.co.markormesher.easymaps.engine.option_providers.OptionProvider
import uk.co.markormesher.easymaps.engine.trait_translation.TraitTranslator

fun generateObservedNetwork(logReader: LogReader,
							logPath: String,
							optionProvider: OptionProvider,
							traitTranslator: TraitTranslator) {

	// set up log reader and read once to build trait maps
	logReader.init(logPath)
	var fileCount = 0
	while (logReader.hasNextLogFile()) {
		++fileCount
		val file = logReader.nextLogFile()
		file.logEntries.forEach { it.traits.forEach { traitTranslator.offer(it) } }
	}

	println("Found ${traitTranslator.size} unique trait(s) in $fileCount file(s)")
}