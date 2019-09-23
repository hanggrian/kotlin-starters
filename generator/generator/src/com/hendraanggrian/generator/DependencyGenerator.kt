package com.hendraanggrian.generator

import com.hendraanggrian.generator.dependencies.dokka
import com.hendraanggrian.generator.dependencies.kotlin
import java.io.File

object DependencyGenerator {

    @JvmStatic
    fun main(args: Array<String>) {
        "jvm-library" {
            kotlin()
            dokka()
        }
        "jvm-app" {
            kotlin()
        }
        "android-library" {
            kotlin()
            dokka()
        }
        "android-app" {
            kotlin()
        }
        "gradle-plugin" {
            kotlin()
            dokka()
        }
        println("Done!")
    }

    private operator fun String.invoke(action: DependencyBuilder.() -> Unit) {
        val targetDir = File("../$this/buildSrc/src/dependencies")
        if (targetDir.exists()) {
            targetDir.delete()
        }
        DependencyBuilderImpl(targetDir).action()
    }
}