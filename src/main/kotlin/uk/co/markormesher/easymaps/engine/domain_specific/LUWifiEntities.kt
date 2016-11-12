package uk.co.markormesher.easymaps.engine.domain_specific

import uk.co.markormesher.easymaps.engine.interfaces.LogEntry
import uk.co.markormesher.easymaps.engine.interfaces.LogFile
import uk.co.markormesher.easymaps.engine.interfaces.Trait

class LUWifiLogFile(override val logEntries: List<LUWifiLogEntry>) : LogFile

class LUWifiLogEntry(
		override val timestamp: Long,
		override val userId: String,
		override val traits: List<LUWifiTrait>) : LogEntry

data class LUWifiTrait(val macAddress: String) : Trait