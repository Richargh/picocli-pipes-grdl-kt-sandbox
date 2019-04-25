package de.richargh.sandbox.kotlinPicocliPipes.addition

import de.richargh.sandbox.kotlinPicocliPipes.shared_kernel.Console
import de.richargh.sandbox.kotlinPicocliPipes.shared_kernel.mapLines
import picocli.CommandLine.*
import java.io.IOException
import java.io.InputStream
import java.io.PrintStream
import java.util.concurrent.Callable

@Command(name = "Addition",
         description = ["adds values together"])
class Addition(
        private val input: InputStream,
        private val output: PrintStream,
        private val error: PrintStream): Callable<Void> {

    @Option(names = ["-h", "--help"], usageHelp = true, description = ["displays this help and exits"])
    private var help = false

    @Parameters(arity = "0..*", paramLabel = "NUMBER", description = ["numbers to add"])
    private val numbers: List<Double> = mutableListOf()

    @Throws(IOException::class)
    override fun call(): Void? {
        val console = Console(output, error, false, false)

        val inputNumbers = input.mapLines {
            it.toDoubleOrNull()
        }.filterNotNull()

        if (inputNumbers.isEmpty() && numbers.isEmpty()) {
            console.println("Please provide numbers to add")
        } else {
            val sum = add(inputNumbers, numbers)
            console.println(sum)
        }

        return null
    }
}

fun main(args: Array<String>) {
    mainWithInOut(System.`in`, System.out, System.err, args)
}

fun mainWithInOut(input: InputStream, output: PrintStream, error: PrintStream, args: Array<String>) {
    call(Addition(input, output, error), output, *args)
}