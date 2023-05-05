package com.example.demoproject.Models

import Models.ArtifactVersion
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ArtifactVersionTest {

    companion object {
        private const val ENV = "DEV"
        private const val VERSION = "20230501-072635-fhf"
        private const val LINK = "New Link"
    }


    @Test
    fun `artifactVersion check`() {
        when (Companion.ENV) {
            "DEV" -> {
                val pattern = """\d{8}-\d{6}-\b""".trimIndent().toRegex()
                assertThat(pattern.containsMatchIn(Companion.VERSION)).isTrue()
            }

            "STAGE" -> {
                val pattern = Regex("""\d+\.\d{2}+\.\d+""")
                assertThat(pattern.containsMatchIn(Companion.VERSION)).isTrue()
            }

            else ->
                println(" NOT in Proper format")

        }
    }

    @Test
    fun `artifactVersion check_stage`() {
     val staged = ArtifactVersion (
            "Stage",
          "0.20.0",
           "New Link"
        )
        val pattern = Regex("""\d+\.\d{2}+\.\d+""")
        assertThat(staged.env.toString() == "Stage").isTrue()
        assertThat(pattern.containsMatchIn(staged.version.toString())).isTrue()

    }


}