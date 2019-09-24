package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.generator.Dependency
import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object Ktor : Dependency("ktor") {

    init {
        fetch("VERSION_KTOR", "ktorio", "ktor")
    }

    override fun FileSpecBuilder.initialize() {
        properties {
            constVal("VERSION_KTOR")
        }
        functions {
            dependency("ktor", "module" to false) {
                append("return %S", "io.ktor:ktor-\$module:\$VERSION_KTOR")
            }
        }
    }
}