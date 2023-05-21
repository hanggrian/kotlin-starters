import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import org.gradle.api.artifacts.ModuleDependency
import org.gradle.api.attributes.Bundling
import org.gradle.api.tasks.JavaExec
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.registering
import org.gradle.language.base.plugins.LifecycleBasePlugin

val Project.ktlint: Configuration
    get() {
        var ktlint = configurations.findByName("ktlint")
        if (ktlint == null) {
            ktlint = configurations.create("ktlint")
            tasks {
                val ktlintCheck by registering(JavaExec::class) {
                    group = LifecycleBasePlugin.VERIFICATION_GROUP
                    description = "Check Kotlin code style."
                    classpath = ktlint
                    mainClass.set("com.pinterest.ktlint.Main")
                    args(
                        "**/src/**/*.kt",
                        "**.kts",
                        "!**/build/**",
                    )
                }
                named("check") {
                    dependsOn(ktlintCheck)
                }
                register<JavaExec>("ktlintFormat") {
                    group = LifecycleBasePlugin.VERIFICATION_GROUP
                    description = "Check Kotlin code style and format"
                    classpath = ktlint
                    mainClass.set("com.pinterest.ktlint.Main")
                    jvmArgs("--add-opens=java.base/java.lang=ALL-UNNAMED")
                    args(
                        "-F",
                        "**/src/**/*.kt",
                        "**.kts",
                        "!**/build/**",
                    )
                }
            }
        }
        return ktlint
    }

fun Project.configureKtlint(dependency: ModuleDependency) {
    dependency.attributes {
        attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
    }
}
