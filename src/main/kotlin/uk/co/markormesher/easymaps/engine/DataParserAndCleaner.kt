package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.data.Trait
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.log_readers.LogReader
import uk.co.markormesher.easymaps.engine.option_providers.OptionProvider
import uk.co.markormesher.easymaps.engine.trait_translation.TraitTranslator
import java.util.*

fun parseAndCleanData(logReader: LogReader,
					  logPath: String,
					  optionProvider: OptionProvider,
					  traitTranslator: TraitTranslator) {

	printSubHeader("Parsing and Cleaning Data")

	// set up log reader and read once to build trait maps and count unique users per trait
	logReader.init(logPath)
	var fileCount = 0
	var dataPointsCount = 0
	val usersPerTrait = HashMap<Trait, HashSet<String>>()
	while (logReader.hasNextLogFile()) {
		++fileCount
		val file = logReader.nextLogFile()
		file.logEntries.forEach { logEntry ->
			logEntry.traits.forEach { trait ->
				++dataPointsCount

				traitTranslator.offer(trait)

				if (!usersPerTrait.containsKey(trait)) {
					usersPerTrait.put(trait, HashSet<String>())
				}
				usersPerTrait[trait]?.add(logEntry.userId)
			}
		}
	}

	printInfo("found ${traitTranslator.size} unique trait(s) from $dataPointsCount data point(s) in $fileCount file(s)")

	// drop traits that did not meet the required threshold
	val traitsToDrop = ArrayList<Trait>()
	usersPerTrait.forEach { trait, users ->
		if (users.size < optionProvider.uniqueUsersRequiredPerTrait) {
			traitsToDrop.add(trait)
		}
	}
	traitsToDrop.forEach { t -> traitTranslator.remove(t) }

	printInfo("dropped ${traitsToDrop.size} trait(s) that were not observed by ${optionProvider.uniqueUsersRequiredPerTrait} or more users")
	printInfo("continuing with ${traitTranslator.size} trait(s)")

	// TODO: re-write logs into parsed entities

}