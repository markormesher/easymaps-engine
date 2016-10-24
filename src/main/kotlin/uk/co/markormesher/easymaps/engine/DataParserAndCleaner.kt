package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.data.ParsedLogEntry
import uk.co.markormesher.easymaps.engine.data.ParsedLogFile
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
					  traitTranslator: TraitTranslator): List<ParsedLogFile> {

	printSubHeader("Parsing and Cleaning Data")

	// set up log reader (will be used twice)
	logReader.init(logPath)

	// build trait maps and count unique users per trait
	var fileCount = 0
	var entryCount = 0
	var dataPointsCount = 0
	val usersPerTrait = HashMap<Trait, HashSet<String>>()
	while (logReader.hasNextLogFile()) {
		++fileCount
		val file = logReader.nextLogFile()
		file.logEntries.forEach { logEntry ->
			++entryCount
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

	printInfo("Read $fileCount log file(s)")
	printInfo("Read $entryCount log entry(ies)")
	printInfo("Read $dataPointsCount data point(s)")
	printInfo("Found ${traitTranslator.size} trait(s)")

	// drop traits that did not meet the required unique observer threshold
	printInfo("Starting unique observer threshold filter...")
	val traitsToDrop = ArrayList<Trait>()
	usersPerTrait.forEach { trait, users ->
		if (users.size < optionProvider.uniqueObserversRequiredPerTrait) {
			traitsToDrop.add(trait)
		}
	}
	traitsToDrop.forEach { t -> traitTranslator.remove(t) }
	printInfo("Dropped ${traitsToDrop.size} trait(s)")

	// more filters can be added here, if necessary

	// finished filtering
	printInfo("Continuing with ${traitTranslator.size} trait(s)")

	// re-write logs into parsed log files
	val parsedLogFiles = ArrayList<ParsedLogFile>()
	var parsedEntryCount = 0
	logReader.resetIterator()
	while (logReader.hasNextLogFile()) {
		val file = logReader.nextLogFile()

		// re-write entries as parsed entries
		val entries = ArrayList<ParsedLogEntry>()
		file.logEntries.forEach { logEntry ->
			val traits = ArrayList<Int>()
			logEntry.traits
					.filter { t -> traitTranslator.containsTrait(t) }
					.forEach { t -> traits.add(traitTranslator.toId(t)) }

			if (traits.isNotEmpty()) {
				entries.add(ParsedLogEntry(logEntry.timestamp, traits.toIntArray()))
				++parsedEntryCount
			}
		}

		if (entries.isNotEmpty()) {
			parsedLogFiles.add(ParsedLogFile(entries))
		}
	}

	// done!
	printInfo("Parsed data into ${parsedLogFiles.size} log file(s) with $parsedEntryCount log entry(ies)")

	return parsedLogFiles
}