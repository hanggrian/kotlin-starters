const val SDK_MIN = 14
const val SDK_TARGET = 28

private const val VERSION_ANDROID_PLUGIN = "3.5.0"
const val VERSION_MULTIDEX = "2.0.1"
const val VERSION_ANDROIDX = "1.1.0"
const val VERSION_ESPRESSO = "3.2.0"
const val VERSION_RUNNER = "1.2.0"
const val VERSION_RULES = "1.2.0"

fun Dependencies.android() =
    "com.android.tools.build:gradle:$VERSION_ANDROID_PLUGIN"

fun Plugins.android(submodule: String) =
    id("com.android.$submodule")

fun Dependencies.androidx(
    repository: String,
    module: String = repository,
    version: String = VERSION_ANDROIDX
): String = "androidx.$repository:$module:$version"

fun Dependencies.material(version: String = VERSION_ANDROIDX) =
    "com.google.android.material:material:$version"
