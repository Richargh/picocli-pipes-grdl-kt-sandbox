package de.richargh.sandbox.kotlinPicocliPipes

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.*
import org.junit.jupiter.api.Test

internal class CliTest {

    private val resource = "src/test/resources/foo"

    private val cliResult = retrieveStreamAsString {
        mainWithOutputStream(it, arrayOf())
    }

    @Test
    fun `json output has one root node`() {
        assertThat(cliResult, containsSubstring("Suppp"))
    }
}