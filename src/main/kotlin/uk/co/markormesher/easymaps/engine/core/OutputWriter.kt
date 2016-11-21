package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.EngineConfig
import uk.co.markormesher.easymaps.engine.structures.Network
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import java.io.PrintWriter

fun writeOutput(knownNetwork: Network, isomorphisms: List<Map<Int, Int>>, cfg: EngineConfig) {

	printSubHeader("Writing Final Labelling(s)")

	isomorphisms.forEachIndexed { i, iso ->
		printInfo("Writing labelling #${i + 1}")

		val sb = StringBuilder()
		iso.forEach { mapping ->
			val observedNodeId = mapping.key
			val knownNodeId = mapping.value

			val traits = cfg.traitTranslator.getTraitsForCluster(observedNodeId)
			traits.forEach { trait ->
				with(sb) {
					append("\"")
					append(trait)
					append("\" = \"")
					append(knownNetwork.nodeLabel(knownNodeId))
					append("\"\n")
				}
			}
		}

		val file = "${cfg.outputFolderPath}/labelling-$i.txt"
		with(PrintWriter(file, "UTF-8")) {
			print(sb.toString())
			close()
		}
	}
}
