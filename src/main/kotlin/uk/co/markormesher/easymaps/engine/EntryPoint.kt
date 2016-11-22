package uk.co.markormesher.easymaps.engine

import uk.co.markormesher.easymaps.engine.domain_specific.london.LondonLogReader
import uk.co.markormesher.easymaps.engine.domain_specific.london.LondonOptionProvider
import uk.co.markormesher.easymaps.engine.domain_specific.sample.SampleLogReader
import uk.co.markormesher.easymaps.engine.domain_specific.sample.SampleOptionProvider
import uk.co.markormesher.easymaps.engine.domain_specific.sample.SampleWalkerOptionProvider
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.interfaces.LogReader
import uk.co.markormesher.easymaps.engine.interfaces.OptionProvider
import uk.co.markormesher.easymaps.engine.interfaces.WalkerOptionProvider
import java.io.File
import java.util.*

private val options = HashMap<String, String?>()

val PATH_TYPE_FILE = 1
val PATH_TYPE_FOLDER = 2

fun main(args: Array<String>) {
	val cleanArgs = args.filter { a -> !a.isNullOrBlank() }

	if (cleanArgs.size == 2 && cleanArgs[0] == "--walker") {
		printHeader("EasyMaps Walker $VERSION")
		runWalker(cleanArgs[1])
	} else if (cleanArgs.size == 1) {
		printHeader("EasyMaps Engine $VERSION")
		runEngine(cleanArgs[0])
	} else {
		printHeader("EasyMaps Engine $VERSION")
		runEngine()
	}
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
			"london" -> return LondonLogReader()
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
			"london" -> return LondonOptionProvider()
			"sample" -> return SampleOptionProvider()
			else -> if (!quiet) printError("that's not a valid option")
		}
	}
}

fun selectWalkerOptionProvider(): WalkerOptionProvider {

	while (true) {
		var input = options["walkerOptionProvider"]
		options.put("walkerOptionProvider", null)

		val quiet = !input.isNullOrEmpty()
		if (input.isNullOrEmpty()) {
			println("\nSelect walker option provider [sample]")
			print(INPUT_PROMPT)
			input = readLine()!!.trim()
		}

		when (input) {
			"sample" -> return SampleWalkerOptionProvider()
			else -> if (!quiet) printError("that's not a valid option")
		}
	}
}

class PrematureFailureException : Exception("Premature failure")