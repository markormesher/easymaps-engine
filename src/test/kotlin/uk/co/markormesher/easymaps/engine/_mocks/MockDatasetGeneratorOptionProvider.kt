package uk.co.markormesher.easymaps.engine._mocks

import uk.co.markormesher.easymaps.engine.interfaces.DatasetGeneratorOptionProvider

class MockDatasetGeneratorOptionProvider: DatasetGeneratorOptionProvider() {

	val characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

	override val logReaderName = "sample"

	override val optionProviderName = "sample"

	override val logGeneratorOptionProviderName = "sample"

	override val sizes = (10..20 step 10).toList()

	override val minConnectivity = 2.0

	override val maxConnectivity = 2.0

	override val singleDirectionChance = 0.05

	override val chainBreakChance = 0.1

	override fun generateGraphFolderName(size: Int) = String.format("sample-%03d", size)

	override fun generateGraphNodeLabel(size: Int, nodeId: Int): String {
		val char1 = characters[nodeId / characters.size]
		val char2 = characters[nodeId % characters.size]
		return "$char1$char2"
	}

}
