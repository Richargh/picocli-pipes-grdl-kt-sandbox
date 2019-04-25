package de.richargh.sandbox.kotlinPicocliPipes.shared_kernel

import java.io.ObjectInput
import java.io.PrintStream

class Console(
        private val output: PrintStream,
        private val error: PrintStream,
        private val silent: Boolean,
        private val showError: Boolean) {

    fun println(message: Any){
        output.println(message)
    }
}