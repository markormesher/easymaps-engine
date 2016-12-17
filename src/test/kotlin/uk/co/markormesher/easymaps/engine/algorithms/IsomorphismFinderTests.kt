package uk.co.markormesher.easymaps.engine.algorithms

import org.junit.Test
import uk.co.markormesher.easymaps.engine._mocks.MockNetwork
import kotlin.test.assertEquals

abstract class IsomorphismFinderTests {

	abstract fun makeFinder(candidate: MockNetwork, master: MockNetwork): IsomorphismFinder

	@Test
	fun shouldFindIsomorphisms_SingleNode1_SingleNode_1() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(1, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SingleNode1_SingleNode_2() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(2, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SingleNode1_SingleNode_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_1, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(3, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SingleNode2_SingleNode_1() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SingleNode2_SingleNode_2() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(2, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SingleNode2_SingleNode_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_2, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(6, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SingleNode3_SingleNode_1() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLE_NODES_1).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SingleNode3_SingleNode_2() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLE_NODES_2).findIsomorphisms()
		assertEquals(0, results.size)
	}

	@Test
	fun shouldFindIsomorphisms_SingleNode3_SingleNode_3() {
		val results = makeFinder(MockNetwork.SINGLE_NODES_3, MockNetwork.SINGLE_NODES_3).findIsomorphisms()
		assertEquals(6, results.size)
	}

}
