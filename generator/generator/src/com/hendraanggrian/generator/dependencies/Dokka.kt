package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.generator.DependencyBuilder
import com.hendraanggrian.kotlinpoet.asNullable
import com.squareup.kotlinpoet.STRING

fun DependencyBuilder.dokka() {
    "dokka" {
        properties {
            constVal("VERSION_DOKKA", "Kotlin", "dokka")
        }
        functions {
            "dokka" {
                receiver = dependencyHandler
                returns<String>()
                parameters {
                    add("module", STRING.asNullable()) {
                        defaultValue("null")
                    }
                }
                append("return \"org.jetbrains.dokka:dokka-\${module.wrap { \"\$it-\" }}gradle-plugin:\$VERSION_DOKKA\"")
            }
            "dokka" {
                receiver = pluginDependenciesSpec
                returns<String>()
                parameters {
                    add("module", STRING.asNullable()) {
                        defaultValue("null")
                    }
                }
                appendln("return id(\"org.jetbrains.dokka\${module.wrap { \"-\$it\" }}\")")
            }
        }
    }
}