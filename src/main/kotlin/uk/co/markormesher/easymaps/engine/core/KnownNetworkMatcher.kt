package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.Config
import uk.co.markormesher.easymaps.engine.data.Network
import uk.co.markormesher.easymaps.engine.helpers.generateNetworkImage
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import java.io.File
import java.util.*
import java.util.regex.Pattern

fun matchToKnownNetwork(observedNetwork: Network, cfg: Config) {

	printSubHeader("Matching to Known Network")

	val knownNetwork = parseKnownNetwork(cfg)
	printInfo("Writing known network to file...")
	generateNetworkImage(knownNetwork, "known-network", cfg)
}

fun parseKnownNetwork(cfg: Config): Network {

	printInfo("Parsing known network...")

	val validLineFormat = Pattern.compile("\"([A-Za-z0-9'. ])\" (\\-\\-|\\->) \"([A-Za-z0-9'. ])\"")!!

	// read file to collect valid lines
	val lines = ArrayList<String>()
	val file = File(cfg.knownNetworkFilePath)
	file.forEachLine { tmpLine ->
		val line = tmpLine.trim()
		if (validLineFormat.matcher(line).matches()) lines.add(line)
	}

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

	// create edges
	val network = Network(nodeLabelToIdMap.size)
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

	return network
}