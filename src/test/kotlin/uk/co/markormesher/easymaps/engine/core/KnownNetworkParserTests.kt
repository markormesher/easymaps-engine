package uk.co.markormesher.easymaps.engine.core

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import uk.co.markormesher.easymaps.engine._mocks.getMockEngineConfig
import java.io.File
import java.io.PrintWriter
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class KnownNetworkParserTests {

	@Rule @JvmField
	val tempInputFolder = TemporaryFolder()

	@Rule @JvmField
	val tempOutputFolder = TemporaryFolder()

	@Test
	fun shouldCorrectlyReadNetwork() {
		with(PrintWriter(File(tempInputFolder.root, "known-network.txt"), "UTF-8")) {
			print("\"a\" -- \"b\"\n" +
					"\"b\" -> \"c\"\n" +
					"// comment")
			close()
		}

		val knownNetwork = parseKnownNetwork(getMockEngineConfig(
				knownNetworkFilePath = File(tempInputFolder.root, "known-network.txt").absolutePath,
				outputFolderPath = tempOutputFolder.root.absolutePath,
				drawGraphs = false
		))

		assertEquals(3, knownNetwork.nodeCount)
		assertEquals(3, knownNetwork.edgeCount)
		assertTrue(knownNetwork.hasEdge(0, 1))
		assertTrue(knownNetwork.hasEdge(1, 0))
		assertTrue(knownNetwork.hasEdge(1, 2))
		assertFalse(knownNetwork.hasEdge(2, 1))
	}

	@Test
	fun shouldFailForEmptyFile() {
		with(PrintWriter(File(tempInputFolder.root, "known-network.txt"), "UTF-8")) {
			print("// comment")
			close()
		}

		assertFailsWith(IllegalArgumentException::class, {
			parseKnownNetwork(getMockEngineConfig(
					knownNetworkFilePath = File(tempInputFolder.root, "known-network.txt").absolutePath,
					outputFolderPath = tempOutputFolder.root.absolutePath,
					drawGraphs = false
			))
		})
	}

	@Test
	fun shouldRejectInvalidLines() {
		with(PrintWriter(File(tempInputFolder.root, "known-network.txt"), "UTF-8")) {
			print("\"a\" <> \"b\"\n" +
					"\"c\" -- \"d\"")
			close()
		}

		val knownNetwork = parseKnownNetwork(getMockEngineConfig(
				knownNetworkFilePath = File(tempInputFolder.root, "known-network.txt").absolutePath,
				outputFolderPath = tempOutputFolder.root.absolutePath,
				drawGraphs = false
		))

		assertEquals(2, knownNetwork.nodeCount)
		assertEquals(2, knownNetwork.edgeCount)
		assertTrue(knownNetwork.hasEdge(0, 1))
		assertTrue(knownNetwork.hasEdge(1, 0))
	}

}
