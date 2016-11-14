package uk.co.markormesher.easymaps.engine.domain_specific.sample

import uk.co.markormesher.easymaps.engine.interfaces.LogEntry
import uk.co.markormesher.easymaps.engine.interfaces.LogFile
import uk.co.markormesher.easymaps.engine.interfaces.Trait

class SampleLogFile(override val logEntries: List<SampleLogEntry>) : LogFile

class SampleLogEntry(
		override val timestamp: Long,
		override val userId: String,
		override val traits: List<SampleTrait>) : LogEntry

data class SampleTrait(val trait: String) : Trait {
	override fun toString(): String = trait
}