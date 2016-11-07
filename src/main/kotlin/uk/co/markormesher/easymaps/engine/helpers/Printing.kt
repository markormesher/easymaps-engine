package uk.co.markormesher.easymaps.engine.helpers

private val ANSI_RESET = "\u001B[0m"
private val ANSI_BOLD = "\u001B[1m"
private val ANSI_WHITE_BG = "\u001B[107m"
private val ANSI_BLACK_TEXT = "\u001B[30m"
private val ANSI_RED_TEXT = "\u001B[31m"
private val ANSI_GREEN_TEXT = "\u001B[32m"
private val ANSI_YELLOW_TEXT = "\u001B[33m"
private val ANSI_BLUE_TEXT = "\u001B[34m"
private val ANSI_PURPLE_TEXT = "\u001B[35m"
private val ANSI_CYAN_TEXT = "\u001B[36m"
private val ANSI_WHITE_TEXT = "\u001B[37m"

private fun bold(msg: String): String = ANSI_BOLD + msg + ANSI_RESET
private fun whiteBg(msg: String): String = ANSI_WHITE_BG + msg + ANSI_RESET
private fun blackText(msg: String): String = ANSI_BLACK_TEXT + msg + ANSI_RESET
private fun redText(msg: String): String = ANSI_RED_TEXT + msg + ANSI_RESET
private fun yellowText(msg: String): String = ANSI_YELLOW_TEXT + msg + ANSI_RESET
private fun purpleText(msg: String): String = ANSI_PURPLE_TEXT + msg + ANSI_RESET

val INPUT_PROMPT = ANSI_CYAN_TEXT + ANSI_BOLD + " --> " + ANSI_RESET

fun printHeader(header: String) {
	println()
	println(whiteBg(redText(" " + "~".repeat(header.length + 4) + " ")))
	println(whiteBg(redText(" ~ ")) + bold(whiteBg(redText(header))) + whiteBg(redText(" ~ ")))
	println(whiteBg(redText(" " + "~".repeat(header.length + 4) + " ")))
	println()
}

fun printSubHeader(header: String) {
	println()
	println(whiteBg(purpleText(" " + "-".repeat(header.length + 2) + " ")))
	println(whiteBg("  ") + bold(whiteBg(blackText(header))) + whiteBg("  "))
	println(whiteBg(purpleText(" " + "-".repeat(header.length + 2) + " ")))
	println()
}

fun printInfo(msg: String) = println("\r ${bold(yellowText(" INFO:"))} $msg")
fun printWarning(msg: String) = println("\r ${bold(purpleText(" WARN:"))} $msg")
fun printError(msg: String) = println("\r ${bold(redText("ERROR:"))} $msg")

fun printSubInfo(msg: String) = println("\r        -  $msg")
fun printSubWarning(msg: String) = println("\r        - ${bold(purpleText(" WARN:"))} $msg")
fun printSubError(msg: String) = println("\r        - ${bold(redText("ERROR:"))} $msg")