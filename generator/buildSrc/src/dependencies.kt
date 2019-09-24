import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.plugin.use.PluginDependenciesSpec

fun DependencyHandler.ktor(module: String) = "io.ktor:ktor-$module:$VERSION_KTOR"

fun DependencyHandler.kotlinPoetKTX() = "com.hendraanggrian:kotlinpoet-ktx:$VERSION_KOTLINPOET_KTX"

fun DependencyHandler.gitPublish() = "org.ajoberstar:gradle-git-publish:$VERSION_GIT_PUBLISH"
inline val PluginDependenciesSpec.`git-publish` get() = id("org.ajoberstar.git-publish")

fun DependencyHandler.ktlint() = "com.pinterest:ktlint:$VERSION_KTLINT"

private fun String?.wrap(wrapper: (String) -> String) = this?.let(wrapper).orEmpty()
