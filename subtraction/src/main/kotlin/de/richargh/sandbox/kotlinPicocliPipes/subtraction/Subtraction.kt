package de.richargh.sandbox.kotlinPicocliPipes.subtraction

import de.richargh.sandbox.kotlinPicocliPipes.shared_kernel.Console
import de.richargh.sandbox.kotlinPicocliPipes.shared_kernel.mapLines
import picocli.CommandLine.*
import java.io.IOException
import java.io.InputStream
import java.io.PrintStream
import java.util.concurrent.Callable

@Command(name = "Subtraction",
         description = ["subtracts values from each other"])
class Subtraction(
        private val input: InputStream,
        private val output: PrintStream,
        private val error: PrintStream): Callable<Void> {

    @Option(names = ["-h", "--help"], usageHelp = true, description = ["displays this help and exits"])
    private var help = false

    @Parameters(arity = "0..*", paramLabel = "NUMBER", description = ["numbers to subtract"])
    private val numbers: List<Double> = mutableListOf()

    @Throws(IOException::class)
    override fun call(): Void? {
        val console = Console(output, error, false, false)

        error.println("Available Subtraction input bytes: ${input.available()}")
        val inputNumbers = input.mapLines {
            error.println("Subtraction line is '$it'")
            it.toDoubleOrNull()
        }.filterNotNull()

        if (inputNumbers.isEmpty() && numbers.isEmpty()) {
            console.println("Please provide numbers to subtract")
        } else {
            val sum = sub(inputNumbers, numbers)
            console.println(sum)
        }

        return null
    }
}

fun main(args: Array<String>) {
    mainWithInOut2(System.`in`, System.out, System.err, args)
}

fun mainWithInOut2(input: InputStream, output: PrintStream, error: PrintStream, args: Array<String>) {
    call(Subtraction(input, output, error), output, *args)
}