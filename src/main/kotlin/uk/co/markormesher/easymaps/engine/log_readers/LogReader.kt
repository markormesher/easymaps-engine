package uk.co.markormesher.easymaps.engine.log_readers

import uk.co.markormesher.easymaps.engine.data.LogFile

interface LogReader {

	fun init(location: String)

	fun getFileCount(): Int

	fun hasNextLogFile(): Boolean

	fun nextLogFile(): LogFile

	fun resetIterator()

}