package uk.co.markormesher.easymaps.engine.log_readers

import uk.co.markormesher.easymaps.engine.data.LUWifiLogEntry
import uk.co.markormesher.easymaps.engine.data.LUWifiLogFile
import uk.co.markormesher.easymaps.engine.data.LUWifiTrait
import uk.co.markormesher.easymaps.engine.data.LogFile
import java.io.File
import java.util.*
import java.util.regex.Pattern

class SampleLogReader : LogReader {

	val filePaths = ArrayList<String>()
	var currentFile = -1
	val validLinePattern = Pattern.compile("\\[([a-z0-9\\-]+),(\\d+)((,trait_[0-9]+)+)\\]")!!

	override fun init(location: String) {
		val folder = File(location)
		if (!folder.exists()) throw Exception("Could not load logs: file path does not exist")
		if (!folder.isDirectory) throw Exception("Could not load logs: file path is not a folder")

		folder.listFiles()
				.filter { f -> f.isFile }
				.forEach { f -> filePaths.add(f.absolutePath) }
	}

	override fun logFileCount(): Int {
		return filePaths.size
	}

	override fun hasNextLogFile(): Boolean {
		return filePaths.isNotEmpty() && currentFile < filePaths.size - 1
	}

	override fun nextLogFile(): LogFile {
		val path = filePaths[++currentFile]
		val file = File(path)

		//println(path)

		val logEntries = ArrayList<LUWifiLogEntry>()
		var lineCounter = 0
		file.forEachLine { line ->
			++lineCounter

			// validate line
			val cleanLine = line.trim()
			if (cleanLine.isBlank()) return@forEachLine
			if (!validLinePattern.matcher(cleanLine).matches()) {
				println("Skipping invalid log entry")
				println("- Line $lineCounter in $path")
				return@forEachLine
			}

			// explode line to get components
			// chunks[0] = userId
			// chunks[1] = timestamp
			// chunks[2..n-1] = traits
			val lineChunks = cleanLine.drop(1).dropLast(1).split(",")
			val timestamp = lineChunks[1].toLong()
			val traits = ArrayList<LUWifiTrait>()
			lineChunks.drop(2).forEach { c -> traits.add(LUWifiTrait(c)) }

			logEntries.add(LUWifiLogEntry(timestamp, traits))
		}

		return LUWifiLogFile(logEntries)
	}

	override fun resetIterator() {
		currentFile = -1
	}
}