package uk.co.markormesher.easymaps.engine.log_generator

import org.junit.Test
import uk.co.markormesher.easymaps.engine._mocks.getMockLogGeneratorConfig
import uk.co.markormesher.easymaps.engine.structures.Network
import kotlin.test.assertTrue

class PathGeneratorTests {

	@Test
	fun generateRandomPathsShouldVisitEveryNodeEnoughTimes() {
		// sanity check
		assertTrue(getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode >= 2)

		val network = Network(5)
		network.addEdge(0, 1)
		network.addEdge(1, 0)
		network.addEdge(1, 2)
		network.addEdge(1, 2)
		network.addEdge(2, 3)
		network.addEdge(3, 2)
		network.addEdge(3, 4)
		network.addEdge(4, 3)

		val paths = generateRandomPaths(network, getMockLogGeneratorConfig())
		val visitsPerNode = Array(5, { 0 })
		paths.forEach { path -> path.forEach { node -> visitsPerNode[node]++ } }
		assertTrue(visitsPerNode[0] >= getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[1] >= getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[2] >= getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[3] >= getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[4] >= getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode)
	}

	@Test
	fun generateRandomPathsShouldNotFailWithNonConnectedGraphs() {
		// sanity check
		assertTrue(getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode >= 2)

		val network = Network(5)

		val paths = generateRandomPaths(network, getMockLogGeneratorConfig())
		val visitsPerNode = Array(5, { 0 })
		paths.forEach { path -> path.forEach { node -> visitsPerNode[node]++ } }
		assertTrue(visitsPerNode[0] >= getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[1] >= getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[2] >= getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[3] >= getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode)
		assertTrue(visitsPerNode[4] >= getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode)
	}

	@Test
	fun generateRandomPathsShouldCreatePathsOfCorrectLength() {
		// sanity check
		assertTrue(getMockLogGeneratorConfig().logGeneratorOptionProvider.minVisitsPerNode >= 2)

		val network = Network(5)
		network.addEdge(0, 1)
		network.addEdge(1, 0)
		network.addEdge(1, 2)
		network.addEdge(1, 2)
		network.addEdge(2, 3)
		network.addEdge(3, 2)
		network.addEdge(3, 4)
		network.addEdge(4, 3)

		val paths = generateRandomPaths(network, getMockLogGeneratorConfig())
		paths.forEach { path ->
			assertTrue(getMockLogGeneratorConfig().logGeneratorOptionProvider.pathLengths.contains(path.size))
		}
	}

}
