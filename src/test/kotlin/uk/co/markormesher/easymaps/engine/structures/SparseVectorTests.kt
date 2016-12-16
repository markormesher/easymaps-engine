package uk.co.markormesher.easymaps.engine.structures

import org.junit.Test
import java.util.*
import kotlin.test.*

class SparseVectorTests {

	@Test
	fun shouldNotAllowSizesZeroOrBelow() {
		assertFailsWith(IllegalArgumentException::class, { SparseVector(-1, 0) })
		assertFailsWith(IllegalArgumentException::class, { SparseVector(0, 0) })
	}

	@Test
	fun sizeShouldBeAccurate() {
		val sv = SparseVector(10, 0)
		assertEquals(10, sv.size)
	}

	@Test
	fun emptyVectorShouldStoreNoValues() {
		val sv = SparseVector(10, 0)
		assertEquals(0, sv.realSize)
	}

	@Test
	fun nonSetValuesShouldBeDefault() {
		val sv = SparseVector(10, 0)
		for (i in 0..9) assertEquals(0, sv[i])
	}

	@Test
	fun defaultValuesShouldNotBeStored() {
		val sv = SparseVector(10, 0)
		sv[1] = 0
		assertEquals(0, sv.realSize)
		assertEquals(0, sv[1])
	}

	@Test
	fun nonDefaultValuesShouldBeStored() {
		val sv = SparseVector(10, 0)
		sv[0] = 1
		sv[2] = 2
		sv[4] = 3
		sv[6] = 0
		assertEquals(3, sv.realSize)
		assertEquals(1, sv[0])
		assertEquals(2, sv[2])
		assertEquals(3, sv[4])
		assertEquals(0, sv[6])
	}

	@Test
	fun nonDefaultValuesShouldReturnEmptyForEmptyVector() {
		val sv = SparseVector(10, 0)
		assertEquals(0, sv.nonDefaultValues.size)
	}

	@Test
	fun nonDefaultValuesShouldReturnCorrectValues() {
		val sv = SparseVector(10, 0)
		sv[0] = 1
		sv[2] = 2
		sv[4] = 3
		sv[6] = 0
		assertEquals(3, sv.nonDefaultValues.size)
		assertTrue(sv.nonDefaultValues.contains(1))
		assertTrue(sv.nonDefaultValues.contains(2))
		assertTrue(sv.nonDefaultValues.contains(3))
		assertFalse(sv.nonDefaultValues.contains(0))
	}

	@Test
	fun forEachShouldNotSkipDefaultValues() {
		val sv = SparseVector(10, 0)
		sv[0] = 1
		sv[2] = 2
		sv[4] = 3
		sv[6] = 0

		val expectedIds = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
		val expectedValues = intArrayOf(1, 0, 2, 0, 3, 0, 0, 0, 0, 0)
		val actualIds = ArrayList<Int>()
		val actualValues = ArrayList<Int>()

		sv.forEach { i, d ->
			actualIds.add(i)
			actualValues.add(d)
		}

		assertEquals(expectedIds.size, actualIds.size)
		assertEquals(expectedValues.size, actualValues.size)
		for (i in 0..expectedIds.size - 1) assertEquals(expectedIds[i], actualIds[i])
		for (i in 0..expectedValues.size - 1) assertEquals(expectedValues[i], actualValues[i])
	}

	@Test
	fun forEachNonDefaultShouldSkipDefaultValues() {
		val sv = SparseVector(10, 0)
		sv[0] = 1
		sv[2] = 2
		sv[4] = 3
		sv[6] = 0

		val expectedIds = intArrayOf(0, 2, 4)
		val expectedValues = intArrayOf(1, 2, 3)
		val actualIds = ArrayList<Int>()
		val actualValues = ArrayList<Int>()

		sv.forEachNonDefault { i, d ->
			actualIds.add(i)
			actualValues.add(d)
		}

		assertEquals(expectedIds.size, actualIds.size)
		assertEquals(expectedValues.size, actualValues.size)
		for (i in 0..expectedIds.size - 1) assertEquals(expectedIds[i], actualIds[i])
		for (i in 0..expectedValues.size - 1) assertEquals(expectedValues[i], actualValues[i])
	}

	@Test
	fun clearShouldRemoveAllValues() {
		val sv = SparseVector(10, 0)
		sv[0] = 1
		sv[2] = 2
		sv[4] = 3
		sv[6] = 0
		sv.clear()
		assertEquals(0, sv.realSize)
	}

	@Test
	fun cloneShouldCreateNonLinkedDuplicate() {
		// populate original with default and non-default values
		val svOriginal = SparseVector(10, 0)
		val values = intArrayOf(0, 1, 2, 3)
		var valueCounter = 0
		for (p in 0..9) {
			svOriginal[p] = values[valueCounter++ % 4]
		}

		val svClone = svOriginal.clone()

		for (p in 0..9) {
			assertEquals(svOriginal[p], svClone[p])
		}

		svOriginal[5] = 10
		svClone[5] = 20
		assertNotEquals(svOriginal[5], svClone[5])
	}

}
