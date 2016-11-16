package uk.co.markormesher.easymaps.engine.structures

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NetworkTests {

	@Test
	fun shouldNotAllowSizesZeroOrBelow() {
		assertFailsWith(IllegalArgumentException::class, { Network(-1) })
		assertFailsWith(IllegalArgumentException::class, { Network(0) })
	}

	@Test
	fun shouldAssignDefaultNetworkLabels() {
		val network = Network(3)
		assertEquals("0", network.nodeLabels[0])
		assertEquals("1", network.nodeLabels[1])
		assertEquals("2", network.nodeLabels[2])
	}

	@Test
	fun shouldPreserveNetworkLabels() {
		val network = Network(3)
		network.nodeLabels[0] = "test node"
		assertEquals("test node", network.nodeLabels[0])
	}

	@Test
	fun validateIndexShouldRejectOutOfBoundsIndexes() {
		val network = Network(10)
		assertFailsWith(IndexOutOfBoundsException::class, "index = -1, size = 10", { network.validateIndex(-1) })
		assertFailsWith(IndexOutOfBoundsException::class, "index = 10, size = 10", { network.validateIndex(10) })
	}

	@Test
	fun addEdgeShouldAddEdge() {
		val network = Network(10)
		network.addEdge(0, 1)
		assertTrue(network.hasEdge(0, 1))
	}

	@Test
	fun addEdgeShouldNotFailWithDuplicateEdges() {
		val network = Network(10)
		network.addEdge(0, 1)
		network.addEdge(0, 1)
		assertTrue(network.hasEdge(0, 1))
	}

	@Test
	fun hasEdgeShouldBeAccurate() {
		val network = Network(10)
		network.addEdge(0, 1)
		assertTrue(network.hasEdge(0, 1))
		assertFalse(network.hasEdge(1, 0))
	}

	@Test
	fun forEachEdgeShouldDoNothingForEmptyNetwork() {
		val network = Network(10)
		network.forEachEdge { from, to -> throw Exception("Ran for non-edge") }
	}

	@Test
	fun forEachEdgeShouldIterateAllEdges() {
		val network = Network(10)
		network.addEdge(0, 1)
		network.addEdge(2, 3)
		network.addEdge(2, 3)
		network.addEdge(4, 5)

		val edges = HashSet<String>()
		network.forEachEdge { from, to -> edges.add("$from - $to") }

		assertEquals(3, edges.size)
		assertTrue(edges.contains("0 - 1"))
		assertTrue(edges.contains("2 - 3"))
		assertTrue(edges.contains("4 - 5"))
	}

	@Test
	fun getSuccessorsShouldReturnEmptyForSinkNode() {
		val network = Network(10)
		network.addEdge(0, 1)
		assertEquals(0, network.getSuccessors(1).size)
	}

	@Test
	fun getSuccessorsShouldReturnAllSuccessors() {
		val network = Network(10)
		network.addEdge(0, 1)
		network.addEdge(0, 2)
		network.addEdge(0, 3)
		assertEquals(3, network.getSuccessors(0).size)
		assertTrue(network.getSuccessors(0).contains(1))
		assertTrue(network.getSuccessors(0).contains(2))
		assertTrue(network.getSuccessors(0).contains(3))
	}

	@Test
	fun getSuccessorsShouldIncludeSelfLoops() {
		val network = Network(10)
		network.addEdge(0, 0)
		assertEquals(1, network.getSuccessors(0).size)
		assertTrue(network.getSuccessors(0).contains(0))
	}

	@Test
	fun nodeCountShouldBeAccurate() {
		val network = Network(10)
		assertEquals(10, network.nodeCount)
	}

	@Test
	fun edgeCountShouldBeAccurate() {
		val network = Network(10)
		assertEquals(0, network.edgeCount)
		network.addEdge(0, 1)
		assertEquals(1, network.edgeCount)
		network.addEdge(2, 3)
		assertEquals(2, network.edgeCount)
		network.addEdge(2, 3)
		assertEquals(2, network.edgeCount)
	}


}