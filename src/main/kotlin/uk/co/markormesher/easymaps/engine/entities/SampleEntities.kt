package uk.co.markormesher.easymaps.engine.entities

class SampleLogFile(
		override val logEntries: List<LogEntry>) : LogFile

class SampleLogEntry(
		override val timestamp: Long,
		override val userId: String,
		override val traits: List<Trait>) : LogEntry

data class SampleTrait(
		val trait: String) : Trait