package uk.co.markormesher.easymaps.engine.data

class ParsedLogFile(val logEntries: List<LogEntry>)

class ParsedLogEntry(val timestamp: Long, val traits: IntArray)