package uk.co.markormesher.easymaps.engine.structures

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SparseVectorTests {

	@Test
	fun shouldNotAllowSizesBelowZero() {
		assertFailsWith(IllegalArgumentException::class, { SparseVector(-1) })
		assertFailsWith(IllegalArgumentException::class, { SparseVector(0) })
	}

	@Test
	fun shouldRejectInvalidIndexes() {
		val sv = SparseVector(10)

		// get
		assertFailsWith(IndexOutOfBoundsException::class, "index = -1, size = 10", { sv[-1] })
		assertFailsWith(IndexOutOfBoundsException::class, "index = 10, size = 10", { sv[10] })

		// set
		assertFailsWith(IndexOutOfBoundsException::class, "index = -1, size = 10", { sv[-1] = 1.0 })
		assertFailsWith(IndexOutOfBoundsException::class, "index = 10, size = 10", { sv[10] = 1.0 })
	}

	@Test
	fun sizeShouldBeAccurate() {
		val sv = SparseVector(10)
		assertEquals(10, sv.size)
	}

	@Test
	fun emptyVectorShouldStoreNoValues() {
		val sv = SparseVector(10)
		assertEquals(0, sv.nonZeroValues)
	}

	@Test
	fun nonSetValuesShouldBeZero() {
		val sv = SparseVector(10)
		for (i in 0..9) assertEquals(0.0, sv[i])
	}

	@Test
	fun zeroValuesShouldNotBeStored() {
		val sv = SparseVector(10)
		sv[1] = 0.0
		assertEquals(0, sv.nonZeroValues)
		assertEquals(0.0, sv[1])
	}

	@Test
	fun nonZeroValuesShouldBeStored() {
		val sv = SparseVector(10)
		sv[0] = 1.23
		sv[2] = 4.56
		sv[4] = 7.89
		sv[6] = 0.0

		assertEquals(3, sv.nonZeroValues)
		assertEquals(1.23, sv[0])
		assertEquals(4.56, sv[2])
		assertEquals(7.89, sv[4])
		assertEquals(0.0, sv[6])
	}

	@Test
	fun forEachShouldSkipZeroValues() {
		val sv = SparseVector(10)
		sv[0] = 1.23
		sv[2] = 4.56
		sv[4] = 7.89
		sv[6] = 0.0

		val expectedIds = intArrayOf(0, 2, 4)
		val expectedValues = doubleArrayOf(1.23, 4.56, 7.89)
		val actualIds = ArrayList<Int>()
		val actualValues = ArrayList<Double>()

		sv.forEach { i, d ->
			actualIds.add(i)
			actualValues.add(d)
		}

		assertEquals(expectedIds.size, actualIds.size)
		assertEquals(expectedValues.size, actualValues.size)
		for (i in 0..2) assertEquals(expectedIds[i], actualIds[i])
		for (i in 0..2) assertEquals(expectedValues[i], actualValues[i])
	}

	@Test
	fun toStringShouldBeCorrect() {
		val sv = SparseVector(10)
		sv[0] = 1.23
		sv[2] = 4.56
		sv[4] = 7.89
		sv[6] = 0.0

		val expectedString = "[1.23, 0.0, 4.56, 0.0, 7.89, 0.0, 0.0, 0.0, 0.0, 0.0]"
		val actualString = sv.toString()

		assertEquals(expectedString, actualString)
	}

}