package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.Config
import uk.co.markormesher.easymaps.engine.data.ParsedLogEntry
import uk.co.markormesher.easymaps.engine.data.ParsedLogFile
import uk.co.markormesher.easymaps.engine.interfaces.Trait
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.helpers.printSubInfo
import java.io.PrintWriter
import java.util.*

fun parseAndCleanData(cfg: Config): List<ParsedLogFile> {

	printSubHeader("Parsing and Cleaning Data")

	cfg.logReader.init(cfg.logPath)
	buildTraitMap(cfg)
	generateLeaderBoardData(cfg)
	applyObserverCountFilter(cfg)
	printInfo("Continuing with ${cfg.traitTranslator.size} trait(s)")
	return convertLogsIntoParsedLogs(cfg)
}

private fun buildTraitMap(cfg: Config) {

	printInfo("Building trait map...")

	var entryCount = 0
	var dataPointsCount = 0

	cfg.logReader.resetIterator()
	while (cfg.logReader.hasNextLogFile()) {
		val file = cfg.logReader.nextLogFile()
		entryCount += file.logEntries.size
		file.logEntries.forEach { logEntry ->
			dataPointsCount += logEntry.traits.size
			logEntry.traits.forEach { trait -> cfg.traitTranslator.offer(trait) }
		}
	}

	printSubInfo("Read ${cfg.logReader.getFileCount()} log file(s)")
	printSubInfo("Read $entryCount log entry(ies)")
	printSubInfo("Read $dataPointsCount data point(s)")
	printSubInfo("Found ${cfg.traitTranslator.size} trait(s)")
}

private fun generateLeaderBoardData(cfg: Config) {

	printInfo("Creating leader-board data...")

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

	val file = "${cfg.outputPath}/leader-board-data.json"
	val writer = PrintWriter(file, "UTF-8")
	writer.print(sb.toString())
	writer.close()

	printSubInfo("Data written to $file")
}

private fun applyObserverCountFilter(cfg: Config) {

	printInfo("Running unique observer threshold filter...")

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
	traitsToDrop.forEach { t -> cfg.traitTranslator.remove(t) }

	printSubInfo("Dropped ${traitsToDrop.size} trait(s)")
}

private fun convertLogsIntoParsedLogs(cfg: Config): List<ParsedLogFile> {

	printInfo("Converting raw logs into parsed logs...")

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
					.filter { t -> cfg.traitTranslator.containsTrait(t) }
					.map { t -> cfg.traitTranslator.toId(t) }
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