package de.richargh.sandbox.kotlinPicocliPipes.multiplication

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.*
import de.richargh.sandbox.kotlinPicocliPipes.multiplication.mainWithInOut
import de.richargh.sandbox.kotlinPicocliPipes.shared_kernel.outputAsString
import org.junit.jupiter.api.Test

internal class MultiplicationTest {

    @Test
    fun `prints a message to the user if no numbers are provided`() {
        // arrange
        val defaultHelloMessage = "Please provide numbers to multiply"

        // act
        val cliResult = executeForOutput()

        // assert
        assertThat(cliResult, containsSubstring(defaultHelloMessage))
    }

    @Test
    fun `multiplies input number with 1`() {
        // arrange
        val input = 3.0.toString()

        // act
        val cliResult = executeForOutput(input)

        // assert
        assertThat(cliResult, equalTo("$input\n"))
    }

    @Test
    fun `multiplies input numbers to parameters 4*3*2=24`() {
        // arrange
        val input = 4.0.toString()

        // act
        val cliResult = executeForOutput(input, arrayOf("3", "2"))

        // assert
        assertThat(cliResult, equalTo("24.0\n"))
    }

    @Test
    fun `prints help message if asked for it`() {
        // arrange
        val args = arrayOf("--help")

        // act
        val cliResult = executeForOutput(args)

        // assert
        assertThat(cliResult, containsSubstring("Usage: Multiplication [-h]"))
    }

    @Test
    fun `does not print help message by default`() {
        // arrange
        val args = emptyArray<String>()

        // act
        val cliResult = executeForOutput(args)

        // assert
        assertThat(cliResult, !containsSubstring("Usage: Multiplication [-h]"))
    }
}
