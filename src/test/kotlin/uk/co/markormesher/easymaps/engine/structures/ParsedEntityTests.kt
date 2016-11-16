package uk.co.markormesher.easymaps.engine.structures

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * These tests are just to silence warnings from JaCoCo.
 */
class ParsedEntityTests {

	@Test
	fun parsedLogEntryDataClassTest() {
		val listOfTraits = ArrayList<Int>()
		listOfTraits.add(123)
		listOfTraits.add(456)

		val parsedLogEntry = ParsedLogEntry(789, listOfTraits)

		assertEquals(2, parsedLogEntry.traits.size)
		assertEquals(789, parsedLogEntry.timestamp)
		assertTrue(parsedLogEntry.traits.contains(123))
		assertTrue(parsedLogEntry.traits.contains(456))
	}

	@Test
	fun parsedLogFileDataClassTest() {
		val listOfParsedLogEntries = ArrayList<ParsedLogEntry>()
		listOfParsedLogEntries.add(ParsedLogEntry(123, ArrayList<Int>()))
		listOfParsedLogEntries.add(ParsedLogEntry(456, ArrayList<Int>()))

		val parsedLogFile = ParsedLogFile(listOfParsedLogEntries)

		assertEquals(2, parsedLogFile.logEntries.size)
	}

}