package de.richargh.sandbox.kotlinPicocliPipes

import java.io.ByteArrayOutputStream
import java.io.PrintStream

fun retrieveStreamAsString(aMethod: (printStream: PrintStream) -> Unit) =
        ByteArrayOutputStream().use { baOutputStream ->
            PrintStream(baOutputStream).use { printStream ->
                aMethod(printStream)
            }
            baOutputStream.toString()
        }