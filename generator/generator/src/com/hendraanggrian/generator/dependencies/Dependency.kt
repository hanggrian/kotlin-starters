package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.generator.api.BintrayApi
import com.hendraanggrian.generator.api.GitHubApi
import com.hendraanggrian.generator.api.MavenCentralApi
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
        val map: MutableMap<String, String> = mutableMapOf()
        val DEPENDENCY_HANDLER: ClassName = ClassName("org.gradle.api.artifacts.dsl", "DependencyHandler")
        val PLUGIN_DEPENDENCIES_SPEC: ClassName = ClassName("org.gradle.plugin.use", "PluginDependenciesSpec")
    }

    abstract fun FileSpecBuilder.initialize()

    private fun fetchGitHub(name: String, owner: String, repo: String): Unit = fetch(name) {
        println("Fetching github.com/$owner/$repo...")
        GitHubApi.getLatestRelease(owner, repo)
    }

    private fun fetchMavenCentral(name: String, group: String, artifact: String): Unit = fetch(name) {
        println("Fetching search.maven.org/$group/$artifact")
        MavenCentralApi.getLatestVersion(group, artifact)
    }

    private fun fetchBintray(name: String, subject: String, repo: String, `package`: String): Unit = fetch(name) {
        println("Fetching api.bintray.com/$subject/$repo/$`package`")
        BintrayApi.getLatestVersion(subject, repo, `package`)
    }

    private fun fetch(name: String, getter: suspend () -> String) {
        var version = map[name]
        if (version == null) {
            version = runBlocking { getter() }
            map[name] = version
            println("Saved: $version")
        }
    }

    protected fun PropertySpecContainer.gitHubVal(
        name: String,
        owner: String,
        repo: String,
        isInternal: Boolean = false
    ) {
        fetchGitHub(name, owner, repo)
        newVal(name, isInternal)
    }

    protected fun PropertySpecContainer.mavenCentralVal(
        name: String,
        group: String,
        artifact: String,
        isInternal: Boolean = false
    ) {
        fetchMavenCentral(name, group, artifact)
        newVal(name, isInternal)
    }

    protected fun PropertySpecContainer.bintrayVal(
        name: String,
        subject: String,
        repo: String,
        `package`: String,
        isInternal: Boolean = false
    ) {
        fetchBintray(name, subject, repo, `package`)
        newVal(name, isInternal)
    }

    protected fun FunSpecContainer.dependencyFun(
        name: String,
        vararg params: Pair<String, Boolean>,
        builderAction: FunSpecBuilder.() -> Unit
    ) = newFun(DEPENDENCY_HANDLER, name, *params, builderAction = builderAction)

    protected fun FunSpecContainer.pluginFun(
        name: String,
        vararg params: Pair<String, Boolean>,
        builderAction: FunSpecBuilder.() -> Unit
    ) = newFun(PLUGIN_DEPENDENCIES_SPEC, name, *params, builderAction = builderAction)

    protected fun PropertySpecContainer.pluginVal(
        name: String,
        builderAction: FunSpecBuilder.() -> Unit
    ) {
        add<String>(name) {
            receiver = PLUGIN_DEPENDENCIES_SPEC
            getter {
                addModifiers(KModifier.INLINE)
                builderAction()
            }
        }
    }

    private fun PropertySpecContainer.newVal(
        name: String,
        isInternal: Boolean
    ) {
        add<String>(name, KModifier.CONST) {
            if (isInternal) {
                addModifiers(KModifier.INTERNAL)
            }
            runBlocking {
                initializer("%S", map[name]!!)
            }
        }
    }

    private fun FunSpecContainer.newFun(
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