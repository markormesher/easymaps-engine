package uk.co.markormesher.easymaps.engine.interfaces

import org.junit.Test
import uk.co.markormesher.easymaps.engine.domain_specific.sample.SampleLogGeneratorOptionProvider
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

/**
 * These tests are just to silence warnings from JaCoCo.
 */
class LogGeneratorOptionProviderTests {

	@Test
	fun defaultPropertiesShouldExist() {
		val mock = SampleLogGeneratorOptionProvider()
		assertNotNull(mock.pathLengths)
		assertNotNull(mock.userIds)
		assertNotNull(mock.minVisitsPerNode)
		assertNotNull(mock.minTimePerNode)
		assertNotNull(mock.maxTimePerNode)
		assertNotNull(mock.minScanGap)
		assertNotNull(mock.maxScanGap)
		assertNotNull(mock.minTraitsPerScan)
		assertNotNull(mock.maxTraitsPerScan)
		assertEquals(1, mock.getNextNode(0, 0, arrayListOf(1)))
		assertEquals("[a,1,b,c]", mock.generateLogLine("a", 1L, arrayListOf("b", "c")))
		assertTrue(mock.generateTrait("test").startsWith("test_"))
		assertEquals("a-1-2.txt", mock.generateLogFileName("a", 1L, 2))
	}

}
