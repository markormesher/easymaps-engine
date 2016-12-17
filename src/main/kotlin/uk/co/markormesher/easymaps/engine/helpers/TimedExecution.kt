package uk.co.markormesher.easymaps.engine.helpers

fun timedExecution(title: String, preRuns: Int, runs: Int, exec: (() -> Unit)) {
	var timer: Long
	var timerTotal: Long = 0

	printInfo("Timing '$title':")

	// pre runs
	for (i in 1..preRuns) {
		printSubInfo("Pre-running")
		exec()
	}

	// real runs
	printSubInfo("Running")
	for (i in 1..runs) {
		timer = -System.nanoTime()
		exec()
		timer += System.nanoTime()
		timerTotal += timer
		printSubInfo(String.format("%.04f s", (timer / 1000000000.0)))
	}

	val average = (timerTotal / runs.toDouble()) / 1000000000
	printSubInfo(String.format("Average: %.04f s", average))
}
