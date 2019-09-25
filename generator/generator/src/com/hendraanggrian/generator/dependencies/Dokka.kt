package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object Dokka : Dependency("dokka") {

    override fun FileSpecBuilder.initialize() {
        properties {
            mavenCentralVal("VERSION_DOKKA", "Kotlin", "dokka")
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