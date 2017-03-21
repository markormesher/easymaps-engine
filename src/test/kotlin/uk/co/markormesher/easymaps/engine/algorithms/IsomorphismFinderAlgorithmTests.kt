package uk.co.markormesher.easymaps.engine.algorithms

import org.junit.Test
import uk.co.markormesher.easymaps.engine._mocks.MockNetwork
import uk.co.markormesher.easymaps.engine._mocks.valuesSortedByKeys
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

abstract class IsomorphismFinderAlgorithmTests {

	abstract fun makeFinder(candidate: MockNetwork, master: MockNetwork): IsomorphismFinder

	/*
	SINGLE_NODES_1
	 */

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(1, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(3, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(3, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(3, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(3, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(3, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(5, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(5, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_1_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(5, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4)) })
	}

	/*
	SINGLE_NODES_2
	 */

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(12, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(12, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(12, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(12, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(12, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(20, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(12, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(20, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(12, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_2_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(20, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3)) })
	}

	/*
	SINGLE_NODES_3
	 */

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(60, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(60, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLE_NODES_3_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(60, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2)) })
	}

	/*
	SINGLY_LINKED_PATH_2
	 */

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(1, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(3, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(3, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(8, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(12, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(20, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(3, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_2_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(8, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0)) })
	}

	/*
	SINGLY_LINKED_PATH_3
	 */

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(1, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(3, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(8, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(60, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_3_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(12, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3)) })
	}

	/*
	SINGLY_LINKED_PATH_4
	 */

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(1, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(8, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(120, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_PATH_4_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	/*
	DOUBLY_LINKED_PATH_2
	 */

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(8, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(12, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(20, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_2_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_2, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(8, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0)) })
	}

	/*
	DOUBLY_LINKED_PATH_3
	 */

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(8, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(60, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_3_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(12, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3)) })
	}

	/*
	DOUBLY_LINKED_PATH_3
	 */

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_3, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(2, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(8, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(120, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_PATH_4_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_PATH_4, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	/*
	SINGLY_LINKED_RING_3
	 */

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(3, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(60, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_3_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	/*
	SINGLY_LINKED_RING_4
	 */

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(4, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(8, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(120, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_RING_4_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	/*
	DOUBLY_LINKED_RING_3
	 */

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(60, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_3_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_3, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	/*
	DOUBLY_LINKED_RING_4
	 */

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(8, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(120, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_RING_4_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_RING_4, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	/*
	COMPLETE_4
	 */

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(120, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_4_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.COMPLETE_4, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	/*
	COMPLETE_5
	 */

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.COMPLETE_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(120, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_COMPLETE_5_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.COMPLETE_5, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	/*
	SINGLY_LINKED_STAR_4
	 */

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(120, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_4_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2)) })
	}

	/*
	SINGLY_LINKED_STAR_5
	 */

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.COMPLETE_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(120, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SINGLY_LINKED_STAR_5_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.SINGLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2, 1)) })
	}

	/*
	DOUBLY_LINKED_STAR_4
	 */

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.COMPLETE_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(120, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(6, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_4_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_4, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2)) })
	}

	/*
	DOUBLY_LINKED_STAR_5
	 */

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_SINGLE_NODES_1() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_SINGLE_NODES_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_SINGLE_NODES_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_SINGLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_SINGLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_SINGLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_DOUBLY_LINKED_PATH_2() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_PATH_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_DOUBLY_LINKED_PATH_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_PATH_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_DOUBLY_LINKED_PATH_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_PATH_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_SINGLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_SINGLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_DOUBLY_LINKED_RING_3() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_RING_3).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_DOUBLY_LINKED_RING_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_RING_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_COMPLETE_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.COMPLETE_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_COMPLETE_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.COMPLETE_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(120, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 0, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 2, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 3, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(1, 4, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 0, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 0, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 3, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 1, 4, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 3, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(2, 4, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 0, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 0, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 2, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 1, 4, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 0, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 0, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 1, 4, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 2, 4, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(3, 4, 2, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 0, 3, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 0, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 2, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 1, 3, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 0, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 0, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 1, 3, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 2, 3, 1, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 0, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 0, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 1, 2, 0)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 0, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(4, 3, 2, 1, 0)) })
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_SINGLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_SINGLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.SINGLY_LINKED_STAR_5).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_DOUBLY_LINKED_STAR_4() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_STAR_4).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_DOUBLY_LINKED_STAR_5_x_DOUBLY_LINKED_STAR_5() {
		val results = makeFinder(MockNetwork.DOUBLY_LINKED_STAR_5, MockNetwork.DOUBLY_LINKED_STAR_5).findIsomorphisms()
		val mappedResults = results.map { it.valuesSortedByKeys() }
		assertEquals(24, results.size)
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 2, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 3, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 1, 4, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 3, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 1, 4, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 3, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 2, 4, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 2, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 1, 4, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 1, 4)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 2, 4, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 3, 4, 2, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 2, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 1, 3, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 1, 3)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 2, 3, 1)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 1, 2)) })
		assertTrue(mappedResults.any { Arrays.equals(it, arrayOf(0, 4, 3, 2, 1)) })
	}

}
