package uk.co.markormesher.easymaps.engine.core

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import uk.co.markormesher.easymaps.engine.PrematureFailureException
import uk.co.markormesher.easymaps.engine._mocks.getMockEngineConfig
import uk.co.markormesher.easymaps.engine.structures.TraitTranslator
import java.io.File
import java.io.PrintWriter
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class DataParserAndCleanerTests {

	@Rule @JvmField
	val tempInputFolder = TemporaryFolder()

	@Rule @JvmField
	val tempOutputFolder = TemporaryFolder()

	@Test
	fun shouldFailForEmptyFolder() {
		assertFailsWith(PrematureFailureException::class, {
			parseAndCleanData(getMockEngineConfig(
					logFolderPath = tempInputFolder.root.absolutePath,
					outputFolderPath = tempOutputFolder.root.absolutePath
			))
		})
	}

	@Test
	fun shouldSucceedForNonEmptyFolder() {
		with(PrintWriter(File(tempInputFolder.root, "log1.txt"), "UTF-8")) {
			print("[mark,0,0_0,1_1,2_2]")
			close()
		}

		with(PrintWriter(File(tempInputFolder.root, "log2.txt"), "UTF-8")) {
			print("[mark,0,3_3,4_4]")
			close()
		}

		val traitTranslator = TraitTranslator()

		parseAndCleanData(getMockEngineConfig(
				traitTranslator = traitTranslator,
				logFolderPath = tempInputFolder.root.absolutePath,
				outputFolderPath = tempOutputFolder.root.absolutePath
		))

		assertEquals(5, traitTranslator.size)
	}

}
