package uk.co.markormesher.easymaps.engine._mocks

import uk.co.markormesher.easymaps.engine.LogGeneratorConfig
import uk.co.markormesher.easymaps.engine.interfaces.LogGeneratorOptionProvider

fun getMockLogGeneratorConfig(
		logGeneratorOptionProvider: LogGeneratorOptionProvider = MockLogGeneratorOptionProvider(),
		knownNetworkFilePath: String = "",
		logFolderPath: String = "",
		outputFolderPath: String = "",
		graphvizExec: String = "/usr/bin/dot",
		drawGraphs: Boolean = true
) = LogGeneratorConfig(
		logGeneratorOptionProvider = logGeneratorOptionProvider,
		knownNetworkFilePath = knownNetworkFilePath,
		logFolderPath = logFolderPath,
		outputFolderPath = outputFolderPath,
		graphvizExec = graphvizExec,
		drawGraphs = drawGraphs
)
