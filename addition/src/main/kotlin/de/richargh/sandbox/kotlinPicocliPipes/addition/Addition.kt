package de.richargh.sandbox.kotlinPicocliPipes.addition

import de.richargh.sandbox.kotlinPicocliPipes.shared_kernel.forEachLine
import picocli.CommandLine.*
import java.io.IOException
import java.io.InputStream
import java.io.PrintStream
import java.util.concurrent.Callable

@Command(
        name = "Addition",
        description = ["adds values together"])
class Addition(private val input: InputStream, private val output: PrintStream): Callable<Void> {

    @Option(names = ["-h", "--help"], usageHelp = true, description = ["displays this help and exits"])
    private var help = false

    @Throws(IOException::class)
    override fun call(): Void? {
        output.println("Supppp")

        output.println("Passed in was:")
        input.forEachLine {
            output.println(it)
        }

        return null
    }
}

fun main(args: Array<String>) {
    mainWithInOut(System.`in`, System.out, args)
}

fun mainWithInOut(input: InputStream, output: PrintStream, args: Array<String>) {
    call(Addition(input, output), output, *args)
}