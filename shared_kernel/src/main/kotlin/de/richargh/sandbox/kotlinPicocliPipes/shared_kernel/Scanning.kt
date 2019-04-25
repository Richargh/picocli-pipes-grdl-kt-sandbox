package de.richargh.sandbox.kotlinPicocliPipes.shared_kernel

import java.io.InputStream
import java.util.*

fun InputStream.forEachLine(action: (String) -> Unit){
    // stop reading when no input available
    // expection catching is a dirty hack:
    // it's necessary because we want to accept piped input but not regular typed user input from the console
    // by piped input we mean stuff supplied from the command line: cat foo.txt | java -jar our.jar
    val scanner = Scanner(this)
    while (available() > 0) {
        try {
            action(scanner.nextLine())
        } catch (e: NoSuchElementException) {
            break
        }
    }
}

fun <R> InputStream.mapLines(transform: (String) -> R): List<R>{
    val result = mutableListOf<R>()
    forEachLine { result.add(transform(it)) }
    return result
}