const val VERSION_KOTLIN = "1.4.30"
const val VERSION_COROUTINES = "1.4.3"

fun Dependencies.kotlinx(module: String, version: String? = null) =
    "org.jetbrains.kotlinx:kotlinx-$module${version?.let { ":$it" }.orEmpty()}"

fun Dependencies.dokka() = "org.jetbrains.dokka:dokka-gradle-plugin:1.4.20"

val Plugins.dokka get() = id("org.jetbrains.dokka")
