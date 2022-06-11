import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformAndroidPlugin

buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    dependencies {
        classpath(plugs.kotlin)
        classpath(plugs.android)
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
        google()
    }
}

subprojects {
    afterEvaluate {
        extensions.find<KotlinProjectExtension>()?.jvmToolchain {
            (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(11))
        }
        extensions.find<SpotlessExtension>()?.kotlin {
            ktlint()
        }
    }
}
