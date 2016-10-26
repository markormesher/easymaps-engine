package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.core_algo.generateObservedNetwork
import uk.co.markormesher.easymaps.engine.core_algo.matchToKnownNetwork
import uk.co.markormesher.easymaps.engine.core_algo.parseAndCleanData
import uk.co.markormesher.easymaps.engine.core_algo.writeOutput
import uk.co.markormesher.easymaps.engine.helpers.INPUT_PROMPT
import uk.co.markormesher.easymaps.engine.helpers.VERSION
import uk.co.markormesher.easymaps.engine.helpers.printError
import uk.co.markormesher.easymaps.engine.helpers.printHeader
import uk.co.markormesher.easymaps.engine.log_readers.LUWifiLogReader
import uk.co.markormesher.easymaps.engine.log_readers.LogReader
import uk.co.markormesher.easymaps.engine.log_readers.SampleLogReader
import uk.co.markormesher.easymaps.engine.option_providers.LUWifiOptionProvider
import uk.co.markormesher.easymaps.engine.option_providers.OptionProvider
import uk.co.markormesher.easymaps.engine.option_providers.SampleOptionProvider
import uk.co.markormesher.easymaps.engine.trait_translation.TraitTranslator
import java.io.File

fun main(args: Array<String>) {
	// preamble
	printHeader("EasyMaps Engine $VERSION")

	// options
	val logReader = selectLogReader()
	val logPath = enterPath("Enter path to log files")
	val outputPath = enterPath("Enter output path")
	val optionProvider = selectOptionProvider()
	val traitTranslator = TraitTranslator()

	val parsedLogFiles = parseAndCleanData(logReader, logPath, outputPath, optionProvider, traitTranslator)
	generateObservedNetwork(parsedLogFiles, optionProvider, traitTranslator)
	matchToKnownNetwork()
	writeOutput()

	println()
}

fun selectLogReader(): LogReader {
	while (true) {
		println("\nSelect log reader [london, sample]")
		print(INPUT_PROMPT)
		when (readLine()!!.trim()) {
			"london" -> return LUWifiLogReader()
			"sample" -> return SampleLogReader()
			else -> printError("that's not a valid option")
		}
	}
}

fun enterPath(prompt: String): String {
	while (true) {
		println("\n$prompt")
		print(INPUT_PROMPT)
		val choice = readLine()!!.trim()
		if (!File(choice).exists()) {
			printError("that location doesn't exist")
		} else if (!File(choice).isDirectory) {
			printError("that location isn't a directory")
		} else {
			return if (choice.last() == '/') choice.drop(1) else choice
		}
	}
}

fun selectOptionProvider(): OptionProvider {
	while (true) {
		println("\nSelect option provider [london, sample]")
		print(INPUT_PROMPT)
		when (readLine()!!.trim()) {
			"london" -> return LUWifiOptionProvider()
			"sample" -> return SampleOptionProvider()
			else -> printError("that's not a valid option")
		}
	}
}