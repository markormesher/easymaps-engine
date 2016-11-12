package uk.co.markormesher.easymaps.engine.core

import uk.co.markormesher.easymaps.engine.Config
import uk.co.markormesher.easymaps.engine.data.Network
import uk.co.markormesher.easymaps.engine.helpers.generateNetworkImage
import uk.co.markormesher.easymaps.engine.helpers.printInfo
import uk.co.markormesher.easymaps.engine.helpers.printSubHeader
import uk.co.markormesher.easymaps.engine.helpers.printSubInfo
import java.io.File
import java.io.PrintWriter
import java.util.*
import java.util.regex.Pattern

fun matchToKnownNetwork(observedNetwork: Network, cfg: Config) {

	printSubHeader("Matching to Known Network")

	val knownNetwork = parseKnownNetwork(cfg)
	printInfo("Writing known network to file...")
	generateNetworkImage(knownNetwork, "known-network", cfg)
	val isomorphisms = generateIsomorphisms(observedNetwork, knownNetwork)
	printInfo("Found ${isomorphisms.size} possible isomorphism(s)")
	if (isomorphisms.size > 0) writeLabellingsToFiles(knownNetwork, isomorphisms, cfg)
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

	// create network with named nodes
	val network = Network(nodeLabelToIdMap.size)
	nodeLabelToIdMap.forEach { label, id -> network.nodeLabels[id] = label }

	// create edges
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

// maps are "observed node id" -> "known node id"
fun generateIsomorphisms(observedNetwork: Network, knownNetwork: Network): List<Map<Int, Int>> {
	val isomorphisms = ArrayList<Map<Int, Int>>()

	val iso = TreeMap<Int, Int>()
	iso.put(14, 0)
	iso.put(1, 1)
	isomorphisms.add(iso)

	return isomorphisms
}

fun writeLabellingsToFiles(knownNetwork: Network, isomorphisms: List<Map<Int, Int>>, cfg: Config) {

	printInfo("Writing final labelling(s) to file(s)...")

	isomorphisms.forEachIndexed { i, iso ->
		printSubInfo("Writing labelling #${i + 1}")

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
					append(knownNetwork.nodeLabels[knownNodeId])
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
