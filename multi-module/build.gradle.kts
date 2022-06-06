import org.jetbrains.dokka.gradle.DokkaMultiModuleTask
import org.jetbrains.dokka.gradle.DokkaPlugin

buildscript {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(dokka)
        classpath(minimal)
        classpath(`git-publish`)
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}

plugins.apply(DokkaPlugin::class)

tasks {
    register("clean") {
        delete(buildDir)
    }
    named<DokkaMultiModuleTask>("dokkaHtmlMultiModule") {
        outputDirectory.set(buildDir.resolve("dokka/dokka"))
    }
}