import org.gradle.api.artifacts.ModuleDependency

internal typealias Plugins = org.gradle.plugin.use.PluginDependenciesSpec

fun ModuleDependency.features(vararg capabilityModules: Any) =
    capabilities { capabilityModules.forEach { requireCapability("$group:$it") } }

const val SDK_MIN = 14
const val SDK_TARGET = 32
const val VERSION_MULTIDEX = "2.0.1"
const val VERSION_ANDROIDX = "1.4.0"
const val VERSION_ANDROIDX_TEST = "1.4.0"
const val VERSION_ANDROIDX_JUNIT = "1.1.3"
const val VERSION_ANDROIDX_TRUTH = "1.4.0"
const val VERSION_ESPRESSO = "3.4.0"
val Dependencies.android get() = "com.android.tools.build:gradle:7.2.1"
fun Plugins.android(submodule: String) = id("com.android.$submodule")
fun Dependencies.material(version: String = VERSION_ANDROIDX) = "com.google.android.material:material:$version"
fun Dependencies.androidx(repo: String, module: String = repo, version: String = VERSION_ANDROIDX) =
    "androidx.$repo:$module:$version"

const val VERSION_KOTLIN = "1.6.21"
const val VERSION_COROUTINES = "1.6.2"
val Dependencies.dokka get() = "org.jetbrains.dokka:dokka-gradle-plugin:$VERSION_KOTLIN"
val Plugins.dokka get() = id("org.jetbrains.dokka")
fun Dependencies.kotlinx(module: String, version: String? = null) =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$it" }.orEmpty()}"

val Dependencies.spotless get() = "com.diffplug.spotless:spotless-plugin-gradle:6.7.0"
val Plugins.spotless get() = id("com.diffplug.spotless")

val Dependencies.pages get() = "com.hendraanggrian:pages-gradle-plugin:0.1"
val Plugins.pages get() = id("com.hendraanggrian.pages")

val Dependencies.`git-publish` get() = "org.ajoberstar.git-publish:gradle-git-publish:3.0.1"
val Plugins.`git-publish` get() = id("org.ajoberstar.git-publish")
