package uk.co.markormesher.easymaps.engine.helpers

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import uk.co.markormesher.easymaps.engine.SharedConfig
import uk.co.markormesher.easymaps.engine.structures.Network
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class NetworkImagingTests {

	@Rule @JvmField
	val tempFolder = TemporaryFolder()

	@Test
	fun preambleConstantShouldExist() {
		assertNotNull(GRAPH_PREAMBLE)
	}

	@Test
	fun generateNetworkImageShouldCreateFiles() {
		val config = SharedConfig(
				logFolderPath = "",
				knownNetworkFilePath = "",
				outputFolderPath = tempFolder.root.path,
				graphvizExec = "/usr/bin/dot"
		)

		val network = Network(2)
		network.addEdge(0, 1)

		generateNetworkImage(network, "test-network", config)

		assertTrue(File(tempFolder.root, "test-network.dot").exists())
		assertTrue(File(tempFolder.root, "test-network.png").exists())
	}

	@Test
	fun generateNetworkImageShouldFailWithMissingExecutable() {
		val config = SharedConfig(
				logFolderPath = "",
				knownNetworkFilePath = "",
				outputFolderPath = "",
				graphvizExec = "/tmp/not-real"
		)

		val network = Network(2)
		network.addEdge(0, 1)

		assertFailsWith(Exception::class, "The GraphViz executable '/tmp/not-real' could not be found", {
			generateNetworkImage(network, "test-network", config)
		})
	}

	@Test
	fun generateNetworkImageShouldFailWithFolderAsExecutable() {
		val config = SharedConfig(
				logFolderPath = "",
				knownNetworkFilePath = "",
				outputFolderPath = "",
				graphvizExec = "/tmp"
		)

		val network = Network(2)
		network.addEdge(0, 1)

		assertFailsWith(Exception::class, "The GraphViz executable '/tmp' could not be found", {
			generateNetworkImage(network, "test-network", config)
		})
	}

	@Test
	fun generateDotFormatStringShouldGenerateValidString() {
		val network = Network(2)
		network.addEdge(0, 1)

		val expected = GRAPH_PREAMBLE +
				makeEdge(network, 0, 1) + "\n" +
				"}"

		assertEquals(expected, generateDotFormatString(network))
	}

	@Test
	fun generateDotFormatStringShouldNotDuplicateEdges() {
		val network = Network(2)
		network.addEdge(0, 1)
		network.addEdge(1, 0)

		val expected = GRAPH_PREAMBLE +
				makeEdge(network, 0, 1) + "\n" +
				"}"

		assertEquals(expected, generateDotFormatString(network))
	}

	@Test
	fun makeEdgeShouldCorrectlyOrderNodes() {
		val network = Network(2)
		network.addEdge(0, 1)
		assertEquals("\"0\" -> \"1\";", makeEdge(network, 0, 1))
	}

	@Test
	fun makeEdgeShouldApplyNodeLabels() {
		val network = Network(2)
		network.addEdge(0, 1)
		network.nodeLabels[0] = "a"
		network.nodeLabels[1] = "b"
		assertEquals("\"a\" -> \"b\";", makeEdge(network, 0, 1))
	}

	@Test
	fun makeEdgeShouldCreateBidirectionalEdgeForBidirectionalNodes() {
		val network = Network(2)
		network.addEdge(0, 1)
		network.addEdge(1, 0)
		assertEquals("\"0\" -> \"1\" [dir = both];", makeEdge(network, 0, 1))
		assertEquals("\"0\" -> \"1\" [dir = both];", makeEdge(network, 1, 0))
	}

	@Test
	fun makeEdgeShouldFailForNonExistentEdges() {
		val network = Network(2)
		network.addEdge(0, 1)
		assertFailsWith(IllegalArgumentException::class,
				"The edge 1 -> 0 does not exist in the given network",
				{ makeEdge(network, 1, 0) })
	}

}