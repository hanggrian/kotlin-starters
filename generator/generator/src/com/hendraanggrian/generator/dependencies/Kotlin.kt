package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.generator.Dependency
import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object Kotlin : Dependency("kotlin") {

    init {
        fetch("VERSION_KOTLIN", "JetBrains", "kotlin")
        fetch("VERSION_COROUTINES", "Kotlin", "kotlinx.coroutines")
    }

    override fun FileSpecBuilder.initialize() {
        properties {
            constVal("VERSION_KOTLIN")
            constVal("VERSION_COROUTINES")
        }
        functions {
            dependency("kotlinx", "module" to false, "version" to true) {
                append("return %S", "org.jetbrains.kotlinx:kotlinx-\$module\${version?.let { \":\$it\" } ?: \"\" }\"")
            }
        }
    }
}