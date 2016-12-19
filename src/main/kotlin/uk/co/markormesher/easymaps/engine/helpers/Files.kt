package uk.co.markormesher.easymaps.engine.helpers

import java.io.File

fun clearDirectory(path: String, includeGitIgnore: Boolean = false) {
	val dir = File(path)
	dir.listFiles().forEach { f ->
		if (f.isDirectory) {
			clearDirectory(f.absolutePath, includeGitIgnore)
			if (f.listFiles().isEmpty()) f.delete()
		} else if (includeGitIgnore || f.name != ".gitignore") {
			f.delete()
		}
	}
}
