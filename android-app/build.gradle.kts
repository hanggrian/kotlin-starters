buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    dependencies {
        classpath(android)
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(spotless)
        classpath(pages) { features("pages-minimal") }
        classpath(`git-publish`)
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
    plugins.withType<org.jetbrains.kotlin.gradle.plugin.KotlinPlatformAndroidPlugin> {
        extensions.configure<org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension> {
            jvmToolchain {
                (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(11))
            }
        }
    }
    plugins.withType<com.diffplug.gradle.spotless.SpotlessPlugin> {
        extensions.configure<com.diffplug.gradle.spotless.SpotlessExtension> {
            kotlin {
                ktlint()
            }
        }
    }
}