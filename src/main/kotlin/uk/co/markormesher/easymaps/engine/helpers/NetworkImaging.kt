package uk.co.markormesher.easymaps.engine.helpers

import uk.co.markormesher.easymaps.engine.SharedConfig
import uk.co.markormesher.easymaps.engine.structures.Network
import java.io.File
import java.io.PrintWriter
import java.util.*

internal val GRAPH_PREAMBLE by lazy {
	"digraph Map {\n" +
			"graph[overlap = false, splines = true];\n" +
			"edge[arrowsize = 0.4];\n" +
			"node[fontsize = 8, margin = \"0.07,0.02\"];\n"
}

fun generateNetworkImage(network: Network, label: String, cfg: SharedConfig) {
	// check graphviz
	val graphViz = File(cfg.graphvizExec)
	if (!graphViz.exists() || graphViz.isDirectory) {
		throw Exception("The GraphViz executable '${cfg.graphvizExec}' could not be found")
	}

	val dotFile = "${cfg.outputFolderPath}/$label.dot"
	val pngFile = "${cfg.outputFolderPath}/$label.png"
	with(PrintWriter(dotFile, "UTF-8")) {
		print(generateDotFormatString(network))
		close()
	}
	Runtime.getRuntime().exec("${cfg.graphvizExec} -Tpng -o $pngFile $dotFile").waitFor()
	printSubInfo("Written to $dotFile")
	printSubInfo("Diagram in $pngFile")
}

internal fun generateDotFormatString(network: Network): String {
	val sb = StringBuilder()
	sb.append(GRAPH_PREAMBLE)

	// edges
	val edgesPrinted = HashSet<String>()
	network.forEachEdge { from, to ->
		val edge = makeEdge(network, from, to)
		if (!edgesPrinted.contains(edge)) {
			sb.append("$edge\n")
			edgesPrinted.add(edge)
		}
	}

	// close
	sb.append("}")

	return sb.toString()
}

internal fun makeEdge(network: Network, from: Int, to: Int): String {
	if (network.hasEdge(from, to) && network.hasEdge(to, from)) {
		val fromLabel = network.nodeLabel(Math.min(from, to))
		val toLabel = network.nodeLabel(Math.max(from, to))
		return "\"$fromLabel\" -> \"$toLabel\" [dir = both];"
	} else if (network.hasEdge(from, to)) {
		val fromLabel = network.nodeLabel(from)
		val toLabel = network.nodeLabel(to)
		return "\"$fromLabel\" -> \"$toLabel\";"
	} else {
		throw IllegalArgumentException("The edge $from -> $to does not exist in the given network")
	}
}