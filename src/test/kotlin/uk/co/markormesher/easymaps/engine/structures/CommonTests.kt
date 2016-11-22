package uk.co.markormesher.easymaps.engine.structures

import org.junit.Test
import kotlin.test.assertFailsWith

class CommonTests {

	@Test
	fun validateIndexShouldRejectInvalidIndexes() {
		assertFailsWith(IndexOutOfBoundsException::class, "i = -1, n = 10", { validateIndex(-1, 10, "i") })
		assertFailsWith(IndexOutOfBoundsException::class, "i = 10, n = 10", { validateIndex(10, 10, "i") })
	}

	@Test
	fun validateIndexShouldAcceptValidIndexes() {
		validateIndex(0, 10, "i")
		validateIndex(9, 10, "i")
	}

}