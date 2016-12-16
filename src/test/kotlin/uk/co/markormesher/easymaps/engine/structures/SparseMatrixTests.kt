package uk.co.markormesher.easymaps.engine.structures

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotEquals

class SparseMatrixTests {

	@Test
	fun shouldNotAllowSizesZeroOrBelow() {
		assertFailsWith(IllegalArgumentException::class, { SparseMatrix(0, 1, 0) })
		assertFailsWith(IllegalArgumentException::class, { SparseMatrix(1, 0, 0) })
		assertFailsWith(IllegalArgumentException::class, { SparseMatrix(-1, 1, 0) })
		assertFailsWith(IllegalArgumentException::class, { SparseMatrix(1, -1, 0) })
	}

	@Test
	fun sizeShouldBeAccurate() {
		val sm = SparseMatrix(2, 4, 0)
		assertEquals(2, sm.width)
		assertEquals(4, sm.height)
	}

	@Test
	fun storedValueCountShouldBeAccurateWhenEmpty() {
		val sm = SparseMatrix(10, 10, 0)
		assertEquals(0, sm.storedValueCount)
	}

	@Test
	fun storedValueCountShouldBeAccurateWhenSemiFull() {
		val sm = SparseMatrix(10, 10, 0)
		sm[0, 1] = 1
		sm[2, 3] = 2
		sm[4, 5] = 3
		assertEquals(3, sm.storedValueCount)
	}

	@Test
	fun storedValueCountShouldBeAccurateWhenFull() {
		val sm = SparseMatrix(10, 10, 0)
		for (r in 0..9) {
			for (c in 0..9) {
				sm[r, c] = 1
			}
		}
		assertEquals(100, sm.storedValueCount)
	}

	@Test
	fun densityShouldBeAccurateWhenEmpty() {
		val sm = SparseMatrix(10, 10, 0)
		assertEquals(0.0, sm.density)
	}

	@Test
	fun densityShouldBeAccurateWhenSemiFull() {
		val sm = SparseMatrix(10, 10, 0)
		sm[0, 1] = 1
		sm[2, 3] = 2
		sm[4, 5] = 3
		assertEquals(0.03, sm.density) // 3 out of 100
	}

	@Test
	fun densityShouldBeAccurateWhenFull() {
		val sm = SparseMatrix(10, 10, 0)
		for (r in 0..9) {
			for (c in 0..9) {
				sm[r, c] = 1
			}
		}
		assertEquals(1.0, sm.density)
	}

	@Test
	fun nonSetValuesShouldBeDefault() {
		val sm = SparseMatrix(10, 10, 0)
		for (r in 0..9) {
			for (c in 0..9) {
				assertEquals(0, sm[r, c])
			}
		}
	}

	@Test
	fun defaultValuesShouldNotBeStored() {
		val sm = SparseMatrix(10, 10, 0)
		sm[1, 2] = 0
		assertEquals(0, sm[1, 2])
	}

	@Test
	fun nonDefaultValuesShouldBeStored() {
		val sm = SparseMatrix(10, 10, 0)
		sm[0, 1] = 1
		sm[2, 3] = 2
		sm[4, 5] = 3
		assertEquals(1, sm[0, 1])
		assertEquals(2, sm[2, 3])
		assertEquals(3, sm[4, 5])
	}

	@Test
	fun getRowShouldContainCorrectValues() {
		val sm = SparseMatrix(10, 10, 0)
		sm[0, 1] = 1
		sm[0, 2] = 2
		sm[2, 3] = 3
		sm[2, 4] = 4
		sm[4, 5] = 5
		sm[4, 6] = 6

		val row = sm.getRow(2)
		assertEquals(2, row.realSize)
		assertEquals(3, row[3])
		assertEquals(4, row[4])
	}

	@Test
	fun forEachShouldNotSkipDefaultValues() {
		val sm = SparseMatrix(4, 4, 0)
		sm[0, 1] = 1
		sm[2, 3] = 2

		val expectedIds = intArrayOf(
				0, 0, 0, 1, 0, 2, 0, 3,
				1, 0, 1, 1, 1, 2, 1, 3,
				2, 0, 2, 1, 2, 2, 2, 3,
				3, 0, 3, 1, 3, 2, 3, 3
		)
		val expectedValues = intArrayOf(
				0, 1, 0, 0,
				0, 0, 0, 0,
				0, 0, 0, 2,
				0, 0, 0, 0
		)
		val actualIds = ArrayList<Int>()
		val actualValues = ArrayList<Int>()

		sm.forEach { r, c, v ->
			actualIds.add(r)
			actualIds.add(c)
			actualValues.add(v)
		}

		assertEquals(expectedIds.size, actualIds.size)
		assertEquals(expectedValues.size, actualValues.size)
		for (i in 0..expectedIds.size - 1) assertEquals(expectedIds[i], actualIds[i])
		for (i in 0..expectedValues.size - 1) assertEquals(expectedValues[i], actualValues[i])
	}

