package uk.co.markormesher.easymaps.engine._mocks

import uk.co.markormesher.easymaps.engine.structures.Network

enum class MockNetworks {
	SINGLE_NODE,
	TWO_SINGLE_NODES,
	THREE_SINGLE_NODES,
	SINGLY_LINKED_PATH_2,
	SINGLY_LINKED_PATH_3,
	SINGLY_LINKED_PATH_4,
	DOUBLY_LINKED_PATH_2,
	DOUBLY_LINKED_PATH_3,
	DOUBLY_LINKED_PATH_4,
	SINGLY_LINKED_RING_3,
	SINGLY_LINKED_RING_4,
	DOUBLY_LINKED_RING_3,
	DOUBLY_LINKED_RING_4
}

fun getMockNetwork(network: MockNetworks): Network {
	when (network) {
		MockNetworks.SINGLE_NODE -> return Network(1)
		MockNetworks.TWO_SINGLE_NODES -> return Network(2)
		MockNetworks.THREE_SINGLE_NODES -> return Network(3)
		MockNetworks.SINGLY_LINKED_PATH_2 -> with(Network(2)) {
			addEdge(0, 1)
			return this
		}
		MockNetworks.SINGLY_LINKED_PATH_3 -> with(Network(3)) {
			addEdge(0, 1)
			addEdge(1, 2)
			return this
		}
		MockNetworks.SINGLY_LINKED_PATH_4 -> with(Network(4)) {
			addEdge(0, 1)
			addEdge(1, 2)
			addEdge(2, 3)
			return this
		}
		MockNetworks.DOUBLY_LINKED_PATH_2 -> with(Network(2)) {
			addEdge(0, 1)
			addEdge(0, 1)
			return this
		}
		MockNetworks.DOUBLY_LINKED_PATH_3 -> with(Network(3)) {
			addEdge(0, 1)
			addEdge(1, 0)
			addEdge(1, 2)
			addEdge(2, 1)
			return this
		}
		MockNetworks.DOUBLY_LINKED_PATH_4 -> with(Network(4)) {
			addEdge(0, 1)
			addEdge(1, 0)
			addEdge(1, 2)
			addEdge(2, 1)
			addEdge(2, 3)
			addEdge(3, 2)
			return this
		}
		MockNetworks.SINGLY_LINKED_RING_3 -> with(Network(3)) {
			addEdge(0, 1)
			addEdge(1, 2)
			addEdge(2, 0)
			return this
		}
		MockNetworks.SINGLY_LINKED_RING_4 -> with(Network(4)) {
			addEdge(0, 1)
			addEdge(1, 2)
			addEdge(2, 3)
			addEdge(3, 0)
			return this
		}
		MockNetworks.DOUBLY_LINKED_RING_3 -> with(Network(3)) {
			addEdge(0, 1)
			addEdge(1, 0)
			addEdge(1, 2)
			addEdge(2, 1)
			addEdge(2, 0)
			addEdge(0, 2)
			return this
		}
		MockNetworks.DOUBLY_LINKED_RING_4 -> with(Network(4)) {
			addEdge(0, 1)
			addEdge(1, 0)
			addEdge(1, 2)
			addEdge(2, 1)
			addEdge(2, 3)
			addEdge(3, 2)
			addEdge(3, 0)
			addEdge(0, 3)
			return this
		}
		else -> throw IllegalArgumentException("Unrecognised network: $network")
	}
}
