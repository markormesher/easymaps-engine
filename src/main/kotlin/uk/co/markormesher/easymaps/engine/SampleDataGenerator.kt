package uk.co.markormesher.easymaps.engine

import java.io.File
import java.util.concurrent.ThreadLocalRandom

val traitsPerNode = 30
val minEntriesPerNode = 1
val maxEntriesPerNode = 8
val minTraitsPerEntry = 2
val maxTraitsPerEntry = 30
val minDelayBetweenScans = 20000
val maxDelayBetweenScans = 40000
val minDelayBetweenNodes = 20000
val maxDelayBetweenNodes = 80000

fun makeTrait(node: Char, offset: Int): String = "trait_${((node - 'A') * traitsPerNode) + offset}"

fun randBetween(minIncl: Int, maxExcl: Int): Int {
	return ThreadLocalRandom.current().nextInt(minIncl, maxExcl)
}

fun main(args: Array<String>) {
	val journeys = arrayOf("JG", "JGC", "JGCI", "JGCH", "CH", "HCB", "ABD", "DBCI", "I", "ABCH", "F",
			"HCBCBD", "EBA", "EBFL", "PLFBD", "QLFM", "NMFLP", "PQL", "KEBF", "PLFBEK", "BCGJ", "KEBFLP",
			"KEBCGI", "M", "N", "QLFBABD")

	var fileCounter = 0
	var iterationCount = 3
	while (iterationCount-- > 0) journeys.forEach { j ->
		val sb = StringBuilder()
		var time = System.currentTimeMillis()
		j.forEach { n ->
			var entries = randBetween(minEntriesPerNode, maxEntriesPerNode)
			while (entries-- > 0) {
				var traits = randBetween(minTraitsPerEntry, maxTraitsPerEntry)
				sb.append("[dummy-device,").append(time)
				while (traits-- > 0) {
					sb.append(",").append(makeTrait(n, randBetween(0, traitsPerNode)))
					if (traits != 0) time += randBetween(minDelayBetweenScans, maxDelayBetweenScans)
				}
				sb.append("]\n")
				time += randBetween(minDelayBetweenNodes, maxDelayBetweenNodes)
			}
		}
		val file = File("test-data/test-${fileCounter++}-dummy-device.txt")
		file.createNewFile()
		file.writeText(sb.toString())
	}
}