	@Test
	fun forEachNonDefaultShouldSkipDefaultValues() {
		val sm = SparseMatrix(10, 10, 0)
		sm[0, 1] = 1
		sm[2, 3] = 2
		sm[4, 5] = 3
		sm[6, 7] = 0

		val expectedIds = intArrayOf(0, 1, 2, 3, 4, 5)
		val expectedValues = intArrayOf(1, 2, 3)
		val actualIds = ArrayList<Int>()
		val actualValues = ArrayList<Int>()

		sm.forEachNonDefault { r, c, v ->
			actualIds.add(r)
			actualIds.add(c)
			actualValues.add(v)
		}

		assertEquals(expectedIds.size, actualIds.size)
		assertEquals(expectedValues.size, actualValues.size)
		for (i in 0..expectedIds.size - 1) assertEquals(expectedIds[i], actualIds[i])
		for (i in 0..expectedValues.size - 1) assertEquals(expectedValues[i], actualValues[i])
	}

	@Test
	fun forEachOnRowShouldNotSkipDefaultValues() {
		val sm = SparseMatrix(5, 5, 0)
		sm[2, 1] = 1
		sm[2, 3] = 2

		val expectedIds = intArrayOf(0, 1, 2, 3, 4)
		val expectedValues = intArrayOf(0, 1, 0, 2, 0)
		val actualIds = ArrayList<Int>()
		val actualValues = ArrayList<Int>()

		sm.forEachOnRow(2) { c, v ->
			actualIds.add(c)
			actualValues.add(v)
		}

		assertEquals(expectedIds.size, actualIds.size)
		assertEquals(expectedValues.size, actualValues.size)
		for (i in 0..expectedIds.size - 1) assertEquals(expectedIds[i], actualIds[i])
		for (i in 0..expectedValues.size - 1) assertEquals(expectedValues[i], actualValues[i])
	}

	@Test
	fun forEachNonDefaultOnRowShouldSkipDefaultValues() {
		val sm = SparseMatrix(5, 5, 0)
		sm[2, 1] = 1
		sm[2, 3] = 2

		val expectedIds = intArrayOf(1, 3)
		val expectedValues = intArrayOf(1, 2)
		val actualIds = ArrayList<Int>()
		val actualValues = ArrayList<Int>()

		sm.forEachNonDefaultOnRow(2) { c, v ->
			actualIds.add(c)
			actualValues.add(v)
		}

		assertEquals(expectedIds.size, actualIds.size)
		assertEquals(expectedValues.size, actualValues.size)
		for (i in 0..expectedIds.size - 1) assertEquals(expectedIds[i], actualIds[i])
		for (i in 0..expectedValues.size - 1) assertEquals(expectedValues[i], actualValues[i])
	}

	@Test
	fun clearRowShouldRemoveCorrectValues() {
		val sm = SparseMatrix(10, 10, 0)
		sm[0, 1] = 1
		sm[2, 3] = 2
		sm[4, 5] = 3
		sm.clearRow(2)
		(0..9).forEach { column -> assertEquals(0, sm[2, column]) }
	}

	@Test
	fun cloneShouldCreateDuplicate() {
		val smOriginal = SparseMatrix(10, 10, 0)
		for (r in 0..9) {
			for (c in 0..9) {
				smOriginal[r, c] = r * c
			}
		}
		val smClone = smOriginal.clone()

		for (r in 0..9) {
			for (c in 0..9) {
				assertEquals(smOriginal[r, c], smClone[r, c])
			}
		}
	}

	@Test
	fun cloneShouldCreateNonLinkedObject() {
		val smOriginal = SparseMatrix(10, 10, 0)
		val smClone = smOriginal.clone()

		smOriginal[5, 5] = 10
		smClone[5, 5] = 20
		assertNotEquals(smOriginal[5, 5], smClone[5, 5])
	}

}
