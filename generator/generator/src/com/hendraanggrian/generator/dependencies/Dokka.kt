package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object Dokka : Dependency("dokka") {

    override fun FileSpecBuilder.initialize() {
        properties {
            gitHubVal("VERSION_DOKKA", "Kotlin", "dokka")
        }
        functions {
            dependencyFun("dokka", "module" to true) {
                append(
                    "return %P",
                    "org.jetbrains.dokka:dokka-\${module.wrap { \"\$it-\" }}gradle-plugin:\$VERSION_DOKKA"
                )
            }
            pluginFun("dokka", "module" to true) {
                appendln("return id(%P)", "org.jetbrains.dokka\${module.wrap { \"-\$it\" }}")
            }
        }
    }
}