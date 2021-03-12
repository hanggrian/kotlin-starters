const val SDK_MIN = 14
const val SDK_TARGET = 30

const val VERSION_ANDROID_PLUGIN = "4.1.2"
const val VERSION_MULTIDEX = "2.0.1"
const val VERSION_ANDROIDX = "1.2.0"
const val VERSION_ANDROIDX_TEST = "1.2.0"
const val VERSION_ANDROIDX_JUNIT = "1.1.1"
const val VERSION_ANDROIDX_TRUTH = "1.2.0"
const val VERSION_ESPRESSO = "3.2.0"

fun org.gradle.api.artifacts.dsl.DependencyHandler.android() =
    "com.android.tools.build:gradle:$VERSION_ANDROID_PLUGIN"

fun org.gradle.plugin.use.PluginDependenciesSpec.android(submodule: String) =
    id("com.android.$submodule")

fun org.gradle.api.artifacts.dsl.DependencyHandler.androidx(
    repository: String,
    module: String = repository,
    version: String = VERSION_ANDROIDX
) = "androidx.$repository:$module:$version"

fun org.gradle.api.artifacts.dsl.DependencyHandler.material(version: String = VERSION_ANDROIDX) =
    "com.google.android.material:material:$version"
