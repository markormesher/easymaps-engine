package uk.co.markormesher.easymaps.engine.helpers

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class ExtensionTests {

	@Test
	fun forAllPairsShouldIterateAllPairs() {
		val data = listOf("1", "2", "3", "4", "5")
		val output = HashSet<String>()
		data.forEachPair { a, b -> output.add("$a$b") }
		assertEquals(25, output.size)
		for (a in 1..5) {
			for (b in 1..5) {
				assertTrue(output.contains("$a$b"))
			}
		}
	}

	@Test
	fun getMajorityElementShouldReturnMajorityWhenPresent() {
		assertEquals(1, listOf(1).majorityElement(-1))
		assertEquals(1, listOf(0, 1, 1).majorityElement(-1))
		assertEquals(1, listOf(0, 0, 1, 1, 1).majorityElement(-1))
	}

	@Test
	fun getMajorityElementShouldFailForEmptyCollection() {
		assertEquals(-1, listOf<Int>().majorityElement(-1))
	}

	@Test
	fun getMajorityElementShouldFailWhenNoMajorityExists() {
		assertEquals(-1, listOf(0, 1).majorityElement(-1))
		assertEquals(-1, listOf(0, 1, 2, 3, 4).majorityElement(-1))
		assertEquals(-1, listOf(0, 1, 2, 3, 3, 3).majorityElement(-1))
	}

	@Test
	fun getRandomElementOfListShouldFailForEmptyList() {
		val list = ArrayList<Int>()
		assertFailsWith(ArrayIndexOutOfBoundsException::class, { list.randomElement() })
	}

	@Test
	fun getRandomElementOfArrayShouldFailForEmptyArray() {
		val array = Array(0, { 0 })
		assertFailsWith(ArrayIndexOutOfBoundsException::class, { array.randomElement() })
	}

}