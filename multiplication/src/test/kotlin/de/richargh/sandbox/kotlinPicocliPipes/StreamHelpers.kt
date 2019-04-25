package de.richargh.sandbox.kotlinPicocliPipes

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream

fun outputAsString(input: String = "", aMethod: (input: InputStream, output: PrintStream) -> Unit) =
        ByteArrayOutputStream().use { baOutputStream ->
            PrintStream(baOutputStream).use { printStream ->
                val inputStream = ByteArrayInputStream(input.toByteArray())
                aMethod(inputStream, printStream)
            }
            baOutputStream.toString()
        }