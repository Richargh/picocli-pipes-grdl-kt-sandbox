package de.richargh.sandbox.kotlinPicocliPipes.addition

fun add(first: List<Double>, other: List<Double>): Double {
    val sumInput = first.fold(0.0) { i, d -> i + d }
    val sumParameter = other.fold(0.0) { i, d -> i + d }
    return sumInput + sumParameter
}