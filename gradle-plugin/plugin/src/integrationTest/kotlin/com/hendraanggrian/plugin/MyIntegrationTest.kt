package com.hendraanggrian.plugin

import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import java.io.File
import java.io.IOException
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

class MyIntegrationTest {
    @Rule @JvmField
    val testProjectDir = TemporaryFolder()
    private lateinit var buildFile: File
    private lateinit var runner: GradleRunner

    @BeforeTest
    @Throws(IOException::class)
    fun setup() {
        testProjectDir.newFile("settings.gradle.kts").writeText(
            """
            rootProject.name = "my-extension-test"
            """.trimIndent()
        )
        buildFile = testProjectDir.newFile("build.gradle.kts")
        runner = GradleRunner.create()
            .withPluginClasspath()
            .withProjectDir(testProjectDir.root)
            .withTestKitDir(testProjectDir.newFolder())
    }

    @Test
    fun myExtensionTest() {
        buildFile.writeText(
            """
            plugins {
                id("com.hendraanggrian.plugin")
            }
            myPlugin {
                line.set("A")
            }
            println(extensions.getByName<com.hendraanggrian.plugin.MyExtension>("myPlugin").line.get())
            """.trimIndent()
        )
        runner.build().let {
            assertTrue("A" in it.output)
        }
    }
}
