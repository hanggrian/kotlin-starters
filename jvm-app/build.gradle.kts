import com.diffplug.gradle.spotless.SpotlessExtension
import kotlinx.kover.api.KoverExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    dependencies {
        classpath(plugs.kotlin)
        classpath(plugs.kotlin.kover)
        classpath(plugs.spotless)
        classpath(plugs.pages) { features("pages-minimal") }
        classpath(plugs.git.publish)
    }
}

allprojects {
    group = RELEASE_GROUP
    version = RELEASE_VERSION
    repositories {
        mavenCentral()
    }
}

subprojects {
    afterEvaluate {
        extensions.find<KotlinProjectExtension>()?.jvmToolchain {
            (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(sdk.versions.jdk.get()))
        }
        extensions.find<KoverExtension> {
            generateReportOnCheck = false
        }
        extensions.find<SpotlessExtension>()?.kotlin {
            ktlint()
        }
    }
}
