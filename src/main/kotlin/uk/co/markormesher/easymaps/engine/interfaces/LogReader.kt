package uk.co.markormesher.easymaps.engine.interfaces

import uk.co.markormesher.easymaps.engine.interfaces.LogFile

interface LogReader {

	fun init(location: String)

	fun getFileCount(): Int

	fun hasNextLogFile(): Boolean

	fun nextLogFile(): LogFile

	fun resetIterator()

}