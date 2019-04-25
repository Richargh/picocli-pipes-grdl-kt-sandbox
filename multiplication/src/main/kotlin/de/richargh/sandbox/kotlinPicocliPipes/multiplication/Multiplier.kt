package de.richargh.sandbox.kotlinPicocliPipes.multiplication

fun multiply(first: List<Double>, other: List<Double>): Double {
    val firstMultiplication = first.fold(1.0) { i, d -> i * d }
    val secondMultiplication = other.fold(1.0) { i, d -> i * d }
    return firstMultiplication * secondMultiplication
}