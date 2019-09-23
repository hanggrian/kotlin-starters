package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.generator.DependencyBuilder
import com.hendraanggrian.kotlinpoet.asNullable
import com.squareup.kotlinpoet.STRING

fun DependencyBuilder.kotlin() {
    "kotlin" {
        properties {
            constVal("VERSION_KOTLIN", "JetBrains", "kotlin")
            constVal("VERSION_COROUTINES", "Kotlin", "kotlinx.coroutines")
        }
        functions.add("kotlinx") {
            receiver = dependencyHandler
            returns<String>()
            parameters {
                add<String>("module")
                add("version", STRING.asNullable()) {
                    defaultValue("null")
                }
            }
            append("return \"org.jetbrains.kotlinx:kotlinx-\$module\${version?.let { \":\$it\" } ?: \"\" }\"")
        }
    }
}