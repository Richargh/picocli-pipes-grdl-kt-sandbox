package de.richargh.sandbox.kotlinPicocliPipes.shared_kernel

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

fun outputAsString(input: String, aMethod: (input: InputStream, output: PrintStream, error: PrintStream) -> Unit) =
        outputAsString(ByteArrayInputStream(input.toByteArray()), aMethod)

fun outputAsString(
        inputStream: InputStream = System.`in`,
        aMethod: (input: InputStream, output: PrintStream, error: PrintStream) -> Unit) =
        ByteArrayOutputStream().use { baOutputStream ->
            PrintStream(baOutputStream).use { outputStream ->
                aMethod(inputStream, outputStream, System.err)
            }
            baOutputStream.toString()
        }

fun errorAsString(input: String, aMethod: (input: InputStream, output: PrintStream, error: PrintStream) -> Unit) =
        errorAsString(ByteArrayInputStream(input.toByteArray()), aMethod)

fun errorAsString(
        inputStream: InputStream = System.`in`,
        aMethod: (input: InputStream, output: PrintStream, error: PrintStream) -> Unit) =
        ByteArrayOutputStream().use { baOutputStream ->
            PrintStream(baOutputStream).use { errorStream ->
                aMethod(inputStream, System.out, errorStream)
            }
            baOutputStream.toString()
        }