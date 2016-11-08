package uk.co.markormesher.easymaps.engine.helpers

import uk.co.markormesher.easymaps.engine.Config
import uk.co.markormesher.easymaps.engine.data.Network
import java.io.PrintWriter
import java.util.*

// TODO: break up into file generator and add tests
fun generateNetworkImage(network: Network, label: String, cfg: Config) {

	printInfo("Writing observed network to file...")

	// preamble
	val sb = StringBuilder()
	sb.append("digraph Map {\n")
	sb.append("edge[arrowsize = 0.4];\n")
	sb.append("node[fontsize = 10, margin = \"0.07,0.02\"];\n")

	// edges
	val edgesPrinted = HashSet<String>()
	network.forEachEdge { from, to ->
		var edge = "\"${Math.min(from, to)}nodenode\" -> \"${Math.max(from, to)}nodenode\""
		if (network.hasEdge(to, from)) edge += " [dir = \"both\"]"
		edge += ";"

		if (!edgesPrinted.contains(edge)) {
			sb.append("$edge\n")
			edgesPrinted.add(edge)
		}
	}

	// close
	sb.append("}")

	// write observed network to files
	val dotFile = "${cfg.outputPath}/$label.dot"
	val pngFile = "${cfg.outputPath}/$label.png"
	with(PrintWriter(dotFile, "UTF-8")) {
		print(sb.toString())
		close()
	}
	Runtime.getRuntime().exec("${cfg.dotExec} -Tpng -o $pngFile $dotFile").waitFor()
	printSubInfo("Written to $dotFile")
	printSubInfo("Diagram in $pngFile")
}