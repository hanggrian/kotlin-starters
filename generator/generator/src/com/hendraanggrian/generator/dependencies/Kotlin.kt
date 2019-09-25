package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object Kotlin : Dependency("kotlin") {

    override fun FileSpecBuilder.initialize() {
        properties {
            mavenCentralVal("VERSION_KOTLIN", "org.jetbrains.kotlin", "kotlin-project")
            mavenCentralVal("VERSION_COROUTINES", "Kotlin", "kotlinx.coroutines")
        }
        functions {
            dependency("kotlinx", "module" to false, "version" to true) {
                append("return %S", "org.jetbrains.kotlinx:kotlinx-\$module\${version?.let { \":\$it\" } ?: \"\" }\"")
            }
        }
    }
}