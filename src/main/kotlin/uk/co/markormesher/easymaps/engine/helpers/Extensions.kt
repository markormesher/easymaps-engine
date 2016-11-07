package uk.co.markormesher.easymaps.engine.helpers

fun <T> List<T>.forAllPairs(exec: (T, T) -> Unit) = forEach { a -> forEach { b -> exec(a, b) } }