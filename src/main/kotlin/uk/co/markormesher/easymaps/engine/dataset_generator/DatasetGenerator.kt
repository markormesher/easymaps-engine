package uk.co.markormesher.easymaps.engine.dataset_generator

import uk.co.markormesher.easymaps.engine.DatasetGeneratorConfig
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.runLogGenerator
import uk.co.markormesher.easymaps.engine.structures.Network
import java.io.File
import java.io.PrintWriter
import java.util.*

fun generateDatasets(networks: List<Network>, cfg: DatasetGeneratorConfig, args: Array<String>) {
	val opts = cfg.datasetGeneratorOptionProvider

	for (network in networks) {
		val size = network.nodeCount
		printSubHeader("Generating Dataset (n = $size)")

		createFileStructure(size, cfg)
		writeNetwork(size, network, cfg)
		runLogGenerator(arrayOf("${cfg.outputFolderPath}/${opts.generateGraphFolderName(size)}/log-generator-options.txt", "--force") + args)
	}

	generateSummary(networks, cfg)
}

internal fun createFileStructure(size: Int, cfg: DatasetGeneratorConfig) {
	val opts = cfg.datasetGeneratorOptionProvider
	val folderName = cfg.datasetGeneratorOptionProvider.generateGraphFolderName(size)

	// create folders
	File("${cfg.outputFolderPath}/$folderName").mkdir()
	File("${cfg.outputFolderPath}/$folderName/input").mkdir()
	File("${cfg.outputFolderPath}/$folderName/input/logs").mkdir()
	File("${cfg.outputFolderPath}/$folderName/output").mkdir()

	// create gitignore
	with(PrintWriter("${cfg.outputFolderPath}/$folderName/output/.gitignore", "UTF-8")) {
		print("*\n!.gitignore\n")
		close()
	}

	// options file
	val options = "logReader = ${opts.logReaderName}\n" +
			"optionProvider = ${opts.optionProviderName}\n" +
			"logFolderPath = ./datasets/$folderName/input/logs\n" +
			"knownNetworkFilePath = ./datasets/$folderName/input/known-network.txt\n" +
			"outputFolderPath = ./datasets/$folderName/output\n" +
			"graphvizExec = /usr/bin/neato\n"
	with(PrintWriter("${cfg.outputFolderPath}/$folderName/options.txt", "UTF-8")) {
		print(options)
		close()
	}

	// options file
	val logGeneratorOptions = "optionProvider = ${opts.optionProviderName}\n" +
			"logGeneratorOptionProvider = ${opts.logGeneratorOptionProviderName}\n" +
			"logFolderPath = ./datasets/$folderName/input/logs\n" +
			"knownNetworkFilePath = ./datasets/$folderName/input/known-network.txt\n" +
			"outputFolderPath = ./datasets/$folderName/output\n" +
			"graphvizExec = /usr/bin/neato\n" +
			"drawGraphs = y\n"
	with(PrintWriter("${cfg.outputFolderPath}/$folderName/log-generator-options.txt", "UTF-8")) {
		print(logGeneratorOptions)
		close()
	}
}

internal fun writeNetwork(size: Int, network: Network, cfg: DatasetGeneratorConfig) {
	val sb = StringBuilder()

	val edgesPrinted = HashSet<String>()
	network.forEachEdge { from, to ->
		val edge = makeEdge(size, network, from, to, cfg)
		if (!edgesPrinted.contains(edge)) {
			sb.append("$edge\n")
			edgesPrinted.add(edge)
		}
	}

	val folderName = cfg.datasetGeneratorOptionProvider.generateGraphFolderName(size)
	with(PrintWriter("${cfg.outputFolderPath}/$folderName/input/known-network.txt", "UTF-8")) {
		print(sb.toString())
		close()
	}
}

internal fun makeEdge(size: Int, network: Network, from: Int, to: Int, cfg: DatasetGeneratorConfig): String {
	if (network.hasEdge(from, to) && network.hasEdge(to, from)) {
		val fromLabel = cfg.datasetGeneratorOptionProvider.generateGraphNodeLabel(size, Math.min(from, to))
		val toLabel = cfg.datasetGeneratorOptionProvider.generateGraphNodeLabel(size, Math.max(from, to))
		return "\"$fromLabel\" -- \"$toLabel\""
	} else if (network.hasEdge(from, to)) {
		val fromLabel = cfg.datasetGeneratorOptionProvider.generateGraphNodeLabel(size, from)
		val toLabel = cfg.datasetGeneratorOptionProvider.generateGraphNodeLabel(size, to)
		return "\"$fromLabel\" -> \"$toLabel\""
	} else {
		throw IllegalArgumentException("The edge $from -> $to does not exist in the given network")
	}
}

internal fun generateSummary(networks: List<Network>, cfg: DatasetGeneratorConfig) {
	val sb = StringBuilder()

	// prefix
	sb.append("<html>")
	sb.append("<head>")
	sb.append("<title>EasyMaps Generated Networks</title>")
	sb.append("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" />")
	sb.append("<link rel=\"stylesheet\" href=\"http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\" />")
	sb.append("</head>")
	sb.append("<body>")
	sb.append("<div class=\"container\">")
	sb.append("<h1>EasyMaps Generated Networks</h1>")
	sb.append("<table class=\"table table-striped\">")
	sb.append("<thead>")
	sb.append("<tr>")
	sb.append("<th>Nodes</th>")
	sb.append("<th>Edges</th>")
	sb.append("<th>Connectivity</th>")
	sb.append("<th>Image</th>")
	sb.append("</tr>")
	sb.append("</thead>")
	sb.append("<tbody>")

	// networks
	for (network in networks) {
		val folderName = cfg.datasetGeneratorOptionProvider.generateGraphFolderName(network.nodeCount)
		val image = "./$folderName/output/known-network.png"
		sb.append("<tr>")
		sb.append("<td>${network.nodeCount}</td>")
		sb.append("<td>${network.edgeCount}</td>")
		sb.append("<td>${String.format("%.2f", network.edgeCount / network.nodeCount.toDouble())}</td>")
		sb.append("<td><a href=\"$image\">Link</a></td>")
		sb.append("</tr>")
	}

	// suffix
	sb.append("</tbody>")
	sb.append("</table>")
	sb.append("</div>")
	sb.append("</body>")
	sb.append("</html>")

	with(PrintWriter("${cfg.outputFolderPath}/summary.html", "UTF-8")) {
		print(sb.toString())
		close()
	}
}

