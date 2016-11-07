package uk.co.markormesher.easymaps.engine.domain_specific

import uk.co.markormesher.easymaps.engine.domain_specific.LUWifiLogEntry
import uk.co.markormesher.easymaps.engine.domain_specific.LUWifiLogFile
import uk.co.markormesher.easymaps.engine.domain_specific.LUWifiTrait
import uk.co.markormesher.easymaps.engine.interfaces.LogFile
import uk.co.markormesher.easymaps.engine.helpers.printSubInfo
import uk.co.markormesher.easymaps.engine.helpers.printWarning
import uk.co.markormesher.easymaps.engine.interfaces.LogReader
import java.io.File
import java.util.*
import java.util.regex.Pattern

class LUWifiLogReader : LogReader {

	val filePaths = ArrayList<String>()
	var currentFile = -1
	val validLinePattern = Pattern.compile("\\[([a-z0-9\\-]+),(\\d+)((,[a-f0-9:]+)+)\\]")!!

	override fun init(location: String) {
		val folder = File(location)
		if (!folder.exists()) throw Exception("Could not load logs: file path does not exist")
		if (!folder.isDirectory) throw Exception("Could not load logs: file path is not a folder")

		folder.listFiles()
				.filter { f -> f.isFile }
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

		val logEntries = ArrayList<LUWifiLogEntry>()
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
			val traits = ArrayList<LUWifiTrait>()
			lineChunks.drop(2).forEach { c -> traits.add(LUWifiTrait(c)) }

			logEntries.add(LUWifiLogEntry(timestamp, userId, traits))
		}
		return LUWifiLogFile(logEntries)
	}

	override fun resetIterator() {
		currentFile = -1
	}
}