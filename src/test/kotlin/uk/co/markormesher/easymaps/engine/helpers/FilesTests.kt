package uk.co.markormesher.easymaps.engine.helpers

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import java.io.File
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class FilesTests {

	@Rule @JvmField
	val tempFolder = TemporaryFolder()

	@Test
	fun clearDirectoryShouldDeletePlainFile() {
		val gitIgnoreFile = File(tempFolder.root, "plain-file")
		gitIgnoreFile.createNewFile()

		clearDirectory(tempFolder.root.absolutePath)

		assertFalse(gitIgnoreFile.exists())
	}

	@Test
	fun clearDirectoryShouldDeleteInnerDirectory() {
		val innerDirectory = File(tempFolder.root, "inner-dir")
		innerDirectory.mkdir()

		clearDirectory(tempFolder.root.absolutePath)

		assertFalse(innerDirectory.exists())
	}

	@Test
	fun clearDirectoryShouldDeleteNestedFile() {
		val innerDirectory = File(tempFolder.root, "inner-dir")
		innerDirectory.mkdir()
		val nestedFile = File(innerDirectory, "nested-file")
		nestedFile.createNewFile()

		clearDirectory(tempFolder.root.absolutePath)

		assertFalse(innerDirectory.exists())
		assertFalse(nestedFile.exists())
	}

	@Test
	fun clearDirectoryShouldDoNotDeleteActualDirectory() {
		clearDirectory(tempFolder.root.absolutePath)
		assertTrue(File(tempFolder.root.absolutePath).exists())
	}

	@Test
	fun clearDirectoryShouldNotDeleteGitignoreFile() {
		val gitIgnoreFile = File(tempFolder.root, ".gitignore")
		gitIgnoreFile.createNewFile()

		clearDirectory(tempFolder.root.absolutePath)

		assertTrue(gitIgnoreFile.exists())
	}

	@Test
	fun clearDirectoryShouldNotDeleteNestedGitignoreFile() {
		val innerDirectory = File(tempFolder.root, "inner-dir")
		innerDirectory.mkdir()
		val gitIgnoreFile = File(innerDirectory, ".gitignore")
		gitIgnoreFile.createNewFile()

		clearDirectory(tempFolder.root.absolutePath)

		assertTrue(innerDirectory.exists())
		assertTrue(gitIgnoreFile.exists())
	}

	@Test
	fun clearDirectoryShouldDeleteGitignoreFileWhenFlagSet() {
		val gitIgnoreFile = File(tempFolder.root, ".gitignore")
		gitIgnoreFile.createNewFile()

		clearDirectory(tempFolder.root.absolutePath, true)

		assertFalse(gitIgnoreFile.exists())
	}

	@Test
	fun clearDirectoryShouldDeleteNestedGitignoreFileWhenFlagSet() {
		val innerDirectory = File(tempFolder.root, "inner-dir")
		innerDirectory.mkdir()
		val gitIgnoreFile = File(innerDirectory, ".gitignore")
		gitIgnoreFile.createNewFile()

		clearDirectory(tempFolder.root.absolutePath, true)

		assertFalse(innerDirectory.exists())
		assertFalse(gitIgnoreFile.exists())
	}

}
