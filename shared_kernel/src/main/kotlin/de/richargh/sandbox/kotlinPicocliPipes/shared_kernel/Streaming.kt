package de.richargh.sandbox.kotlinPicocliPipes.shared_kernel

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

fun outputAsString(input: String, aMethod: (input: InputStream, output: PrintStream) -> Unit) =
        outputAsString(ByteArrayInputStream(input.toByteArray()), aMethod)

fun outputAsString(inputStream: InputStream = System.`in`, aMethod: (input: InputStream, output: PrintStream) -> Unit) =
        ByteArrayOutputStream().use { baOutputStream ->
            PrintStream(baOutputStream).use { printStream ->
                aMethod(inputStream, printStream)
            }
            baOutputStream.toString()
        }