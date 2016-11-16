package uk.co.markormesher.easymaps.engine.helpers

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class RandomTests {

	@Test
	fun randomIntShouldFailForEndSmallerThanStart() {
		assertFailsWith(IllegalArgumentException::class, "end < start", { randomInt(1, 0) })
	}

	@Test
	fun randomIntShouldWorkWithEqualArguments() {
		assertEquals(0, randomInt(0, 0))
	}

	@Test
	fun randomIntShouldWorkWithStartSmallerThanEnd() {
		assertEquals(0, randomInt(0, 1))
	}

	@Test
	fun randomLongShouldFailForEndSmallerThanStart() {
		assertFailsWith(IllegalArgumentException::class, "end < start", { randomLong(1, 0) })
	}

	@Test
	fun randomLongShouldWorkWithEqualArguments() {
		assertEquals(0, randomLong(0, 0))
	}

	@Test
	fun randomLongShouldWorkWithStartSmallerThanEnd() {
		assertEquals(0, randomLong(0, 1))
	}

}