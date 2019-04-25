package de.richargh.sandbox.kotlinPicocliPipes.addition

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.*
import de.richargh.sandbox.kotlinPicocliPipes.shared_kernel.outputAsString
import org.junit.jupiter.api.Test

internal class AdditionTest {

    @Test
    fun `prints a message to the user if no numbers are provided`() {
        // arrange
        val defaultHelloMessage = "Please provide numbers to add"

        // act
        val cliResult = executeForOutput()

        // assert
        assertThat(cliResult, containsSubstring(defaultHelloMessage))
    }

    @Test
    fun `adds input number to 0`() {
        // arrange
        val input = 3.0.toString()

        // act
        val cliResult = executeForOutput(input)

        // assert
        assertThat(cliResult, equalTo("$input\n"))
    }

    @Test
    fun `adds input number to parameters`() {
        // arrange
        val input = 3.0.toString()

        // act
        val cliResult = executeForOutput(input, arrayOf("1", "2"))

        // assert
        assertThat(cliResult, equalTo("6.0\n"))
    }

    @Test
    fun `prints help message if asked for it`() {
        // arrange
        val args = arrayOf("--help")

        // act
        val cliResult = executeForOutput(args)

        // assert
        assertThat(cliResult, containsSubstring("Usage: Addition [-h]"))
    }

    @Test
    fun `does not print help message by default`() {
        // arrange
        val args = emptyArray<String>()

        // act
        val cliResult = executeForOutput(args)

        // assert
        assertThat(cliResult, !containsSubstring("Usage: Addition [-h]"))
    }
}