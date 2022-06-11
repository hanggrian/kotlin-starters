import com.diffplug.gradle.spotless.SpotlessExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(plugs.kotlin)
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
            (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(8))
        }
        extensions.find<SpotlessExtension>()?.kotlin {
            ktlint()
        }
    }
}
