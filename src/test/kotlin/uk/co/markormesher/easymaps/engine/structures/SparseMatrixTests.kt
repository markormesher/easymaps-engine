package uk.co.markormesher.easymaps.engine.structures

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotEquals

class SparseMatrixTests {

	@Test
	fun shouldNotAllowSizesZeroOrBelow() {
		assertFailsWith(IllegalArgumentException::class, { SparseMatrix(-1, 1) })
		assertFailsWith(IllegalArgumentException::class, { SparseMatrix(0, 1) })
		assertFailsWith(IllegalArgumentException::class, { SparseMatrix(1, -1) })
		assertFailsWith(IllegalArgumentException::class, { SparseMatrix(1, 0) })
	}

	@Test
	fun sizeShouldBeAccurate() {
		val sm = SparseMatrix(2, 4)
		assertEquals(2, sm.width)
		assertEquals(4, sm.height)
	}

	@Test
	fun possibleValueCountShouldBeAccurate() {
		val sm = SparseMatrix(2, 4)
		assertEquals(8, sm.maxSize)
	}

	@Test
	fun emptyMatrixShouldStoreNoValues() {
		val sm = SparseMatrix(2, 4)
		assertEquals(0, sm.nonZeroSize)
	}

	@Test
	fun nonSetValuesShouldBeZero() {
		val sm = SparseMatrix(10, 10)
		for (r in 0..9) {
			for (c in 0..9) {
				assertEquals(0.0, sm[r, c])
			}
		}
	}

	@Test
	fun zeroValuesShouldNotBeStored() {
		val sm = SparseMatrix(10, 10)
		sm[1, 2] = 0.0
		assertEquals(0, sm.nonZeroSize)
		assertEquals(0.0, sm[1, 2])
	}

	@Test
	fun nonZeroValuesShouldBeStored() {
		val sm = SparseMatrix(10, 10)
		sm[0, 1] = 1.23
		sm[2, 3] = 4.56
		sm[4, 5] = 7.89
		sm[6, 7] = 0.0

		assertEquals(3, sm.nonZeroSize)
		assertEquals(1.23, sm[0, 1])
		assertEquals(4.56, sm[2, 3])
		assertEquals(7.89, sm[4, 5])
		assertEquals(0.0, sm[6, 7])
	}

	@Test
	fun densityShouldBeAccurateWhenEmpty() {
		val sm = SparseMatrix(10, 10)
		assertEquals(0.0, sm.density)
	}

	@Test
	fun densityShouldBeAccurateWhenSemiFull() {
		val sm = SparseMatrix(10, 10)
		sm[0, 1] = 1.23
		sm[2, 3] = 4.56
		sm[4, 5] = 7.89
		sm[6, 7] = 0.0
		assertEquals(0.03, sm.density) // 3 out of 100
	}

	@Test
	fun densityShouldBeAccurateWhenFull() {
		val sm = SparseMatrix(10, 10)
		for (r in 0..9) {
			for (c in 0..9) {
				sm[r, c] = 1.0
			}
		}
		assertEquals(1.0, sm.density)
	}

	@Test
	fun clearShouldRemoveAllValues() {
		val sm = SparseMatrix(10, 10)
		sm[0, 1] = 1.23
		sm[2, 3] = 4.56
		sm[4, 5] = 7.89
		sm[6, 7] = 0.0
		sm.clear()
		assertEquals(0, sm.nonZeroSize)
	}

	@Test
	fun clearRowShouldRemoveCorrectValues() {
		val sm = SparseMatrix(10, 10)
		sm[0, 1] = 1.23
		sm[2, 3] = 4.56
		sm[4, 5] = 7.89
		sm[6, 7] = 0.0
		sm.clearRow(2)
		assertEquals(2, sm.nonZeroSize)
		(0..9).forEach { assertEquals(0.0, sm[2, it]) }
	}

	@Test
	fun clearColumnShouldRemoveCorrectValues() {
		val sm = SparseMatrix(10, 10)
		sm[0, 1] = 1.23
		sm[2, 3] = 4.56
		sm[4, 5] = 7.89
		sm[6, 7] = 0.0
		sm.clearColumn(3)
		assertEquals(2, sm.nonZeroSize)
		(0..9).forEach { assertEquals(0.0, sm[it, 3]) }
	}

	@Test
	fun cloneShouldCreateNonLinkedDuplicate() {
		// populate original with zero and non-zero values
		val smOriginal = SparseMatrix(10, 10)
		val values = doubleArrayOf(0.0, 1.2, 3.4, 5.6)
		var valueCounter = 0
		for (r in 0..9) {
			for (c in 0..9) {
				smOriginal[r, c] = values[valueCounter++ % 4]
			}
		}

		val smClone = smOriginal.clone()

		for (r in 0..9) {
			for (c in 0..9) {
				assertEquals(smOriginal[r, c], smClone[r, c])
			}
		}

		smOriginal[5, 5] = 10.0
		smClone[5, 5] = 20.0
		assertNotEquals(smOriginal[5, 5], smClone[5, 5])
	}

	@Test
	fun forEachNonZeroShouldSkipZeroValues() {
		val sm = SparseMatrix(10, 10)
		sm[0, 1] = 1.23
		sm[2, 3] = 4.56
		sm[4, 5] = 7.89
		sm[6, 7] = 0.0

		val expectedIds = intArrayOf(0, 1, 2, 3, 4, 5)
		val expectedValues = doubleArrayOf(1.23, 4.56, 7.89)
		val actualIds = ArrayList<Int>()
		val actualValues = ArrayList<Double>()

		sm.forEachNonZero { r, c, v ->
			actualIds.add(r)
			actualIds.add(c)
			actualValues.add(v)
		}

		assertEquals(expectedIds.size, actualIds.size)
		assertEquals(expectedValues.size, actualValues.size)
		for (i in 0..5) assertEquals(expectedIds[i], actualIds[i])
		for (i in 0..2) assertEquals(expectedValues[i], actualValues[i])
	}

	@Test
	fun getRowShouldContainCorrectValues() {
		val sm = SparseMatrix(10, 10)
		sm[0, 1] = 1.23
		sm[2, 3] = 4.56
		sm[2, 5] = 7.89

		val row = sm.getRow(2)
		assertEquals(2, row.nonZeroSize)
		assertEquals(4.56, row[3])
		assertEquals(7.89, row[5])
	}

	@Test
	fun getColumnShouldContainCorrectValues() {
		val sm = SparseMatrix(10, 10)
		sm[0, 1] = 1.23
		sm[2, 1] = 4.56
		sm[2, 5] = 7.89

		val col = sm.getColumn(1)
		assertEquals(2, col.nonZeroSize)
		assertEquals(1.23, col[0])
		assertEquals(4.56, col[2])
	}

}