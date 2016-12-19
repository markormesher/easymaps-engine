package uk.co.markormesher.easymaps.engine.dataset_generator

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import uk.co.markormesher.easymaps.engine._mocks.getMockDatasetGeneratorConfig
import java.io.File
import kotlin.test.assertTrue

class DatasetGeneratorClasses {

	@Rule @JvmField
	val tempFolder = TemporaryFolder()

	@Test
	fun generateDatasetsShouldCreateFileStructure() {
		val cfg = getMockDatasetGeneratorConfig(
				sizes = arrayListOf(10),
				outputFolderPath = tempFolder.root.absolutePath
		)
		val networks = generateNetworks(cfg)
		generateDatasets(networks, cfg)

		assertTrue(File(tempFolder.root, "summary.html").exists())
		assertTrue(File(tempFolder.root, "sample-010").exists())
		assertTrue(File(tempFolder.root, "sample-010/options.txt").exists())
		assertTrue(File(tempFolder.root, "sample-010/log-generator-options.txt").exists())
		assertTrue(File(tempFolder.root, "sample-010/input").exists())
		assertTrue(File(tempFolder.root, "sample-010/input/logs").exists())
		assertTrue(File(tempFolder.root, "sample-010/input/known-network.txt").exists())
		assertTrue(File(tempFolder.root, "sample-010/output").exists())
		assertTrue(File(tempFolder.root, "sample-010/output/.gitignore").exists())
	}

}
