buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
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
    }
}

subprojects {
    plugins.withType<org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin> {
        extensions.configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension> {
            jvmToolchain {
                (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(8))
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