package de.richargh.sandbox.kotlinPicocliPipes

import picocli.CommandLine.*
import java.io.IOException
import java.io.PrintStream
import java.util.*
import java.util.concurrent.Callable

@Command(
        name = "Cli",
        description = ["generates cc.JSON from source code"])
class Cli(private val out: PrintStream): Callable<Void> {

    @Option(names = ["-h", "--help"], usageHelp = true, description = ["displays this help and exits"])
    private var help = false

    @Throws(IOException::class)
    override fun call(): Void? {
        out.println("Supppp")

        val sc = Scanner(System.`in`)
        out.println("Passed in was:")
        while (sc.hasNextLine()) out.println(sc.nextLine())

        return null
    }
}

fun main(args: Array<String>) {
    mainWithOutputStream(System.out, args)
}

fun mainWithOutputStream(outputStream: PrintStream, args: Array<String>) {
    call(Cli(outputStream), System.out, *args)
}