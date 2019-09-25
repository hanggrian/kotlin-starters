package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object Kotlin : Dependency("kotlin") {

    override fun FileSpecBuilder.initialize() {
        properties {
            mavenCentralVal("VERSION_KOTLIN", "org.jetbrains.kotlin", "kotlin-bom")
            mavenCentralVal("VERSION_COROUTINES", "org.jetbrains.kotlinx", "kotlinx-coroutines-bom")
        }
        functions {
            dependencyFun("kotlinx", "module" to false, "version" to true) {
                append("return %P", "org.jetbrains.kotlinx:kotlinx-\$module\${version?.let { \":\$it\" } ?: \"\" }")
            }
        }
    }
}