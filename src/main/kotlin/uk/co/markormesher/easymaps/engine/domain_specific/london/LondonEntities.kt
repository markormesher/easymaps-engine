package uk.co.markormesher.easymaps.engine.domain_specific.london

import uk.co.markormesher.easymaps.engine.interfaces.LogEntry
import uk.co.markormesher.easymaps.engine.interfaces.LogFile
import uk.co.markormesher.easymaps.engine.interfaces.Trait

class LondonLogFile(override val logEntries: List<LondonLogEntry>) : LogFile

class LondonLogEntry(
		override val timestamp: Long,
		override val userId: String,
		override val traits: List<LondonTrait>) : LogEntry

data class LondonTrait(val macAddress: String) : Trait