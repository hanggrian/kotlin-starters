package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.generator.Dependency
import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object GitPublish: Dependency("gitpublish") {

    init {
        // register()
    }

    override fun FileSpecBuilder.initialize() {

    }
}