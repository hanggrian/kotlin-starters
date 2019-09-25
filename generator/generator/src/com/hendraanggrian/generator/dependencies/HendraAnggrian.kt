package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object HendraAnggrian : Dependency("hendraanggrian") {

    override fun FileSpecBuilder.initialize() {
        functions {
            dependency("hendraanggrian", "module" to false, "version" to false) {
                append("return %S", "com.hendraanggrian:\$module:\$version")
            }
            plugin("dokka", "module" to false) {
                appendln("return id(%S)", "com.hendraanggrian\$module")
            }
        }
    }
}
