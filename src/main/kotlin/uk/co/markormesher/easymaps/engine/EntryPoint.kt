package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.core.generateObservedNetwork
import uk.co.markormesher.easymaps.engine.core.matchToKnownNetwork
import uk.co.markormesher.easymaps.engine.core.parseAndCleanData
import uk.co.markormesher.easymaps.engine.core.writeOutput
import uk.co.markormesher.easymaps.engine.domain_specific.LUWifiLogReader
import uk.co.markormesher.easymaps.engine.domain_specific.LUWifiOptionProvider
import uk.co.markormesher.easymaps.engine.domain_specific.SampleLogReader
import uk.co.markormesher.easymaps.engine.domain_specific.SampleOptionProvider
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.interfaces.LogReader
import uk.co.markormesher.easymaps.engine.interfaces.OptionProvider
import uk.co.markormesher.easymaps.engine.structures.TraitTranslator
import java.io.File
import java.util.*

private val options = HashMap<String, String?>()

private val PATH_TYPE_FILE = 1
private val PATH_TYPE_FOLDER = 2

data class Config(
		val logReader: LogReader,
		val optionProvider: OptionProvider,
		val traitTranslator: TraitTranslator,
		val logPath: String,
		val outputPath: String,
		val dotExec: String
)

fun main(args: Array<String>) {
	// preamble
	printHeader("EasyMaps Engine $VERSION")

	// options file
	if (args.size == 1) readOptionsFile(args[0])

	// options
	val config = Config(
			logReader = selectLogReader(),
			optionProvider = selectOptionProvider(),
			traitTranslator = TraitTranslator(),
			logPath = enterPath("Enter path to log files", "logPath", PATH_TYPE_FOLDER),
			outputPath = enterPath("Enter output path", "outputPath", PATH_TYPE_FOLDER),
			dotExec = enterPath("Enter path to GraphViz drawing executable (probably dot or neato)", "dotExec", PATH_TYPE_FILE)
	)

	val parsedLogFiles = parseAndCleanData(config)
	generateObservedNetwork(parsedLogFiles, config)
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
		options.forEach { key, value -> printSubInfo("$key => $value") }
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

fun enterPath(prompt: String, optionKey: String, searchType: Int = -1): String {
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
		} else if (searchType == PATH_TYPE_FOLDER && !File(input).isDirectory) {
			if (!quiet) printError("that location isn't a directory")
		} else if (searchType == PATH_TYPE_FILE && !File(input).isFile) {
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