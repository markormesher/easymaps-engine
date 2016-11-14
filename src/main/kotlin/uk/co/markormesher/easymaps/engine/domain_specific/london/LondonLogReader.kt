package uk.co.markormesher.easymaps.engine.domain_specific.london

import uk.co.markormesher.easymaps.engine.helpers.printSubInfo
import uk.co.markormesher.easymaps.engine.helpers.printWarning
import uk.co.markormesher.easymaps.engine.interfaces.LogFile
import uk.co.markormesher.easymaps.engine.interfaces.LogReader
import java.io.File
import java.util.*
import java.util.regex.Pattern

class LondonLogReader : LogReader {

	val filePaths = ArrayList<String>()
	var currentFile = -1
	val validLinePattern = Pattern.compile("\\[([a-z0-9\\-]+),(\\d+)((,[a-f0-9:]+)+)\\]")!!

	override fun init(location: String) {
		val folder = File(location)
		if (!folder.exists()) throw Exception("Could not load logs: file path does not exist")
		if (!folder.isDirectory) throw Exception("Could not load logs: file path is not a folder")

		folder.listFiles()
				.filter { f -> f.isFile }
				.filter { f -> f.name != ".gitignore" }
				.forEach { f -> filePaths.add(f.absolutePath) }
	}

	override fun getFileCount(): Int {
		return filePaths.size
	}

	override fun hasNextLogFile(): Boolean {
		return filePaths.isNotEmpty() && currentFile < filePaths.size - 1
	}

	override fun nextLogFile(): LogFile {
		val path = filePaths[++currentFile]
		val file = File(path)

		val logEntries = ArrayList<LondonLogEntry>()
		var lineCounter = 0
		file.forEachLine { line ->
			++lineCounter

			// validate line
			val cleanLine = line.trim()
			if (cleanLine.isBlank()) return@forEachLine
			if (!validLinePattern.matcher(cleanLine).matches()) {
				printWarning("Skipping invalid log entry")
				printSubInfo("File: $path")
				printSubInfo("Line: $lineCounter")
				return@forEachLine
			}

			// explode line to get components
			// chunks = [userId, timestamp, traits...]
			val lineChunks = cleanLine.drop(1).dropLast(1).split(",")
			val userId = lineChunks[0]
			val timestamp = lineChunks[1].toLong()
			val traits = ArrayList<LondonTrait>()
			lineChunks.drop(2).forEach { c -> traits.add(LondonTrait(c)) }

			logEntries.add(LondonLogEntry(timestamp, userId, traits))
		}
		return LondonLogFile(logEntries)
	}

	override fun resetIterator() {
		currentFile = -1
	}
}