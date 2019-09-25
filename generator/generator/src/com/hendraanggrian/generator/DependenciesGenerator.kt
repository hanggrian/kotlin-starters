package com.hendraanggrian.generator

import com.hendraanggrian.generator.dependencies.Dokka
import com.hendraanggrian.generator.dependencies.GitPublish
import com.hendraanggrian.generator.dependencies.Kotlin
import com.hendraanggrian.generator.dependencies.Ktlint
import com.hendraanggrian.generator.dependencies.Ktor
import java.io.File

object DependenciesGenerator {

    @JvmStatic
    fun main(args: Array<String>) {
        (File("buildSrc/src/dependencies")) {
            install(Kotlin)
            install(Dokka)
            install(Ktlint)
            install(GitPublish)
            install(Ktor)
        }
        "jvm-library" {
            install(Kotlin)
            install(Dokka)
            install(Ktlint)
            install(GitPublish)
        }
        "jvm-app" {
            install(Kotlin)
            install(Ktlint)
            install(GitPublish)
        }
        "android-library" {
            install(Kotlin)
            install(Dokka)
            install(Ktlint)
            install(GitPublish)
        }
        "android-app" {
            install(Kotlin)
            install(Ktlint)
            install(GitPublish)
        }
        "gradle-plugin" {
            install(Kotlin)
            install(Dokka)
            install(Ktlint)
            install(GitPublish)
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