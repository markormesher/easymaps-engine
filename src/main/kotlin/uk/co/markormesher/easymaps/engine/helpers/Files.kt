package uk.co.markormesher.easymaps.engine.helpers

import java.io.File

fun clearDirectory(path: String) {
	val dir = File(path)
	dir.listFiles().forEach { f ->
		if (f.isDirectory) {
			clearDirectory(f.absolutePath)
			if (f.listFiles().isEmpty()) f.delete()
		} else if (f.name != ".gitignore") {
			f.delete()
		}
	}
}