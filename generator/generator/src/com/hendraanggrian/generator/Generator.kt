package com.hendraanggrian.generator

import com.hendraanggrian.kotlinpoet.buildFile
import com.squareup.kotlinpoet.STRING
import kotlinx.coroutines.runBlocking
import java.io.File

object Generator {

    @JvmStatic
    fun main(args: Array<String>) {
        buildFile("", "versions") {
            properties {
                "VERSION_GRADLE"(STRING) {
                    runBlocking {
                        initializer("%S", GitHubApi.getLatestRelease("gradle", "gradle"))
                    }
                }
                "VERSION_KOTLIN"(STRING) {
                    runBlocking {
                        initializer("%S", GitHubApi.getLatestRelease("JetBrains", "kotlin"))
                    }
                }
                "VERSION_COROUTINES"(STRING) {
                    runBlocking {
                        initializer("%S", GitHubApi.getLatestRelease("Kotlin", "kotlinx.coroutines"))
                    }
                }
            }
        }.writeTo(File(""))
    }
}