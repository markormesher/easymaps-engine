package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.data.ParsedLogEntry
import uk.co.markormesher.easymaps.engine.data.ParsedLogFile
import uk.co.markormesher.easymaps.engine.data.Trait
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.helpers.printSubMessage
import uk.co.markormesher.easymaps.engine.log_readers.LogReader
import uk.co.markormesher.easymaps.engine.option_providers.OptionProvider
import uk.co.markormesher.easymaps.engine.trait_translation.TraitTranslator
import java.util.*

fun parseAndCleanData(logReader: LogReader,
					  logPath: String,
					  optionProvider: OptionProvider,
					  traitTranslator: TraitTranslator): List<ParsedLogFile> {
	printSubHeader("Parsing and Cleaning Data")
	logReader.init(logPath)
	buildTraitMap(logReader, traitTranslator)
	applyObserverCountFilter(logReader, optionProvider, traitTranslator)
	printInfo("Continuing with ${traitTranslator.size} trait(s)")
	return convertLogsIntoParsedLogs(logReader, traitTranslator)
}

private fun buildTraitMap(
		logReader: LogReader,
		traitTranslator: TraitTranslator) {

	logReader.resetIterator()
	printInfo("Building trait map...")

	var fileCount = 0
	var entryCount = 0
	var dataPointsCount = 0

	while (logReader.hasNextLogFile()) {
		++fileCount
		val file = logReader.nextLogFile()
		file.logEntries.forEach { logEntry ->
			++entryCount
			logEntry.traits.forEach { trait ->
				++dataPointsCount
				traitTranslator.offer(trait)
			}
		}
	}

	printSubMessage("Read $fileCount log file(s)")
	printSubMessage("Read $entryCount log entry(ies)")
	printSubMessage("Read $dataPointsCount data point(s)")
	printSubMessage("Found ${traitTranslator.size} trait(s)")
}

private fun applyObserverCountFilter(
		logReader: LogReader,
		optionProvider: OptionProvider,
		traitTranslator: TraitTranslator) {

	logReader.resetIterator()
	printInfo("Starting unique observer threshold filter...")

	// count unique observers per trait
	val observersPerTrait = HashMap<Trait, HashSet<String>>()
	while (logReader.hasNextLogFile()) {
		val file = logReader.nextLogFile()
		file.logEntries.forEach { logEntry ->
			logEntry.traits.forEach { trait ->
				if (!observersPerTrait.containsKey(trait)) {
					observersPerTrait.put(trait, HashSet<String>())
				}
				observersPerTrait[trait]?.add(logEntry.userId)
			}
		}
	}

	// drop traits that did not meet the required unique observer threshold
	val traitsToDrop = ArrayList<Trait>()
	observersPerTrait.forEach { trait, users ->
		if (users.size < optionProvider.uniqueObserversRequiredPerTrait) {
			traitsToDrop.add(trait)
		}
	}
	traitsToDrop.forEach { t -> traitTranslator.remove(t) }

	printSubMessage("Dropped ${traitsToDrop.size} trait(s)")
}

private fun convertLogsIntoParsedLogs(
		logReader: LogReader,
		traitTranslator: TraitTranslator)
		: List<ParsedLogFile> {

	printInfo("Converting raw logs into parsed logs...")
	logReader.resetIterator()

	val parsedLogFiles = ArrayList<ParsedLogFile>()
	var parsedEntryCount = 0
	while (logReader.hasNextLogFile()) {
		val file = logReader.nextLogFile()

		// parse entries for this file
		val entries = ArrayList<ParsedLogEntry>()
		file.logEntries.forEach { logEntry ->
			val parsedTraits = logEntry.traits
					.filter { t -> traitTranslator.containsTrait(t) }
					.map { t -> traitTranslator.toId(t) }
					.toIntArray()

			if (parsedTraits.isNotEmpty()) {
				entries.add(ParsedLogEntry(logEntry.timestamp, parsedTraits))
				++parsedEntryCount
			}
		}

		if (entries.isNotEmpty()) {
			parsedLogFiles.add(ParsedLogFile(entries))
		}
	}

	printSubMessage("Parsed data into ${parsedLogFiles.size} log file(s) with $parsedEntryCount log entry(ies)")

	return parsedLogFiles
}