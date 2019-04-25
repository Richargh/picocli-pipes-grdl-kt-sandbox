package de.richargh.sandbox.kotlinPicocliPipes.multiplication

import de.richargh.sandbox.kotlinPicocliPipes.shared_kernel.Console
import de.richargh.sandbox.kotlinPicocliPipes.shared_kernel.forEachLine
import de.richargh.sandbox.kotlinPicocliPipes.shared_kernel.mapLines
import picocli.CommandLine.*
import java.io.IOException
import java.io.InputStream
import java.io.PrintStream
import java.util.concurrent.Callable

@Command(
        name = "Multiplication",
        description = ["multiplies numbers"])
class Multiplication(
        private val input: InputStream,
        private val output: PrintStream,
        private val error: PrintStream): Callable<Void> {

    @Option(names = ["-h", "--help"], usageHelp = true, description = ["displays this help and exits"])
    private var help = false

    @Parameters(arity = "0..*", paramLabel = "NUMBER", description = ["numbers to multiply"])
    private val numbers: List<Double> = mutableListOf()

    @Throws(IOException::class)
    override fun call(): Void? {
        val console = Console(output, error, false, false)

        val inputNumbers = input.mapLines {
            it.toDoubleOrNull()
        }.filterNotNull()

        if (inputNumbers.isEmpty() && numbers.isEmpty()) {
            console.println("Please provide numbers to multiply")
        } else {
            val product = multiply(inputNumbers, numbers)
            console.println(product)
        }

        return null
    }
}

fun main(args: Array<String>) {
    mainWithInOut(System.`in`, System.out, System.err, args)
}

fun mainWithInOut(input: InputStream, output: PrintStream, error: PrintStream, args: Array<String>) {
    call(Multiplication(input, output, error), output, *args)
}