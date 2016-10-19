package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.log_readers.LogReader
import uk.co.markormesher.easymaps.engine.option_providers.OptionProvider
import uk.co.markormesher.easymaps.engine.trait_translation.TraitTranslator

fun generateObservedNetwork(logReader: LogReader,
							logPath: String,
							optionProvider: OptionProvider,
							traitTranslator: TraitTranslator) {

	printSubHeader("Generating Observed Network")

	// set up log reader and read once to build trait maps
	logReader.init(logPath)
	var fileCount = 0
	var dataPointsCount = 0
	while (logReader.hasNextLogFile()) {
		++fileCount
		val file = logReader.nextLogFile()
		file.logEntries.forEach { it.traits.forEach {
			++dataPointsCount
			traitTranslator.offer(it)
		} }
	}

	printInfo("found ${traitTranslator.size} unique trait(s) from $dataPointsCount data point(s) in $fileCount file(s)")
}