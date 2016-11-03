package uk.co.markormesher.easymaps.engine.entities

class LUWifiLogFile(
		override val logEntries: List<LogEntry>) : LogFile

class LUWifiLogEntry(
		override val timestamp: Long,
		override val userId: String,
		override val traits: List<Trait>) : LogEntry

data class LUWifiTrait(val macAddress: String) : Trait