import kotlin.String
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.plugin.use.PluginDependenciesSpec

const val VERSION_DOKKA: String = "0.9.18"

fun DependencyHandler.dokka(module: String? = null): String =
    "org.jetbrains.dokka:dokka-${'$'}{module.wrap { \"${'$'}it-\" }}gradle-plugin:${'$'}VERSION_DOKKA"
fun PluginDependenciesSpec.dokka(module: String? = null): String =
    id("org.jetbrains.dokka${'$'}{module.wrap { \"-${'$'}it\" }}")
