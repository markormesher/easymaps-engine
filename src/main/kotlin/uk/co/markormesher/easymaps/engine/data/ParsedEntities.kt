package uk.co.markormesher.easymaps.engine.data

class ParsedLogFile(val logEntries: List<ParsedLogEntry>)

class ParsedLogEntry(val timestamp: Long, val traits: List<Int>)