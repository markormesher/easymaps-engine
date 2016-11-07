package uk.co.markormesher.easymaps.engine.structures

interface Vector {

	operator fun get(i: Int): Double

	operator fun set(i: Int, value: Double)

	val size: Int

}