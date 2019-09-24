package com.hendraanggrian.generator

import com.hendraanggrian.kotlinpoet.FileSpecBuilder
import com.hendraanggrian.kotlinpoet.FunSpecBuilder
import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.dsl.FunSpecContainer
import com.hendraanggrian.kotlinpoet.dsl.PropertySpecContainer
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.STRING
import kotlinx.coroutines.runBlocking

abstract class Dependency(val name: String) {

    private companion object {
        val DEPENDENCY_HANDLER: ClassName = ClassName("org.gradle.api.artifacts.dsl", "DependencyHandler")
        val PLUGIN_DEPENDENCIES_SPEC: ClassName = ClassName("org.gradle.plugin.use", "PluginDependenciesSpec")
    }

    private val map: MutableMap<String, String> = mutableMapOf()

    fun fetch(name: String, owner: String, repo: String) {
        println("Registering $name...")
        var version = map[name]
        if (version == null) {
            println("Fetching github.com/$owner/$repo...")
            version = runBlocking { GitHubApi.getLatestRelease(owner, repo) }
            map[name] = version
            println("Saved: $version")
            println()
        }
    }

    abstract fun FileSpecBuilder.initialize()

    fun PropertySpecContainer.constVal(name: String, isInternal: Boolean = false) {
        add<String>(name, KModifier.CONST) {
            if (isInternal) {
                addModifiers(KModifier.INTERNAL)
            }
            runBlocking {
                initializer("%S", map[name]!!)
            }
        }
    }

    fun FunSpecContainer.dependency(
        name: String,
        vararg params: Pair<String, Boolean>,
        builderAction: FunSpecBuilder.() -> Unit
    ) = stringFun(DEPENDENCY_HANDLER, name, *params, builderAction = builderAction)

    fun FunSpecContainer.plugin(
        name: String,
        vararg params: Pair<String, Boolean>,
        builderAction: FunSpecBuilder.() -> Unit
    ) = stringFun(PLUGIN_DEPENDENCIES_SPEC, name, *params, builderAction = builderAction)

    private fun FunSpecContainer.stringFun(
        receiverClass: ClassName,
        name: String,
        vararg params: Pair<String, Boolean>,
        builderAction: FunSpecBuilder.() -> Unit
    ) {
        add(name) {
            receiver = receiverClass
            returns<String>()
            parameters {
                params.forEach { (name, isNullable) ->
                    add(name, if (isNullable) STRING.asNullable() else STRING) {
                        if (isNullable) {
                            defaultValue("null")
                        }
                    }
                }
            }
            builderAction()
        }
    }
}