package uk.co.markormesher.easymaps.engine.helpers

internal val ANSI_RESET = "\u001B[0m"
internal val ANSI_BOLD = "\u001B[1m"
internal val ANSI_WHITE_BG = "\u001B[107m"
internal val ANSI_BLACK_TEXT = "\u001B[30m"
internal val ANSI_RED_TEXT = "\u001B[31m"
internal val ANSI_GREEN_TEXT = "\u001B[32m"
internal val ANSI_YELLOW_TEXT = "\u001B[33m"
internal val ANSI_BLUE_TEXT = "\u001B[34m"
internal val ANSI_PURPLE_TEXT = "\u001B[35m"
internal val ANSI_CYAN_TEXT = "\u001B[36m"
internal val ANSI_WHITE_TEXT = "\u001B[37m"

internal fun bold(msg: String): String = ANSI_BOLD + msg + ANSI_RESET
internal fun whiteBg(msg: String): String = ANSI_WHITE_BG + msg + ANSI_RESET
internal fun blackText(msg: String): String = ANSI_BLACK_TEXT + msg + ANSI_RESET
internal fun redText(msg: String): String = ANSI_RED_TEXT + msg + ANSI_RESET
internal fun greenText(msg: String): String = ANSI_GREEN_TEXT + msg + ANSI_RESET
internal fun yellowText(msg: String): String = ANSI_YELLOW_TEXT + msg + ANSI_RESET
internal fun blueText(msg: String): String = ANSI_BLUE_TEXT + msg + ANSI_RESET
internal fun purpleText(msg: String): String = ANSI_PURPLE_TEXT + msg + ANSI_RESET
internal fun cyanText(msg: String): String = ANSI_CYAN_TEXT + msg + ANSI_RESET
internal fun whiteText(msg: String): String = ANSI_WHITE_TEXT + msg + ANSI_RESET

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