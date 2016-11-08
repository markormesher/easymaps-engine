package uk.co.markormesher.easymaps.engine.helpers

import java.util.*

fun <T> Collection<T>.forEachPair(exec: (T, T) -> Unit) = forEach { a -> forEach { b -> exec(a, b) } }

/**
 * Returns the list element that appears as strictly more than half of the elements,
 * or the passed failure option if no such element exists.
 */
fun <T> Collection<T>.getMajorityElement(failure: T): T {
	if (isEmpty()) return failure

	var best = this.first()
	var bestCount = 1
	val counts = HashMap<T, Int>()

	for (e in this) {
		val newCount = counts[e]?.plus(1) ?: 1
		counts[e] = newCount

		if (newCount > bestCount) {
			bestCount = newCount
			best = e
		}
	}

	return if (bestCount > size / 2) best else failure
}