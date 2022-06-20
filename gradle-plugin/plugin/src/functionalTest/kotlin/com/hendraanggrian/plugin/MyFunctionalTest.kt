package com.hendraanggrian.plugin

import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import java.io.File
import java.io.IOException
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MyFunctionalTest {
    @Rule @JvmField val testProjectDir = TemporaryFolder()
    private lateinit var buildFile: File
    private lateinit var runner: GradleRunner

    @BeforeTest
    @Throws(IOException::class)
    fun setup() {
        testProjectDir.newFile("settings.gradle.kts").writeText(
            """
            rootProject.name = "my-task-test"
            """.trimIndent()
        )
        buildFile = testProjectDir.newFile("build.gradle.kts")
        runner = GradleRunner.create()
            .withPluginClasspath()
            .withProjectDir(testProjectDir.root)
            .withTestKitDir(testProjectDir.newFolder())
    }

    @Test
    fun myTaskTest() {
        buildFile.writeText(
            """
            plugins {
                id("com.hendraanggrian.plugin")
            }
            myPlugin {
                line.set("A")
            }
            tasks.getByName<com.hendraanggrian.plugin.MyTask>("myTask") {
                line.set("B")
            }
            """.trimIndent()
        )
        runner.withArguments("myTask").build().let {
            assertTrue("B" in it.output)
            assertEquals(TaskOutcome.SUCCESS, it.task(":myTask")!!.outcome)
        }
    }
}
