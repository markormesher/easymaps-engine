package uk.co.markormesher.easymaps.engine.algorithms

import org.junit.Test
import uk.co.markormesher.easymaps.engine.structures.Network
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class BruteForceIsomorphismFinderTests {

	private fun Map<Int, Int>.valuesSortedByKeys() = this.entries.sortedBy { e -> e.key }.map { e -> e.value }.toTypedArray()

	@Test
	fun shouldFindIsomorphismForTwoSingleNodes() {
		val candidate = Network(1)

		val master = Network(1)

		val isomorphisms = BruteForceIsomorphismFinder(candidate, master).findIsomorphisms()
		assertEquals(1, isomorphisms.size)
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(0)) })
	}

	@Test
	fun shouldFindIsomorphismForTwoDoublyLinkedPairs() {
		val candidate = Network(2)
		candidate.addEdge(0, 1)
		candidate.addEdge(1, 0)

		val master = Network(2)
		master.addEdge(0, 1)
		master.addEdge(1, 0)

		val isomorphisms = BruteForceIsomorphismFinder(candidate, master).findIsomorphisms()
		assertEquals(2, isomorphisms.size)
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(0, 1)) })
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(1, 0)) })
	}

	@Test
	fun shouldFindIsomorphismForTwoSinglyLinkedPairs() {
		val candidate = Network(2)
		candidate.addEdge(0, 1)

		val master = Network(2)
		master.addEdge(1, 0)

		val isomorphisms = BruteForceIsomorphismFinder(candidate, master).findIsomorphisms()
		assertEquals(1, isomorphisms.size)
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(1, 0)) })
	}

	@Test
	fun shouldFindIsomorphismForSingleNodeAndSinglyLinkedPair() {
		val candidate = Network(1)

		val master = Network(2)
		master.addEdge(1, 0)

		val isomorphisms = BruteForceIsomorphismFinder(candidate, master).findIsomorphisms()
		assertEquals(2, isomorphisms.size)
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(0)) })
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(1)) })
	}

	@Test
	fun shouldFindIsomorphismForTwoDoublyLinkedPairComponentsAndDoublyLinked4Chain() {
		val candidate = Network(4)
		candidate.addEdge(0, 1)
		candidate.addEdge(1, 0)
		candidate.addEdge(2, 3)
		candidate.addEdge(3, 2)

		val master = Network(4)
		master.addEdge(0, 1)
		master.addEdge(1, 0)
		master.addEdge(1, 2)
		master.addEdge(2, 1)
		master.addEdge(2, 3)
		master.addEdge(3, 2)

		val isomorphisms = BruteForceIsomorphismFinder(candidate, master).findIsomorphisms()
		assertEquals(8, isomorphisms.size)
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(0, 1, 2, 3)) })
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(0, 1, 3, 2)) })
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(1, 0, 2, 3)) })
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(1, 0, 3, 2)) })
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(2, 3, 0, 1)) })
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(2, 3, 1, 0)) })
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(3, 2, 0, 1)) })
		assertTrue(isomorphisms.any { iso -> Arrays.equals(iso.valuesSortedByKeys(), arrayOf(3, 2, 1, 0)) })
	}

}
