import org.jetbrains.kotlin.gradle.dsl.kotlinExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    dependencies {
        classpath(plugs.pages) { features("pages-minimal") }
    }
}

plugins {
    alias(plugs.plugins.kotlin.jvm) apply false
    alias(plugs.plugins.kotlin.kapt) apply false
}

allprojects {
    group = RELEASE_GROUP
    version = RELEASE_VERSION
    repositories {
        mavenCentral()
    }
}

subprojects {
    withPluginEagerly<KotlinPluginWrapper> {
        kotlinExtension.jvmToolchain {
            (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(sdk.versions.jdk.get()))
        }
    }
}
