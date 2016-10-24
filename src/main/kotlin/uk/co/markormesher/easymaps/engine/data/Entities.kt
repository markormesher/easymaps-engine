package uk.co.markormesher.easymaps.engine.data

interface LogFile {
	val logEntries: List<LogEntry>
}

interface LogEntry {
	val timestamp: Long
	val userId: String
	val traits: List<Trait>
}

interface Trait