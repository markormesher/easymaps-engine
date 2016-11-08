package uk.co.markormesher.easymaps.engine.structures

import org.junit.Test
import uk.co.markormesher.easymaps.engine.helpers.forAllPairs
import java.util.concurrent.ThreadLocalRandom
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class DisjointSetTests {

	@Test
	fun setCountShouldNotDecreaseBeforeJoinOperations() {
		val ds = DisjointSet(10)
		assertEquals(10, ds.setCount)
	}

	@Test
	fun setCountShouldDecreaseAfterJoinOperations() {
		val ds = DisjointSet(10) // [0, 1, 2], 3, [4, 5], 6, 7, 8, 9
		ds.join(0, 1)
		ds.join(1, 2)
		ds.join(4, 5)
		assertEquals(7, ds.setCount)
	}

	@Test
	fun joinedElementsShouldHaveTheSameRoot() {
		val ds = DisjointSet(10) // [0, 1, 2], 3, [4, 5], 6, 7, 8, 9
		ds.join(0, 1)
		ds.join(1, 2)
		ds.join(4, 5)

		// [0, 1, 2]
		assertTrue(ds.findRoot(0) == ds.findRoot(1))
		assertTrue(ds.findRoot(1) == ds.findRoot(2))

		// [4, 5]
		assertTrue(ds.findRoot(4) == ds.findRoot(5))
	}

	@Test
	fun nonJoinedElementsShouldHaveDifferentRoots() {
		val ds = DisjointSet(10)
		(0..9).toSet().forAllPairs { i, j ->
			assertEquals(i == j, ds.findRoot(i) == ds.findRoot(j))
		}
	}

	@Test
	fun nonJoinedElementsShouldHaveDifferentRootPositions() {
		val ds = DisjointSet(10)
		ds.generateRootPositions()
		(0..9).toSet().forAllPairs { i, j ->
			assertEquals(i == j, ds.findRootPosition(i) == ds.findRootPosition(j))
		}
	}

	@Test
	fun rootPositionsShouldThrowExceptionBeforeGeneration() {
		assertFailsWith(Exception::class, "No known position for root 0", {
			val ds = DisjointSet(10)
			ds.findRootPosition(0)
		})
	}

	@Test
	fun rootPositionsShouldBeContiguous() {
		val ds = DisjointSet(10) // [0, 1, 2], 3, [4, 5], 6, [7, 8, 9]
		ds.join(0, 1)
		ds.join(1, 2)
		ds.join(4, 5)
		ds.join(7, 8)
		ds.join(8, 9)
		ds.generateRootPositions()

		val actualRoots = (0..9).map { i -> ds.findRootPosition(i) }.toIntArray()
		val expectedRoots = intArrayOf(0, 0, 0, 1, 2, 2, 3, 4, 4, 4)

		for (i in 0..9) assertEquals(expectedRoots[i], actualRoots[i])
	}

	@Test
	fun shouldRejectInvalidIndexes() {
		val ds = DisjointSet(10)
		ds.generateRootPositions()
		assertFailsWith(IndexOutOfBoundsException::class, "index = -1, size = 10", { ds.findRoot(-1) })
		assertFailsWith(IndexOutOfBoundsException::class, "index = 10, size = 10", { ds.findRoot(10) })
		assertFailsWith(IndexOutOfBoundsException::class, "index = -1, size = 10", { ds.findRootPosition(-1) })
		assertFailsWith(IndexOutOfBoundsException::class, "index = 10, size = 10", { ds.findRootPosition(10) })
		assertFailsWith(IndexOutOfBoundsException::class, "index = -1, size = 10", { ds.join(-1, 5) })
		assertFailsWith(IndexOutOfBoundsException::class, "index = 10, size = 10", { ds.join(10, 5) })
		assertFailsWith(IndexOutOfBoundsException::class, "index = -1, size = 10", { ds.join(5, -1) })
		assertFailsWith(IndexOutOfBoundsException::class, "index = 10, size = 10", { ds.join(5, 10) })
	}

	@Test
	fun massiveSetsShouldBeFast() {
		val LIMIT = 2000L // 2 seconds
		var timer = -System.currentTimeMillis()
		val rand = ThreadLocalRandom.current()

		// 1,000,000 nodes
		val ds = DisjointSet(1000000)

		// 10,000,000 random connections
		for (i in 0..10000000) {
			val a = rand.nextInt(0, 1000000)
			val b = rand.nextInt(0, 1000000)
			ds.join(a, b)
		}

		// 10,000,000 random root queries
		for (i in 0..10000000) {
			ds.findRoot(rand.nextInt(0, 1000000))
		}

		// generate root positions
		ds.generateRootPositions()

		// 10,000,000 random root position queries
		for (i in 0..10000000) {
			ds.findRootPosition(rand.nextInt(0, 1000000))
		}

		timer += System.currentTimeMillis()

		assertTrue(timer <= LIMIT, "Massive set took ${timer}ms")
	}

}