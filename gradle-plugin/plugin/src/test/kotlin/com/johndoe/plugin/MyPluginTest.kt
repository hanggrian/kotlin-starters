package com.johndoe.plugin

import com.google.common.truth.Truth.assertThat
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome.SUCCESS
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import java.io.File
import java.io.IOException
import kotlin.test.BeforeTest
import kotlin.test.Test

class MyPluginTest {
    @Rule
    @JvmField
    val testProjectDir = TemporaryFolder()
    private lateinit var buildFile: File
    private lateinit var runner: GradleRunner

    @BeforeTest
    @Throws(IOException::class)
    fun setup() {
        testProjectDir
            .newFile("settings.gradle.kts")
            .writeText("rootProject.name = \"functional-test\"")
        buildFile = testProjectDir.newFile("build.gradle.kts")
        runner =
            GradleRunner
                .create()
                .withPluginClasspath()
                .withProjectDir(testProjectDir.getRoot())
                .withTestKitDir(testProjectDir.newFolder())
    }

    @Test
    fun myTask() {
        buildFile.writeText(
            """
            plugins {
                id("com.johndoe.plugin")
            }
            """.trimIndent(),
        )
        assertThat(
            runner
                .withArguments("myTask")
                .build()
                .task(":myTask")!!
                .outcome,
        ).isEqualTo(SUCCESS)
    }
}
