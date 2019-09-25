package com.hendraanggrian.generator

import com.hendraanggrian.generator.dependencies.Dependency
import com.hendraanggrian.kotlinpoet.buildFile
import java.io.File

class DependenciesBuilder(private val targetDir: File) {

    fun install(dependency: Dependency) =
        buildFile("", dependency.name) { dependency.run { initialize() } }.writeTo(targetDir)
}