import kotlin.String
import org.gradle.api.artifacts.dsl.DependencyHandler

const val VERSION_KTLINT: String = "0.34.2"

fun DependencyHandler.ktlint(): String = """com.pinterest:ktlint:$VERSION_KTLINT"""