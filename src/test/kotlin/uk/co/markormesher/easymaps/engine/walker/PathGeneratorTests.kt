package uk.co.markormesher.easymaps.engine.walker

import org.junit.Test
import uk.co.markormesher.easymaps.engine._mocks.getMockWalkerConfig
import uk.co.markormesher.easymaps.engine.structures.Network
import kotlin.test.assertTrue

class PathGeneratorTests {

	@Test
	fun generateRandomPathsShouldVisitEveryNodeEnoughTimes() {
		// sanity check
		assertTrue(getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode >= 2)

		val network = Network(5)
		network.addEdge(0, 1)
		network.addEdge(1, 0)
		network.addEdge(1, 2)
		network.addEdge(1, 2)
		network.addEdge(2, 3)
		network.addEdge(3, 2)
		network.addEdge(3, 4)
		network.addEdge(4, 3)

		val paths = generateRandomPaths(network, getMockWalkerConfig())
		val visitsPerNode = Array(5, { 0 })
		paths.forEach { path -> path.forEach { node -> visitsPerNode[node]++ } }
		assertTrue(visitsPerNode[0] >= getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[1] >= getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[2] >= getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[3] >= getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[4] >= getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode)
	}

	@Test
	fun generateRandomPathsShouldNotFailWithNonConnectedGraphs() {
		// sanity check
		assertTrue(getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode >= 2)

		val network = Network(5)

		val paths = generateRandomPaths(network, getMockWalkerConfig())
		val visitsPerNode = Array(5, { 0 })
		paths.forEach { path -> path.forEach { node -> visitsPerNode[node]++ } }
		assertTrue(visitsPerNode[0] >= getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[1] >= getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[2] >= getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[3] >= getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[4] >= getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode)
	}

	@Test
	fun generateRandomPathsShouldCreatePathsOfCorrectLength() {
		// sanity check
		assertTrue(getMockWalkerConfig().walkerOptionProvider.minVisitsPerNode >= 2)

		val network = Network(5)
		network.addEdge(0, 1)
		network.addEdge(1, 0)
		network.addEdge(1, 2)
		network.addEdge(1, 2)
		network.addEdge(2, 3)
		network.addEdge(3, 2)
		network.addEdge(3, 4)
		network.addEdge(4, 3)

		val paths = generateRandomPaths(network, getMockWalkerConfig())
		paths.forEach { path ->
			assertTrue(getMockWalkerConfig().walkerOptionProvider.walkLengths.contains(path.size))
		}
	}

}