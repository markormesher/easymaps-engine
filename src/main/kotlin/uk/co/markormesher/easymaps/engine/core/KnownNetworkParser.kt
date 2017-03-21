package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.PrematureFailureException
import uk.co.markormesher.easymaps.engine.SharedConfig
import uk.co.markormesher.easymaps.engine.helpers.*
import uk.co.markormesher.easymaps.engine.structures.Network
import java.io.File
import java.util.*
import java.util.regex.Pattern

val validNodeRegex = "[A-Za-z0-9'/.\\(\\)\\- ]"
val validLineFormat = Pattern.compile("\"($validNodeRegex+)\" (\\-\\-|\\->) \"($validNodeRegex+)\"")!!

// TODO: tests for network parsing
fun parseKnownNetwork(cfg: SharedConfig): Network {

	printSubHeader("Parsing Known Network")

	val lines = readLines(cfg)
	val nodeLabelToIdMap = buildNodeLabelToIdMap(lines)
	val network = buildNetwork(lines, nodeLabelToIdMap)

	if (network.nodeCount == 0) {
		printError("Cannot continue with 0 nodes")
		throw PrematureFailureException()
	}

	if (network.edgeCount == 0) {
		printError("Cannot continue with 0 edges")
		throw PrematureFailureException()
	}

	printInfo("Writing known network to file")
	generateNetworkImage(network, "known-network", cfg)

	return network
}

private fun readLines(cfg: SharedConfig): ArrayList<String> {

	printInfo("Reading file")

	val lines = ArrayList<String>()
	val file = File(cfg.knownNetworkFilePath)
	file.forEachLine { tmpLine ->
		if (tmpLine.isBlank()) return@forEachLine
		if (tmpLine.startsWith("//")) return@forEachLine

		val line = tmpLine.trim()
		if (validLineFormat.matcher(line).matches()) {
			lines.add(line)
		} else {
			printSubWarning("Line rejected: $line")
		}
	}
	printSubInfo("Read ${lines.size} valid line(s)")
	return lines
}

private fun buildNodeLabelToIdMap(lines: ArrayList<String>): HashMap<String, Int> {

	printInfo("Parsing nodes")

	val nodeLabelToIdMap = HashMap<String, Int>()
	lines.forEach { line ->
		val matcher = validLineFormat.matcher(line)
		matcher.find()
		val node1 = matcher.group(1)
		val node2 = matcher.group(3)

		nodeLabelToIdMap.putIfAbsent(node1, nodeLabelToIdMap.size)
		nodeLabelToIdMap.putIfAbsent(node2, nodeLabelToIdMap.size)
	}
	printSubInfo("Parsed ${nodeLabelToIdMap.size} node(s)")
	return nodeLabelToIdMap
}

private fun buildNetwork(lines: ArrayList<String>, nodeLabelToIdMap: HashMap<String, Int>): Network {

	printInfo("Constructing network")

	val network = Network(nodeLabelToIdMap.size)
	nodeLabelToIdMap.forEach { label, id -> network.setNodeLabel(id, label) }

	lines.forEach {
		line ->
		val matcher = validLineFormat.matcher(line)
		matcher.find()
		val fromNode = nodeLabelToIdMap[matcher.group(1)]!!
		val type = matcher.group(2)
		val toNode = nodeLabelToIdMap[matcher.group(3)]!!

		// double-edged?
		if (type == "--") {
			network.addEdge(fromNode, toNode)
			network.addEdge(toNode, fromNode)
		} else {
			network.addEdge(fromNode, toNode)
		}
	}
	printSubInfo("Known network has ${network.nodeCount} node(s)")
	printSubInfo("Known network has ${network.edgeCount} edge(s)")
	return network
}
