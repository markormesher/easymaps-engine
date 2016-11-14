
import java.io.File
import java.util.concurrent.ThreadLocalRandom

val traitsPerNode = 30
val minEntriesPerNode = 2
val maxEntriesPerNode = 10
val minTraitsPerEntry = 5
val maxTraitsPerEntry = 20
val minDelayBetweenScans = 20000L // 20s
val maxDelayBetweenScans = 40000L // 40s
val minDelayBetweenNodes = 20000L // 20s
val maxDelayBetweenNodes = 80000L // 80s

fun makeTrait(node: Char, offset: Int): String = "trait_${node}_${((node - 'A') * traitsPerNode) + offset}"

fun randBetween(minIncl: Int, maxExcl: Int): Int = ThreadLocalRandom.current().nextInt(minIncl, maxExcl)
fun randBetween(minIncl: Long, maxExcl: Long): Long = ThreadLocalRandom.current().nextLong(minIncl, maxExcl)

fun main(args: Array<String>) {

	if (args.size != 1) throw IllegalArgumentException("File path expected")
	if (!args[0].endsWith("/")) throw IllegalArgumentException("File path doesn't end with '/'")

	val journeys = arrayOf("JG", "JGC", "JGCI", "JGCH", "CH", "HCB", "ABD", "DBCI", "I", "ABCH", "F",
			"HCBCBD", "EBA", "EBFL", "PLFBD", "QLFM", "NMFLP", "PLQ", "KEBF", "PLFBEK", "BCGJ", "KEBFLP",
			"KEBCGJ", "M", "N", "QLFBABD")

	var fileCounter = 0
	for (i in 1..5) journeys.forEach { j ->
		val sb = StringBuilder()
		var time = System.currentTimeMillis()
		j.forEach { n ->
			var entries = randBetween(minEntriesPerNode, maxEntriesPerNode)
			while (entries-- > 0) {
				var traits = randBetween(minTraitsPerEntry, maxTraitsPerEntry)
				sb.append("[dummy-device,").append(time)
				while (traits-- > 0) {
					sb.append(",").append(makeTrait(n, randBetween(0, traitsPerNode)))
				}
				sb.append("]\n")
				time += randBetween(minDelayBetweenScans, maxDelayBetweenScans)
			}
			time += randBetween(minDelayBetweenNodes, maxDelayBetweenNodes)
		}
		with(File("${args[0]}sample-${fileCounter++}-dummy-device.txt")) {
			createNewFile()
			writeText(sb.toString())
		}
	}
}
