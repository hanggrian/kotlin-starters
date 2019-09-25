package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object Ktlint : Dependency("ktlint") {

    override fun FileSpecBuilder.initialize() {
        properties {
            mavenCentralVal("VERSION_KTLINT", "com.pinterest", "ktlint")
        }
        functions {
            dependencyFun("ktlint") {
                append("return %P", "com.pinterest:ktlint:\$VERSION_KTLINT")
            }
        }
    }
}