package uk.co.markormesher.easymaps.engine.core_algo

import uk.co.markormesher.easymaps.engine.data.ParsedLogEntry
import uk.co.markormesher.easymaps.engine.data.ParsedLogFile
import uk.co.markormesher.easymaps.engine.data.Trait
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.helpers.printSubMessage
import uk.co.markormesher.easymaps.engine.log_readers.LogReader
import uk.co.markormesher.easymaps.engine.option_providers.OptionProvider
import uk.co.markormesher.easymaps.engine.trait_translation.TraitTranslator
import java.io.PrintWriter
import java.util.*

fun parseAndCleanData(
		logReader: LogReader,
		logPath: String,
		outputPath: String,
		optionProvider: OptionProvider,
		traitTranslator: TraitTranslator)
		: List<ParsedLogFile> {

	printSubHeader("Parsing and Cleaning Data")
	logReader.init(logPath)
	buildTraitMap(logReader, traitTranslator)
	createLeaderBoardData(logReader, outputPath)
	applyObserverCountFilter(logReader, optionProvider, traitTranslator)
	printInfo("Continuing with ${traitTranslator.size} trait(s)")
	return convertLogsIntoParsedLogs(logReader, traitTranslator)
}

private fun buildTraitMap(
		logReader: LogReader,
		traitTranslator: TraitTranslator) {

	printInfo("Building trait map...")

	var entryCount = 0
	var dataPointsCount = 0

	logReader.resetIterator()
	while (logReader.hasNextLogFile()) {
		val file = logReader.nextLogFile()
		entryCount += file.logEntries.size
		file.logEntries.forEach { logEntry ->
			dataPointsCount += logEntry.traits.size
			logEntry.traits.forEach { trait -> traitTranslator.offer(trait) }
		}
	}

	printSubMessage("Read ${logReader.getFileCount()} log file(s)")
	printSubMessage("Read $entryCount log entry(ies)")
	printSubMessage("Read $dataPointsCount data point(s)")
	printSubMessage("Found ${traitTranslator.size} trait(s)")
}

private fun createLeaderBoardData(
		logReader: LogReader, outputPath: String) {

	printInfo("Creating leader-board data...")

	val totalDataPerUser = HashMap<String, Int>()
	val uniquePointsPerUser = HashMap<String, HashSet<Trait>>()

	logReader.resetIterator()
	while (logReader.hasNextLogFile()) {
		val file = logReader.nextLogFile()

		file.logEntries.forEach { logEntry ->
			val userId = logEntry.userId
			if (!totalDataPerUser.containsKey(userId)) totalDataPerUser.put(userId, 0)
			if (!uniquePointsPerUser.containsKey(userId)) uniquePointsPerUser.put(userId, HashSet<Trait>())

			logEntry.traits.forEach { trait ->
				totalDataPerUser[userId] = totalDataPerUser[userId]!!.plus(1)
				uniquePointsPerUser[userId]!!.add(trait)
			}
		}
	}

	val sb = StringBuilder()
	sb.append("{\n\"updated\": ").append(System.currentTimeMillis() / 1000).append(",\n\"users\": {")
	for ((userId, volumeCount)in totalDataPerUser) {
		sb.append("\n\"$userId\": {\"volume\": $volumeCount, \"unique\": ${uniquePointsPerUser[userId]!!.size}},")
	}
	sb.setLength(sb.length - 1)
	sb.append("\n}\n}")

	val file = "$outputPath/leader-board-data.json"
	val writer = PrintWriter(file, "UTF-8")
	writer.print(sb.toString())
	writer.close()

	printSubMessage("Data written to $file")
}

private fun applyObserverCountFilter(
		logReader: LogReader,
		optionProvider: OptionProvider,
		traitTranslator: TraitTranslator) {

	printInfo("Running unique observer threshold filter...")

	val observersPerTrait = HashMap<Trait, HashSet<String>>()

	logReader.resetIterator()
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

	val parsedLogFiles = ArrayList<ParsedLogFile>()
	var parsedEntryCount = 0

	logReader.resetIterator()
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