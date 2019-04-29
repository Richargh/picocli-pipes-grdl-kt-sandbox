package de.richargh.sandbox.kotlinPicocliPipes.subtraction

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.*
import de.richargh.sandbox.kotlinPicocliPipes.shared_kernel.outputAsString
import org.junit.jupiter.api.Test

internal class SubtractionTest {

    @Test
    fun `prints a message to the user if no numbers are provided`() {
        // arrange
        val defaultHelloMessage = "Please provide numbers to subtract"

        // act
        val cliResult = executeForOutput()

        // assert
        assertThat(cliResult, containsSubstring(defaultHelloMessage))
    }

    @Test
    fun `subtracts input number from 0`() {
        // arrange
        val input = 3.0.toString()

        // act
        val cliResult = executeForOutput(input)

        // assert
        assertThat(cliResult, equalTo("$input\n"))
    }

    @Test
    fun `subtracts input number from parameters`() {
        // arrange
        val input = 3.0.toString()

        // act
        val cliResult = executeForOutput(input, arrayOf("10", "2"))

        // assert
        assertThat(cliResult, equalTo("5.0\n"))
    }

    @Test
    fun `prints help message if asked for it`() {
        // arrange
        val args = arrayOf("--help")

        // act
        val cliResult = executeForOutput(args)

        // assert
        assertThat(cliResult, containsSubstring("Usage: Subtraction [-h]"))
    }

    @Test
    fun `does not print help message by default`() {
        // arrange
        val args = emptyArray<String>()

        // act
        val cliResult = executeForOutput(args)

        // assert
        assertThat(cliResult, !containsSubstring("Usage: Subtraction [-h]"))
    }
}