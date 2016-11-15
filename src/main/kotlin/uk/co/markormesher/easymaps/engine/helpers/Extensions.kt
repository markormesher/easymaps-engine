package uk.co.markormesher.easymaps.engine.helpers

import java.util.*

/**
 * Runs the passed method for every possible pair of items in the collection,
 * including pairs of the same item.
 */
fun <T> Collection<T>.forEachPair(exec: (T, T) -> Unit) = forEach { a -> forEach { b -> exec(a, b) } }

/**
 * Returns the list element that appears as strictly more than half of the elements,
 * or the passed failure option if no such element exists.
 */
fun <T> Collection<T>.majorityElement(failure: T): T {
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

/**
 * Returns a randomly selected element from the list.
 */
// TODO: tests for random elements from lists
fun <T> List<T>.randomElement(): T {
	if (isEmpty()) throw ArrayIndexOutOfBoundsException()
	return this[randomInt(0, size)]
}

/**
 * Returns a randomly selected element from the array.
 */
// TODO: tests for random elements from arrays
fun <T> Array<T>.randomElement(): T {
	if (isEmpty()) throw ArrayIndexOutOfBoundsException()
	return this[randomInt(0, size)]
}