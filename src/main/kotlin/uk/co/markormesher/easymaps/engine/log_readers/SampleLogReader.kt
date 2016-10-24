package uk.co.markormesher.easymaps.engine.log_readers

import uk.co.markormesher.easymaps.engine.data.LogFile
import uk.co.markormesher.easymaps.engine.data.SampleLogEntry
import uk.co.markormesher.easymaps.engine.data.SampleLogFile
import uk.co.markormesher.easymaps.engine.data.SampleTrait
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

		val logEntries = ArrayList<SampleLogEntry>()
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
			// chunks = [userId, timestamp, traits...]
			val lineChunks = cleanLine.drop(1).dropLast(1).split(",")
			val userId = lineChunks[0]
			val timestamp = lineChunks[1].toLong()
			val traits = ArrayList<SampleTrait>()
			lineChunks.drop(2).forEach { c -> traits.add(SampleTrait(c)) }

			logEntries.add(SampleLogEntry(timestamp, userId, traits))
		}

		return SampleLogFile(logEntries)
	}

	override fun resetIterator() {
		currentFile = -1
	}
}