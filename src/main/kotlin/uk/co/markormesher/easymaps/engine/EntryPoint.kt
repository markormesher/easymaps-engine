package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.log_readers.LUWifiLogReader
import uk.co.markormesher.easymaps.engine.log_readers.LogReader
import uk.co.markormesher.easymaps.engine.log_readers.SampleLogReader
import uk.co.markormesher.easymaps.engine.option_providers.LUWifiOptionProvider
import uk.co.markormesher.easymaps.engine.option_providers.OptionProvider
import uk.co.markormesher.easymaps.engine.option_providers.SampleOptionProvider
import uk.co.markormesher.easymaps.engine.trait_translation.TraitTranslator

fun main(args: Array<String>) {
	// preamble
	println("EasyMaps Engine $VERSION")
	println()

	// options
	val logReader = selectLogReader()
	val logPath = enterLogPath()
	val optionProvider = selectOptionProvider()
	val traitTranslator = TraitTranslator()

	generateObservedNetwork(logReader, logPath, optionProvider, traitTranslator)
}

fun selectLogReader(): LogReader {
	while (true) {
		println("\nSelect log reader: [london, sample] ")
		when (readLine()!!.trim()) {
			"london" -> return LUWifiLogReader()
			"sample" -> return SampleLogReader()
			else -> println("Sorry, that's not a valid option!")
		}
	}
}

fun enterLogPath(): String {
	println("\nEnter path to log files: ")
	return readLine()!!.trim()
}

fun selectOptionProvider(): OptionProvider {
	while (true) {
		println("\nSelect option provider: [london, sample] ")
		when (readLine()!!.trim()) {
			"london" -> return LUWifiOptionProvider()
			"sample" -> return SampleOptionProvider()
			else -> println("Sorry, that's not a valid option!")
		}
	}
}