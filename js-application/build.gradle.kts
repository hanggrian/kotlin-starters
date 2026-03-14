import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.KtlintPlugin

val releaseGroup: String by project
val releaseVersion: String by project

allprojects {
    group = releaseGroup
    version = releaseVersion

    plugins.apply(KtlintPlugin::class)

    afterEvaluate {
        the<KtlintExtension>().version.set(libs.versions.ktlint.get())

        dependencies.ktlintRuleset(libs.rulebook.ktlint)
    }
}

plugins {
    kotlin("multiplatform") version libs.versions.kotlin
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint.gradle)
}

kotlin {
    js {
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
    }
    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jsMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react:2026.3.10-19.2.4")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:2026.3.10-19.2.4")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:2025.3.26")
            }
        }
        val jsTest by getting
    }
}
