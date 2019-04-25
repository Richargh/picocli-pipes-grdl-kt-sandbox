package de.richargh.sandbox.kotlinPicocliPipes

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.*
import org.junit.jupiter.api.Test

internal class CliTest {

    @Test
    fun `cli prints nice message to the user`() {
        // arrange
        val defaultHelloMessage = "Suppp"

        // act
        val cliResult = execute()

        // assert
        assertThat(cliResult, containsSubstring(defaultHelloMessage))
    }

    @Test
    fun `cli prints what the user supplied (case A)`() {
        // arrange
        val input = "My name is Bob"

        // act
        val cliResult = execute(input)

        // assert
        assertThat(cliResult, containsSubstring(input))
    }

    @Test
    fun `cli prints what the user supplied (case B)`() {
        // arrange
        val input = "My name is Fran"

        // act
        val cliResult = execute(input)

        // assert
        assertThat(cliResult, containsSubstring(input))
    }

    @Test
    fun `cli prints help message if asked for it`() {
        // arrange
        val args = arrayOf("--help")

        // act
        val cliResult = execute(args)

        // assert
        assertThat(cliResult, containsSubstring("Usage: Cli [-h]"))
    }

    @Test
    fun `cli does not print help message by default`() {
        // arrange
        val args = emptyArray<String>()

        // act
        val cliResult = execute(args)

        // assert
        assertThat(cliResult, !containsSubstring("Usage: Cli [-h]"))
    }
}

fun execute(args: Array<String>) = execute("", args)

fun execute(input: String = "", args: Array<String> = emptyArray()) = outputAsString(input) { inputStrean, outputStream ->
    mainWithInOut(inputStrean, outputStream, args)
}