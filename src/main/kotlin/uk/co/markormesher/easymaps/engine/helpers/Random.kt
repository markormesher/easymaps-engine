package uk.co.markormesher.easymaps.engine.helpers

import java.util.concurrent.ThreadLocalRandom

private val random by lazy { ThreadLocalRandom.current() }

fun randomInt(startIncl: Int, endExcl: Int): Int = random.nextInt(startIncl, endExcl)

fun randomLong(startIncl: Long, endExcl: Long): Long = random.nextLong(startIncl, endExcl)