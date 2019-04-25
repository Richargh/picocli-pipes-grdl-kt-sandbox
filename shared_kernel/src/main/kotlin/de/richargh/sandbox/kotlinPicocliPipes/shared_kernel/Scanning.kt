package de.richargh.sandbox.kotlinPicocliPipes.shared_kernel

import java.io.InputStream
import java.util.*

fun InputStream.forEachLine(action: (String) -> Unit){
    // stop reading when no input available
    // dirty hack: necessary because we want to accept piped input but not regular typed user input
    // by piped input we mean stuff supplied from the command line: cat foo.txt | java -jar our.jar
    val scanner = Scanner(this)
    println("Available ${available()}")
    while (available() > 0) {
        try {
            action(scanner.nextLine())
        } catch (e: NoSuchElementException) {
            break
        }
    }
}