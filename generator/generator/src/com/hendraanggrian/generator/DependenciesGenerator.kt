package com.hendraanggrian.generator

import com.hendraanggrian.generator.dependencies.Dokka
import com.hendraanggrian.generator.dependencies.Kotlin
import com.hendraanggrian.generator.dependencies.Ktor
import java.io.File

object DependenciesGenerator {

    @JvmStatic
    fun main(args: Array<String>) {
        (File("buildSrc/src/dependencies")) {
            install(Kotlin)
            install(Ktor)
        }
        "jvm-library" {
            install(Kotlin)
            install(Dokka)
        }
        "jvm-app" {
            install(Kotlin)
        }
        "android-library" {
            install(Kotlin)
            install(Dokka)
        }
        "android-app" {
            install(Kotlin)
        }
        "gradle-plugin" {
            install(Kotlin)
            install(Dokka)
        }
        println("Done!")
    }

    private operator fun File.invoke(action: DependenciesBuilder.() -> Unit) {
        deleteRecursively()
        DependenciesBuilder(this).action()
    }

    private operator fun String.invoke(action: DependenciesBuilder.() -> Unit) =
        File("../$this/buildSrc/src/dependencies")(action)
}