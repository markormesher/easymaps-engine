package uk.co.markormesher.easymaps.engine._mocks

import uk.co.markormesher.easymaps.engine.WalkerConfig
import uk.co.markormesher.easymaps.engine.interfaces.WalkerOptionProvider

fun getMockWalkerConfig(
		walkerOptionProvider: WalkerOptionProvider = MockWalkerOptionProvider(),
		knownNetworkFilePath: String = "",
		logFolderPath: String = "",
		outputFolderPath: String = "",
		graphvizExec: String = "/usr/bin/dot"
) = WalkerConfig(
		walkerOptionProvider = walkerOptionProvider,
		knownNetworkFilePath = knownNetworkFilePath,
		logFolderPath = logFolderPath,
		outputFolderPath = outputFolderPath,
		graphvizExec = graphvizExec
)
