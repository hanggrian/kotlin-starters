package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.generator.Dependency
import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object Dokka : Dependency("dokka") {

    init {
        fetch("VERSION_DOKKA", "Kotlin", "dokka")
    }

    override fun FileSpecBuilder.initialize() {
        properties {
            constVal("VERSION_DOKKA")
        }
        functions {
            dependency("dokka", "module" to true) {
                append(
                    "return %S",
                    "org.jetbrains.dokka:dokka-\${module.wrap { \"\$it-\" }}gradle-plugin:\$VERSION_DOKKA"
                )
            }
            plugin("dokka", "module" to true) {
                appendln("return id(%S)", "org.jetbrains.dokka\${module.wrap { \"-\$it\" }}")
            }
        }
    }
}