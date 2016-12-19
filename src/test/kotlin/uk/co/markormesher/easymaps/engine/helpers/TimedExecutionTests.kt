package uk.co.markormesher.easymaps.engine.helpers

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.regex.Pattern
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TimedExecutionTests {

	var originalStdOut: PrintStream? = null
	val stdOut = ByteArrayOutputStream()

	@Before
	fun setupStreams() {
		originalStdOut = System.out
		System.setOut(PrintStream(stdOut))
	}

	@After
	fun cleanUpStreams() {
		System.setOut(originalStdOut)
	}

	@Test
	fun timedExecutionShouldPrintCorrectMetaData() {
		timedExecution("Test Title", 1, 3, {
			Thread.sleep(50)
		})

		val output = stdOut.toString()
		assertTrue(output.contains("Timing 'Test Title':"))
		assertTrue(output.contains("Pre-running"))
		assertTrue(output.contains("Running"))
	}

	@Test
	fun timedExecutionShouldReportAccurateTimeToWithin2Percent() {
		val duration = 0.1
		timedExecution("Test Title", 1, 3, {
			Thread.sleep((duration * 1000).toLong())
		})

		val output = stdOut.toString()
		val matcher = Pattern.compile("\\d\\.\\d{4} s").matcher(output)
		while (matcher.find()) {
			val time = matcher.group().dropLast(2).toDouble()
			assertTrue(time >= duration * 0.98)
			assertTrue(time <= duration * 1.02)
		}
	}

	@Test
	fun timedExecutionShouldRunCorrectNumberOfIterations() {
		val duration = 0.1
		timedExecution("Test Title", 2, 3, {
			Thread.sleep((duration * 1000).toLong())
		})

		val output = stdOut.toString()
		val matcher = Pattern.compile("\\d\\.\\d{4} s").matcher(output)
		var count = 0
		while (matcher.find()) ++count
		assertEquals(4, count) // 6 = 3 run + 1 average
	}

}
