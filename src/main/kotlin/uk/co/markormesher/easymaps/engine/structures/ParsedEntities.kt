package uk.co.markormesher.easymaps.engine.structures

class ParsedLogFile(val logEntries: List<ParsedLogEntry>)

class ParsedLogEntry(val timestamp: Long, val traits: List<Int>)