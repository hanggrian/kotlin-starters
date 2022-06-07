internal typealias Plugins = org.gradle.plugin.use.PluginDependenciesSpec
internal typealias Dependencies = org.gradle.api.artifacts.dsl.DependencyHandler

const val VERSION_KOTLIN = "1.6.21"
const val VERSION_COROUTINES = "1.6.2"
val Dependencies.dokka get() = "org.jetbrains.dokka:dokka-gradle-plugin:$VERSION_KOTLIN"
val Plugins.dokka get() = id("org.jetbrains.dokka")
fun Dependencies.kotlinx(module: String, version: String? = null) =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$it" }.orEmpty()}"

const val VERSION_TRUTH = "1.1.3"
fun Dependencies.google(module: String, version: String) = "com.google.$module:$module:$version"

val Dependencies.minimal get() = "com.hendraanggrian.pages:minimal:0.1"
val Plugins.minimal get() = id("com.hendraanggrian.pages.minimal")

val Dependencies.`git-publish` get() = "org.ajoberstar.git-publish:gradle-git-publish:3.0.1"
val Plugins.`git-publish` get() = id("org.ajoberstar.git-publish")