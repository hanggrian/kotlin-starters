import kotlin.String
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.plugin.use.PluginDependenciesSpec

const val VERSION_GIT_PUBLISH: String = "2.1.1"

fun DependencyHandler.gitPublish(): String =
    """org.ajoberstar:gradle-git-publish:$VERSION_GIT_PUBLISH"""
val PluginDependenciesSpec.`git-publish`: String
  inline get() = id("org.ajoberstar.git-publish")