package uk.co.markormesher.easymaps.engine.helpers

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class PrintingTests {

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
	fun formattingConstantsShouldBeCorrect() {
		assertEquals("\u001B[0m", ANSI_RESET)
		assertEquals("\u001B[1m", ANSI_BOLD)
		assertEquals("\u001B[107m", ANSI_WHITE_BG)
		assertEquals("\u001B[30m", ANSI_BLACK_TEXT)
		assertEquals("\u001B[31m", ANSI_RED_TEXT)
		assertEquals("\u001B[32m", ANSI_GREEN_TEXT)
		assertEquals("\u001B[33m", ANSI_YELLOW_TEXT)
		assertEquals("\u001B[34m", ANSI_BLUE_TEXT)
		assertEquals("\u001B[35m", ANSI_PURPLE_TEXT)
		assertEquals("\u001B[36m", ANSI_CYAN_TEXT)
		assertEquals("\u001B[37m", ANSI_WHITE_TEXT)
	}

	@Test
	fun formattingShortcutsCouldBeCorrect() {
		val str = "test"
		assertEquals("\u001B[1m$str\u001B[0m", bold(str))
		assertEquals("\u001B[107m$str\u001B[0m", whiteBg(str))
		assertEquals("\u001B[30m$str\u001B[0m", blackText(str))
		assertEquals("\u001B[31m$str\u001B[0m", redText(str))
		assertEquals("\u001B[32m$str\u001B[0m", greenText(str))
		assertEquals("\u001B[33m$str\u001B[0m", yellowText(str))
		assertEquals("\u001B[34m$str\u001B[0m", blueText(str))
		assertEquals("\u001B[35m$str\u001B[0m", purpleText(str))
		assertEquals("\u001B[36m$str\u001B[0m", cyanText(str))
		assertEquals("\u001B[37m$str\u001B[0m", whiteText(str))
	}

	@Test
	fun inputPromptConstantShouldBeCorrect() {
		assertEquals("\u001B[36m\u001B[1m --> \u001B[0m", INPUT_PROMPT)
	}

	@Test
	fun printHeaderShouldFormatCorrectly() {
		val expected = "\n" +
				"\u001B[107m\u001B[31m ~~~~~~~~ \u001B[0m\u001B[0m\n" +
				"\u001B[107m\u001B[31m ~ \u001B[0m\u001B[0m" +
				"\u001B[1m\u001B[107m\u001B[31mTEST\u001B[0m\u001B[0m\u001B[0m" +
				"\u001B[107m\u001B[31m ~ \u001B[0m\u001B[0m\n" +
				"\u001B[107m\u001B[31m ~~~~~~~~ \u001B[0m\u001B[0m\n" +
				"\n"
		printHeader("TEST")
		assertEquals(expected, stdOut.toString())
	}

	@Test
	fun printSubHeaderShouldFormatCorrectly() {
		val expected = "\n" +
				"\u001B[107m\u001B[35m ------ \u001B[0m\u001B[0m\n" +
				"\u001B[107m  \u001B[0m" +
				"\u001B[1m\u001B[107m\u001B[30mTEST\u001B[0m\u001B[0m\u001B[0m" +
				"\u001B[107m  \u001B[0m\n" +
				"\u001B[107m\u001B[35m ------ \u001B[0m\u001B[0m\n" +
				"\n"
		printSubHeader("TEST")
		assertEquals(expected, stdOut.toString())
	}

	@Test
	fun printInfoShouldFormatCorrectly() {
		val expected = "\r \u001B[1m\u001B[33m INFO:\u001B[0m\u001B[0m TEST\n"
		printInfo("TEST")
		assertEquals(expected, stdOut.toString())
	}

	@Test
	fun printWarningShouldFormatCorrectly() {
		val expected = "\r \u001B[1m\u001B[35m WARN:\u001B[0m\u001B[0m TEST\n"
		printWarning("TEST")
		assertEquals(expected, stdOut.toString())
	}

	@Test
	fun printErrorShouldFormatCorrectly() {
		val expected = "\r \u001B[1m\u001B[31mERROR:\u001B[0m\u001B[0m TEST\n"
		printError("TEST")
		assertEquals(expected, stdOut.toString())
	}

	@Test
	fun printSubInfoShouldFormatCorrectly() {
		val expected = "\r        -  TEST\n"
		printSubInfo("TEST")
		assertEquals(expected, stdOut.toString())
	}

	@Test
	fun printSubWarningShouldFormatCorrectly() {
		val expected = "\r        - \u001B[1m\u001B[35m WARN:\u001B[0m\u001B[0m TEST\n"
		printSubWarning("TEST")
		assertEquals(expected, stdOut.toString())
	}

	@Test
	fun printSubErrorShouldFormatCorrectly() {
		val expected = "\r        - \u001B[1m\u001B[31mERROR:\u001B[0m\u001B[0m TEST\n"
		printSubError("TEST")
		assertEquals(expected, stdOut.toString())
	}

}
