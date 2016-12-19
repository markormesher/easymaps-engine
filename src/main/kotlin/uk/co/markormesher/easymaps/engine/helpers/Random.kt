package uk.co.markormesher.easymaps.engine.helpers

import java.util.concurrent.ThreadLocalRandom

private val random by lazy { ThreadLocalRandom.current() }

fun randomDouble(startIncl: Double = 0.0, endExcl: Double = 1.0): Double {
	if (startIncl == endExcl) return startIncl
	if (endExcl < startIncl) throw IllegalArgumentException("end < start")
	return random.nextDouble(startIncl, endExcl)
}

fun randomInt(startIncl: Int, endExcl: Int): Int {
	if (startIncl == endExcl) return startIncl
	if (endExcl < startIncl) throw IllegalArgumentException("end < start")
	return random.nextInt(startIncl, endExcl)
}

fun randomLong(startIncl: Long, endExcl: Long): Long {
	if (startIncl == endExcl) return startIncl
	if (endExcl < startIncl) throw IllegalArgumentException("end < start")
	return random.nextLong(startIncl, endExcl)
}
