package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.Config
import uk.co.markormesher.easymaps.engine.data.Network
import uk.co.markormesher.easymaps.engine.helpers.*
import java.io.File
import java.util.*
import java.util.regex.Pattern

fun parseKnownNetwork(cfg: Config): Network {

	printSubHeader("Parsing Known Network")

	val validNodeRegex = "[A-Za-z0-9'/.\\(\\)\\- ]"
	val validLineFormat = Pattern.compile("\"($validNodeRegex+)\" (\\-\\-|\\->) \"($validNodeRegex+)\"")!!

	// read file to collect valid lines
	printInfo("Reading file...")
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
	printSubInfo("Read ${lines.size} valid lines")

	// read file and count nodes
	val nodeLabelToIdMap = HashMap<String, Int>()
	lines.forEach { line ->
		val matcher = validLineFormat.matcher(line)
		matcher.find()
		val node1 = matcher.group(1)
		val node2 = matcher.group(3)

		nodeLabelToIdMap.putIfAbsent(node1, nodeLabelToIdMap.size)
		nodeLabelToIdMap.putIfAbsent(node2, nodeLabelToIdMap.size)
	}

	// create network with named nodes
	val network = Network(nodeLabelToIdMap.size)
	nodeLabelToIdMap.forEach { label, id -> network.nodeLabels[id] = label }

	// create edges
	printInfo("Constructing network...")
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
	printSubInfo("Network has ${network.nodeCount} node(s)")
	printSubInfo("Network has ${network.edgeCount} edge(s)")

	printInfo("Writing known network to file...")
	generateNetworkImage(network, "known-network", cfg)

	return network
}
