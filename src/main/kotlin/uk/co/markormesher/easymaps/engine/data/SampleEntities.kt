package uk.co.markormesher.easymaps.engine.data

class SampleLogFile(override val logEntries: List<LogEntry>) : LogFile

class SampleLogEntry(override val timestamp: Long, override val userId: String, override val traits: List<Trait>) : LogEntry

data class SampleTrait(val macAddress: String) : Trait