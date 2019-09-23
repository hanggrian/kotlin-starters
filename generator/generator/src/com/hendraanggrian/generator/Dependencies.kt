package com.hendraanggrian.generator

import com.hendraanggrian.kotlinpoet.buildFile
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.STRING
import kotlinx.coroutines.runBlocking
import java.io.File

private val DEPENDENCY_HANDLER = ClassName("org.gradle.api.artifacts.dsl", "DependencyHandler")
private val PLUGIN_DEPENDENCIES_SPEC = ClassName("org.gradle.plugin.use", "PluginDependenciesSpec")

fun kotlin() {
    buildFile("", "kotlin") {
        properties {
            "VERSION_KOTLIN"(STRING, KModifier.CONST) {
                runBlocking { initializer("%S", GitHubApi.getLatestRelease("JetBrains", "kotlin")) }
            }
            "VERSION_COROUTINES"(STRING, KModifier.CONST) {
                runBlocking { initializer("%S", GitHubApi.getLatestRelease("Kotlin", "kotlinx.coroutines")) }
            }
        }
        functions.add("kotlinx") {
            receiver(DEPENDENCY_HANDLER)
            returns = STRING
            parameters {
                add("module", STRING)
                add("version", STRING.copy(true)) {
                    defaultValue = "null"
                }
            }
            append("return \"org.jetbrains.kotlinx:kotlinx-\$module\${version?.let { \":\$it\" } ?: \"\" }\"")
        }
    }.writeTo(File(""))
}

fun dokka() {
    buildFile("", "dokka") {
        properties {
            "VERSION_DOKKA"(STRING, KModifier.CONST) {
                runBlocking { initializer("%S", GitHubApi.getLatestRelease("Kotlin", "dokka")) }
            }
        }
        functions {
            "dokka" {
                receiver(DEPENDENCY_HANDLER)
                returns = STRING
                parameters {
                    add("module", STRING.copy(true)) {
                        defaultValue = "null"
                    }
                }
                append("return \"org.jetbrains.dokka:dokka-\${module.wrap { \"\$it-\" }}gradle-plugin:\$VERSION_DOKKA\"")
            }
            "dokka" {
                receiver(PLUGIN_DEPENDENCIES_SPEC)
                returns = STRING
                parameters {
                    add("module", STRING.copy(true)) {
                        defaultValue = "null"
                    }
                }
                appendln("return id(\"org.jetbrains.dokka\${module.wrap { \"-\$it\" }}\")")
            }
        }
    }.writeTo(File(""))
}