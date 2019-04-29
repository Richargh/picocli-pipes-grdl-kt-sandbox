package de.richargh.sandbox.kotlinPicocliPipes.subtraction

fun sub(first: List<Double>, other: List<Double>): Double {
    val numbers: List<Double> = other + first
    return numbers.reduce { acc, d ->  acc - d }
}