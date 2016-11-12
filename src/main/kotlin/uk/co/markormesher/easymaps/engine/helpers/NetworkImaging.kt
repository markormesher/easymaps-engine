package uk.co.markormesher.easymaps.engine.helpers

import uk.co.markormesher.easymaps.engine.Config
import uk.co.markormesher.easymaps.engine.data.Network
import java.io.PrintWriter
import java.util.*

// TODO: add tests
fun generateNetworkImage(network: Network, label: String, cfg: Config) {
	val dotFile = "${cfg.outputFolderPath}/$label.dot"
	val pngFile = "${cfg.outputFolderPath}/$label.png"
	with(PrintWriter(dotFile, "UTF-8")) {
		print(generateDotFormatString(network))
		close()
	}
	Runtime.getRuntime().exec("${cfg.dotExec} -Tpng -o $pngFile $dotFile").waitFor()
	printSubInfo("Written to $dotFile")
	printSubInfo("Diagram in $pngFile")
}

private fun generateDotFormatString(network: Network): String {
	val sb = StringBuilder()
	sb.append("digraph Map {\n")
	sb.append("edge[arrowsize = 0.4];\n")
	sb.append("node[fontsize = 10, margin = \"0.07,0.02\"];\n")

	// edges
	val edgesPrinted = HashSet<String>()
	network.forEachEdge { from, to ->
		var edge = "\"${Math.min(from, to)}\" -> \"${Math.max(from, to)}\""
		if (network.hasEdge(to, from)) edge += " [dir = \"both\"]"
		edge += ";"

		if (!edgesPrinted.contains(edge)) {
			sb.append("$edge\n")
			edgesPrinted.add(edge)
		}
	}

	// close
	sb.append("}")

	return sb.toString()
}