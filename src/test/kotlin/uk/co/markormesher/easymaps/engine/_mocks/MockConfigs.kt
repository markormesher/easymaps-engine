package uk.co.markormesher.easymaps.engine._mocks

import uk.co.markormesher.easymaps.engine.DatasetGeneratorConfig
import uk.co.markormesher.easymaps.engine.EngineConfig
import uk.co.markormesher.easymaps.engine.LogGeneratorConfig
import uk.co.markormesher.easymaps.engine.domain_specific.sample.SampleDatasetGeneratorOptionProvider
import uk.co.markormesher.easymaps.engine.domain_specific.sample.SampleLogGeneratorOptionProvider
import uk.co.markormesher.easymaps.engine.domain_specific.sample.SampleLogReader
import uk.co.markormesher.easymaps.engine.domain_specific.sample.SampleOptionProvider
import uk.co.markormesher.easymaps.engine.interfaces.DatasetGeneratorOptionProvider
import uk.co.markormesher.easymaps.engine.interfaces.LogGeneratorOptionProvider
import uk.co.markormesher.easymaps.engine.interfaces.LogReader
import uk.co.markormesher.easymaps.engine.interfaces.OptionProvider
import uk.co.markormesher.easymaps.engine.structures.TraitTranslator

fun getMockEngineConfig(
		logReader: LogReader = SampleLogReader(),
		optionProvider: OptionProvider = SampleOptionProvider(),
		traitTranslator: TraitTranslator = TraitTranslator(),
		logFolderPath: String = "",
		knownNetworkFilePath: String = "",
		outputFolderPath: String = "",
		graphvizExec: String = "",
		drawGraphs: Boolean = false
) = EngineConfig(
		logReader = logReader,
		optionProvider = optionProvider,
		traitTranslator = traitTranslator,
		logFolderPath = logFolderPath,
		knownNetworkFilePath = knownNetworkFilePath,
		outputFolderPath = outputFolderPath,
		graphvizExec = graphvizExec,
		drawGraphs = drawGraphs
)

fun getMockLogGeneratorConfig(
		logGeneratorOptionProvider: LogGeneratorOptionProvider = SampleLogGeneratorOptionProvider(),
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

fun getMockDatasetGeneratorConfig(
		sizes: List<Int>,
		datasetGeneratorOptionProvider: DatasetGeneratorOptionProvider = SampleDatasetGeneratorOptionProvider(sizes),
		outputFolderPath: String = ""
) = DatasetGeneratorConfig(
		datasetGeneratorOptionProvider = datasetGeneratorOptionProvider,
		outputFolderPath = outputFolderPath
)
