package uk.co.markormesher.easymaps.engine.dataset_generator

import org.junit.Test
import uk.co.markormesher.easymaps.engine._mocks.getMockDatasetGeneratorConfig
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class NetworkGeneratorTests {

	@Test
	fun generateNetworksShouldCreateCorrectSizes() {
		val networks = generateNetworks(getMockDatasetGeneratorConfig(arrayListOf(10, 20, 30)))
		assertEquals(3, networks.size)
		assertEquals(10, networks[0].nodeCount)
		assertEquals(20, networks[1].nodeCount)
		assertEquals(30, networks[2].nodeCount)
	}

	@Test
	fun largeNetworkShouldContainSomeBrokenPaths() {
		val largeNetwork = generateNetworks(getMockDatasetGeneratorConfig(arrayListOf(500)))[0]
		assertTrue((0..largeNetwork.nodeCount - 2).any { !(largeNetwork.hasEdge(it, it + 1) || largeNetwork.hasEdge(it + 1, it)) })
	}

	@Test
	fun largeNetworkShouldContainSomeSingleDirectionEdges() {
		val largeNetwork = generateNetworks(getMockDatasetGeneratorConfig(arrayListOf(500)))[0]
		assertTrue {
			var foundSingleDirectionEdge = false
			largeNetwork.forEachEdge { from, to ->
				if (!largeNetwork.hasEdge(to, from)) foundSingleDirectionEdge = true
			}
			return@assertTrue foundSingleDirectionEdge
		}
	}

	@Test
	fun networkConnectivityShouldBeWithinBounds() {
		val cfg = getMockDatasetGeneratorConfig(arrayListOf(10, 50, 100, 200))
		val opts = cfg.datasetGeneratorOptionProvider
		val networks = generateNetworks(cfg)
		for (n in networks) {
			val connectivity = n.edgeCount / n.nodeCount.toDouble()
			assertTrue(connectivity >= opts.minConnectivity, "Connectivity was $connectivity")
			assertTrue(connectivity <= opts.maxConnectivity, "Connectivity was $connectivity")
		}
	}

}
