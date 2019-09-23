package com.hendraanggrian.generator

import com.hendraanggrian.kotlinpoet.FileSpecBuilder
import com.hendraanggrian.kotlinpoet.buildFile
import com.hendraanggrian.kotlinpoet.dsl.PropertySpecContainer
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.KModifier
import kotlinx.coroutines.runBlocking
import java.io.File

interface DependencyBuilder {

    val dependencyHandler: ClassName
    val pluginDependenciesSpec: ClassName

    val targetDir: File

    operator fun String.invoke(builderAction: FileSpecBuilder.() -> Unit) {
        buildFile("", this, builderAction).writeTo(targetDir)
        targetDir.resolve("$this.kt").renameTo(targetDir.resolve("$this.kts"))
    }

    fun PropertySpecContainer.constVal(name: String, owner: String, repo: String, isInternal: Boolean = false) {
        add<String>(name, KModifier.CONST) {
            if (isInternal) {
                addModifiers(KModifier.INTERNAL)
            }
            runBlocking { initializer("%S", GitHubApi.getLatestRelease(owner, repo)) }
        }
    }
}

class DependencyBuilderImpl(override val targetDir: File) : DependencyBuilder {

    override val dependencyHandler: ClassName = ClassName("org.gradle.api.artifacts.dsl", "DependencyHandler")
    override val pluginDependenciesSpec: ClassName = ClassName("org.gradle.plugin.use", "PluginDependenciesSpec")
}