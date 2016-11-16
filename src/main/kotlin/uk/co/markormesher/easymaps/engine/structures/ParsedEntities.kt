package uk.co.markormesher.easymaps.engine.structures

class ParsedLogEntry(val timestamp: Long, val traits: List<Int>)

class ParsedLogFile(val logEntries: List<ParsedLogEntry>)
