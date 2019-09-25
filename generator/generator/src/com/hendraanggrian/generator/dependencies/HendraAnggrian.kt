package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object HendraAnggrian : Dependency("hendraanggrian") {

    override fun FileSpecBuilder.initialize() {
        functions {
            dependencyFun("hendraanggrian", "module" to false, "version" to false) {
                append("return %P", "com.hendraanggrian:\$module:\$version")
            }
            pluginFun("dokka", "module" to false) {
                appendln("return id(%P)", "com.hendraanggrian\$module")
            }
        }
    }
}
