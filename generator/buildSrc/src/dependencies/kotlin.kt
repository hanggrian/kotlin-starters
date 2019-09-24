import org.gradle.api.artifacts.dsl.DependencyHandler

const val VERSION_KOTLIN: String = "1.3.50"

const val VERSION_COROUTINES: String = "1.3.1"

fun DependencyHandler.kotlinx(module: String, version: String? = null): String =
    "org.jetbrains.kotlinx:kotlinx-${'$'}module${'$'}{version?.let { \":${'$'}it\" } ?: \"\" }\""