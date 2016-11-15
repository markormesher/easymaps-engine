package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.EngineConfig
import uk.co.markormesher.easymaps.engine.PrematureFailureException
import uk.co.markormesher.easymaps.engine.helpers.printError
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.helpers.printSubInfo
import uk.co.markormesher.easymaps.engine.interfaces.Trait
import uk.co.markormesher.easymaps.engine.structures.ParsedLogEntry
import uk.co.markormesher.easymaps.engine.structures.ParsedLogFile
import java.io.PrintWriter
import java.util.*

// TODO: tests for data parsing and cleaning
fun parseAndCleanData(cfg: EngineConfig): List<ParsedLogFile> {

	printSubHeader("Parsing and Cleaning Data")

	cfg.logReader.init(cfg.logFolderPath)
	buildTraitMap(cfg)
	generateLeaderBoardData(cfg)
	printInfo("Applying filters")
	applyObserverCountFilter(cfg)
	if (cfg.traitTranslator.size == 0) {
		printError("Cannot continue with 0 traits")
		throw PrematureFailureException()
	}
	printSubInfo("Continuing with ${cfg.traitTranslator.size} trait(s)")
	return convertLogsIntoParsedLogs(cfg)
}

private fun buildTraitMap(cfg: EngineConfig) {

	printInfo("Building trait map")

	var entryCount = 0
	var dataPointsCount = 0

	cfg.logReader.resetIterator()
	while (cfg.logReader.hasNextLogFile()) {
		val file = cfg.logReader.nextLogFile()
		entryCount += file.logEntries.size
		file.logEntries.forEach { logEntry ->
			dataPointsCount += logEntry.traits.size
			logEntry.traits.forEach { trait -> cfg.traitTranslator.offerTrait(trait) }
		}
	}

	printSubInfo("Read ${cfg.logReader.getFileCount()} log file(s)")
	printSubInfo("Read $entryCount log entry(ies)")
	printSubInfo("Read $dataPointsCount data point(s)")
	printSubInfo("Found ${cfg.traitTranslator.size} trait(s)")
}

private fun generateLeaderBoardData(cfg: EngineConfig) {

	printInfo("Creating leader-board data")

	val totalDataPerUser = HashMap<String, Int>()
	val uniquePointsPerUser = HashMap<String, HashSet<Trait>>()

	cfg.logReader.resetIterator()
	while (cfg.logReader.hasNextLogFile()) {
		val file = cfg.logReader.nextLogFile()

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
	sb.append("{\n\"updated\": ").append(System.currentTimeMillis()).append(",\n\"users\": {")
	for ((userId, volumeCount) in totalDataPerUser) {
		sb.append("\n\"$userId\": {\"volume\": $volumeCount, \"unique\": ${uniquePointsPerUser[userId]!!.size}},")
	}
	sb.setLength(sb.length - 1)
	sb.append("\n}\n}")

	val file = "${cfg.outputFolderPath}/leader-board-data.json"
	with(PrintWriter(file, "UTF-8")) {
		print(sb.toString())
		close()
	}

	printSubInfo("Data written to $file")
}

private fun applyObserverCountFilter(cfg: EngineConfig) {

	val observersPerTrait = HashMap<Trait, HashSet<String>>()
	cfg.logReader.resetIterator()
	while (cfg.logReader.hasNextLogFile()) {
		val file = cfg.logReader.nextLogFile()
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
		if (users.size < cfg.optionProvider.uniqueObserversRequiredPerTrait) {
			traitsToDrop.add(trait)
		}
	}
	traitsToDrop.forEach { t -> cfg.traitTranslator.removeTrait(t) }

	printSubInfo("Unique observer threshold filter dropped ${traitsToDrop.size} trait(s)")
}

private fun convertLogsIntoParsedLogs(cfg: EngineConfig): List<ParsedLogFile> {

	printInfo("Converting raw logs into parsed logs")

	val parsedLogFiles = ArrayList<ParsedLogFile>()
	var parsedEntryCount = 0

	cfg.logReader.resetIterator()
	while (cfg.logReader.hasNextLogFile()) {
		val file = cfg.logReader.nextLogFile()

		// parse entries for this file
		val entries = ArrayList<ParsedLogEntry>()
		file.logEntries.forEach { logEntry ->
			val parsedTraits = ArrayList<Int>()
			logEntry.traits
					.map { t -> cfg.traitTranslator.getTraitId(t) }
					.filter { t -> t != cfg.traitTranslator.INVALID_ID }
					.forEach { t -> parsedTraits.add(t) }

			if (parsedTraits.isNotEmpty()) {
				entries.add(ParsedLogEntry(logEntry.timestamp, parsedTraits))
				++parsedEntryCount
			}
		}

		if (entries.isNotEmpty()) {
			parsedLogFiles.add(ParsedLogFile(entries))
		}
	}

	printSubInfo("Parsed data into ${parsedLogFiles.size} log file(s) with $parsedEntryCount log entry(ies)")

	return parsedLogFiles
}