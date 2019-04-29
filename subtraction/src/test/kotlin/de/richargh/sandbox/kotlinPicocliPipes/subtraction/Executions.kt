package de.richargh.sandbox.kotlinPicocliPipes.subtraction

import de.richargh.sandbox.kotlinPicocliPipes.shared_kernel.outputAsString

fun executeForOutput(input: String, args: Array<String> = emptyArray()) =
        outputAsString(input) { inputStream, outputStream, errorStream ->
            mainWithInOut2(inputStream, outputStream, errorStream, args)
        }

fun executeForOutput(args: Array<String> = emptyArray()) =
        outputAsString { inputStream, outputStream, errorStream ->
            mainWithInOut2(inputStream, outputStream, errorStream, args)
        }