package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.core_algo.generateObservedNetwork
import uk.co.markormesher.easymaps.engine.core_algo.matchToKnownNetwork
import uk.co.markormesher.easymaps.engine.core_algo.parseAndCleanData
import uk.co.markormesher.easymaps.engine.core_algo.writeOutput
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.log_readers.LUWifiLogReader
import uk.co.markormesher.easymaps.engine.log_readers.LogReader
import uk.co.markormesher.easymaps.engine.log_readers.SampleLogReader
import uk.co.markormesher.easymaps.engine.option_providers.LUWifiOptionProvider
import uk.co.markormesher.easymaps.engine.option_providers.OptionProvider
import uk.co.markormesher.easymaps.engine.option_providers.SampleOptionProvider
import uk.co.markormesher.easymaps.engine.trait_translation.TraitTranslator
import java.io.File
import java.util.*

private val options = HashMap<String, String?>()

fun main(args: Array<String>) {
	// preamble
	printHeader("EasyMaps Engine $VERSION")

	// options file
	if (args.size == 1) readOptionsFile(args[0])

	// options
	val logReader = selectLogReader()
	val logPath = enterPath("Enter path to log files", "logPath")
	val outputPath = enterPath("Enter output path", "outputPath")
	val optionProvider = selectOptionProvider()
	val traitTranslator = TraitTranslator()

	val parsedLogFiles = parseAndCleanData(logReader, logPath, outputPath, optionProvider, traitTranslator)
	generateObservedNetwork(parsedLogFiles, outputPath, optionProvider, traitTranslator)
	matchToKnownNetwork()
	writeOutput()

	println()
}

fun readOptionsFile(filePath: String) {
	val optFile = File(filePath)
	if (!optFile.exists()) return printError("Could not load options: '$filePath' does not exist")
	if (!optFile.isFile) return printError("Could not load options: '$filePath' is not a file")

	optFile.readLines().forEach { line ->
		val chunks = line.trim().split("=").map(String::trim)
		if (chunks.size == 2) options.put(chunks[0], chunks[1])
	}

	if (options.size > 0) {
		printInfo("Parsed options from file:")
		options.forEach { key, value -> printSubMessage("$key => $value") }
	}
}

fun selectLogReader(): LogReader {
	while (true) {
		var input = options["logReader"]
		options.put("logReader", null)

		val quiet = !input.isNullOrEmpty()
		if (input.isNullOrEmpty()) {
			println("\nSelect log reader [london, sample]")
			print(INPUT_PROMPT)
			input = readLine()!!.trim()
		}

		when (input) {
			"london" -> return LUWifiLogReader()
			"sample" -> return SampleLogReader()
			else -> if (!quiet) printError("that's not a valid option")
		}
	}
}

fun enterPath(prompt: String, optionKey: String): String {
	while (true) {
		var input = options[optionKey]
		options.put(optionKey, null)

		val quiet = !input.isNullOrEmpty()
		if (input.isNullOrEmpty()) {
			println("\n$prompt")
			print(INPUT_PROMPT)
			input = readLine()!!.trim()
		}

		if (!File(input).exists()) {
			if (!quiet) printError("that location doesn't exist")
		} else if (!File(input).isDirectory) {
			if (!quiet) printError("that location isn't a directory")
		} else if (input != null) {
			return if (input.last() == '/') input.drop(1) else input
		}
	}
}

fun selectOptionProvider(): OptionProvider {

	while (true) {
		var input = options["optionProvider"]
		options.put("optionProvider", null)

		val quiet = !input.isNullOrEmpty()
		if (input.isNullOrEmpty()) {
			println("\nSelect option provider [london, sample]")
			print(INPUT_PROMPT)
			input = readLine()!!.trim()
		}

		when (input) {
			"london" -> return LUWifiOptionProvider()
			"sample" -> return SampleOptionProvider()
			else -> if (!quiet) printError("that's not a valid option")
		}
	}
}