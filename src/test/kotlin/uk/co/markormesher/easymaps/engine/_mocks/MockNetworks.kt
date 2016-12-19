package uk.co.markormesher.easymaps.engine._mocks

import uk.co.markormesher.easymaps.engine.structures.Network

enum class MockNetwork {
	SINGLE_NODES_1,
	SINGLE_NODES_2,
	SINGLE_NODES_3,
	SINGLY_LINKED_PATH_2,
	SINGLY_LINKED_PATH_3,
	SINGLY_LINKED_PATH_4,
	DOUBLY_LINKED_PATH_2,
	DOUBLY_LINKED_PATH_3,
	DOUBLY_LINKED_PATH_4,
	SINGLY_LINKED_RING_3,
	SINGLY_LINKED_RING_4,
	DOUBLY_LINKED_RING_3,
	DOUBLY_LINKED_RING_4,
	COMPLETE_4,
	COMPLETE_5,
	SINGLY_LINKED_STAR_3,
	SINGLY_LINKED_STAR_4,
	DOUBLY_LINKED_STAR_3,
	DOUBLY_LINKED_STAR_4
}

fun Map<Int, Int>.valuesSortedByKeys() = entries.sortedBy { e -> e.key }.map { e -> e.value }.toTypedArray()

fun getMockNetwork(network: MockNetwork): Network {
	when (network) {
		MockNetwork.SINGLE_NODES_1 -> return Network(1)
		MockNetwork.SINGLE_NODES_2 -> return Network(2)
		MockNetwork.SINGLE_NODES_3 -> return Network(3)
		MockNetwork.SINGLY_LINKED_PATH_2 -> with(Network(2)) {
			addEdge(0, 1)
			return this
		}
		MockNetwork.SINGLY_LINKED_PATH_3 -> with(Network(3)) {
			addEdge(0, 1)
			addEdge(1, 2)
			return this
		}
		MockNetwork.SINGLY_LINKED_PATH_4 -> with(Network(4)) {
			addEdge(0, 1)
			addEdge(1, 2)
			addEdge(2, 3)
			return this
		}
		MockNetwork.DOUBLY_LINKED_PATH_2 -> with(Network(2)) {
			addEdge(0, 1)
			addEdge(1, 0)
			return this
		}
		MockNetwork.DOUBLY_LINKED_PATH_3 -> with(Network(3)) {
			addEdge(0, 1)
			addEdge(1, 0)
			addEdge(1, 2)
			addEdge(2, 1)
			return this
		}
		MockNetwork.DOUBLY_LINKED_PATH_4 -> with(Network(4)) {
			addEdge(0, 1)
			addEdge(1, 0)
			addEdge(1, 2)
			addEdge(2, 1)
			addEdge(2, 3)
			addEdge(3, 2)
			return this
		}
		MockNetwork.SINGLY_LINKED_RING_3 -> with(Network(3)) {
			addEdge(0, 1)
			addEdge(1, 2)
			addEdge(2, 0)
			return this
		}
		MockNetwork.SINGLY_LINKED_RING_4 -> with(Network(4)) {
			addEdge(0, 1)
			addEdge(1, 2)
			addEdge(2, 3)
			addEdge(3, 0)
			return this
		}
		MockNetwork.DOUBLY_LINKED_RING_3 -> with(Network(3)) {
			addEdge(0, 1)
			addEdge(0, 2)
			addEdge(1, 0)
			addEdge(1, 2)
			addEdge(2, 0)
			addEdge(2, 1)
			return this
		}
		MockNetwork.DOUBLY_LINKED_RING_4 -> with(Network(4)) {
			addEdge(0, 1)
			addEdge(0, 3)
			addEdge(1, 0)
			addEdge(1, 2)
			addEdge(2, 1)
			addEdge(2, 3)
			addEdge(3, 0)
			addEdge(3, 2)
			return this
		}
		MockNetwork.COMPLETE_4 -> with(Network(4)) {
			addEdge(0, 0)
			addEdge(0, 1)
			addEdge(0, 2)
			addEdge(0, 3)
			addEdge(1, 0)
			addEdge(1, 1)
			addEdge(1, 2)
			addEdge(1, 3)
			addEdge(2, 0)
			addEdge(2, 1)
			addEdge(2, 2)
			addEdge(2, 3)
			addEdge(3, 0)
			addEdge(3, 1)
			addEdge(3, 2)
			addEdge(3, 3)
			return this
		}
		MockNetwork.COMPLETE_5 -> with(Network(5)) {
			addEdge(0, 0)
			addEdge(0, 1)
			addEdge(0, 2)
			addEdge(0, 3)
			addEdge(0, 4)
			addEdge(1, 0)
			addEdge(1, 1)
			addEdge(1, 2)
			addEdge(1, 3)
			addEdge(1, 4)
			addEdge(2, 0)
			addEdge(2, 1)
			addEdge(2, 2)
			addEdge(2, 3)
			addEdge(2, 4)
			addEdge(3, 0)
			addEdge(3, 1)
			addEdge(3, 2)
			addEdge(3, 3)
			addEdge(3, 4)
			addEdge(4, 0)
			addEdge(4, 1)
			addEdge(4, 2)
			addEdge(4, 3)
			addEdge(4, 4)
			return this
		}
		MockNetwork.SINGLY_LINKED_STAR_3 -> with(Network(3)) {
			addEdge(0, 1)
			addEdge(0, 2)
			return this
		}
		MockNetwork.SINGLY_LINKED_STAR_4 -> with(Network(4)) {
			addEdge(0, 1)
			addEdge(0, 2)
			addEdge(0, 3)
			return this
		}
		MockNetwork.DOUBLY_LINKED_STAR_3 -> with(Network(3)) {
			addEdge(0, 1)
			addEdge(0, 2)
			addEdge(1, 0)
			addEdge(2, 0)
			return this
		}
		MockNetwork.DOUBLY_LINKED_STAR_4 -> with(Network(4)) {
			addEdge(0, 1)
			addEdge(0, 2)
			addEdge(0, 3)
			addEdge(1, 0)
			addEdge(2, 0)
			addEdge(3, 0)
			return this
		}
		else -> throw IllegalArgumentException("Unrecognised network: $network")
	}
}
