package uk.co.markormesher.easymaps.engine.structures

import org.junit.Test
import java.util.*
import kotlin.test.*

class DenseMatrixTests {

	@Test
	fun shouldNotAllowSizesZeroOrBelow() {
		assertFailsWith(IllegalArgumentException::class, { DenseMatrix(0, 1, 0, { w, h -> Array(w * h, { 0 }) }) })
		assertFailsWith(IllegalArgumentException::class, { DenseMatrix(1, 0, 0, { w, h -> Array(w * h, { 0 }) }) })
		assertFailsWith(IllegalArgumentException::class, { DenseMatrix(-1, 1, 0, { w, h -> Array(w * h, { 0 }) }) })
		assertFailsWith(IllegalArgumentException::class, { DenseMatrix(1, -1, 0, { w, h -> Array(w * h, { 0 }) }) })
	}

	@Test
	fun sizeShouldBeAccurate() {
		val dbm = DenseMatrix(2, 4, 0, { w, h -> Array(w * h, { 0 }) })
		assertEquals(2, dbm.width)
		assertEquals(4, dbm.height)
	}

	@Test
	fun nonSetValuesShouldBeFalse() {
		val dbm = DenseMatrix(10, 10, false, { w, h -> Array(w * h, { false }) })
		for (r in 0..9) {
			for (c in 0..9) {
				assertFalse(dbm[r, c])
			}
		}
	}

	@Test
	fun setValuesShouldBeStored() {
		val dbm = DenseMatrix(10, 10, false, { w, h -> Array(w * h, { false }) })
		dbm[0, 1] = true
		dbm[2, 3] = false
		dbm[4, 5] = true
		dbm[6, 7] = false
		dbm[8, 9] = true
		assertTrue(dbm[0, 1])
		assertFalse(dbm[2, 3])
		assertTrue(dbm[4, 5])
		assertFalse(dbm[6, 7])
		assertTrue(dbm[8, 9])
	}

	@Test
	fun forEachShouldCoverAllValues() {
		val dbm = DenseMatrix(4, 4, false, { w, h -> Array(w * h, { false }) })
		dbm[0, 1] = true
		dbm[2, 3] = true

		val expectedIds = intArrayOf(
				0, 0, 0, 1, 0, 2, 0, 3,
				1, 0, 1, 1, 1, 2, 1, 3,
				2, 0, 2, 1, 2, 2, 2, 3,
				3, 0, 3, 1, 3, 2, 3, 3
		)
		val expectedValues = booleanArrayOf(
				false, true, false, false,
				false, false, false, false,
				false, false, false, true,
				false, false, false, false
		)
		val actualIds = ArrayList<Int>()
		val actualValues = ArrayList<Boolean>()

		dbm.forEach { r, c, v ->
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
	fun forEachOnRowCoverAllValues() {
		val dbm = DenseMatrix(5, 5, 0, { w, h -> Array(w * h, { 0 }) })
		dbm[2, 1] = 1
		dbm[2, 3] = 2

		val expectedIds = intArrayOf(0, 1, 2, 3, 4)
		val expectedValues = intArrayOf(0, 1, 0, 2, 0)
		val actualIds = ArrayList<Int>()
		val actualValues = ArrayList<Int>()

		dbm.forEachOnRow(2) { c, v ->
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
		val dbm = DenseMatrix(10, 10, 0, { w, h -> Array(w * h, { 0 }) })
		dbm[0, 1] = 1
		dbm[2, 3] = 2
		dbm[4, 5] = 3
		dbm.clearRow(2)
		(0..9).forEach { column -> assertEquals(0, dbm[2, column]) }
		assertEquals(1, dbm[0, 1])
		assertEquals(3, dbm[4, 5])
	}

	@Test
	fun cloneShouldCreateDuplicate() {
		val dbmOriginal = DenseMatrix(10, 10, 0, { w, h -> Array(w * h, { 0 }) })
		for (r in 0..9) {
			for (c in 0..9) {
				dbmOriginal[r, c] = if (r == c) 1 else 0
			}
		}
		val dbmClone = dbmOriginal.clone()

		for (r in 0..9) {
			for (c in 0..9) {
				assertEquals(dbmOriginal[r, c], dbmClone[r, c])
			}
		}
	}

	@Test
	fun cloneShouldCreateNonLinkedObject() {
		val dbmOriginal = DenseMatrix(10, 10, 0, { w, h -> Array(w * h, { 0 }) })
		val dbmClone = dbmOriginal.clone()

		dbmOriginal[5, 5] = 1
		dbmClone[5, 5] = 0
		assertNotEquals(dbmOriginal[5, 5], dbmClone[5, 5])
	}

}
