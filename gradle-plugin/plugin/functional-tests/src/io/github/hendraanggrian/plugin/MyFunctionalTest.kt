package io.github.hendraanggrian.plugin

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
    private lateinit var settingsFile: File
    private lateinit var buildFile: File
    private lateinit var runner: GradleRunner

    @BeforeTest
    @Throws(IOException::class)
    fun setup() {
        settingsFile = testProjectDir.newFile("settings.gradle.kts")
        buildFile = testProjectDir.newFile("build.gradle.kts")
        runner = GradleRunner.create()
            .withPluginClasspath()
            .withProjectDir(testProjectDir.root)
            .withTestKitDir(testProjectDir.newFolder())
    }

    @Test
    fun myExtensionTest() {
        settingsFile.writeText(
            """
            rootProject.name = "my-extension-test"
            """.trimIndent()
        )
        buildFile.writeText(
            """
            plugins {
                id("io.github.hendraanggrian.plugin")
            }
            myPlugin {
                line.set("A")
            }
            println(extensions.getByName<io.github.hendraanggrian.plugin.MyExtension>("myPlugin").line.get())
            """.trimIndent()
        )
        runner.build().let {
            assertTrue("A" in it.output)
        }
    }

    @Test
    fun myTaskTest() {
        settingsFile.writeText(
            """
            rootProject.name = "my-task-test"
            """.trimIndent()
        )
        buildFile.writeText(
            """
            plugins {
                id("io.github.hendraanggrian.plugin")
            }
            myPlugin {
                line.set("A")
            }
            tasks.myTask {
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