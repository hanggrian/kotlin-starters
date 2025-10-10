import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val releaseGroup: String by project
val releaseVersion: String by project
val releaseArtifact: String by project

val javaCompileVersion = JavaLanguageVersion.of(libs.versions.java.compile.get())
val javaSupportVersion = JavaLanguageVersion.of(libs.versions.java.support.get())

allprojects {
    group = releaseGroup
    version = releaseVersion
}

plugins {
    kotlin("jvm") version libs.versions.kotlin
    application
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint.gradle)
}

kotlin.jvmToolchain(javaCompileVersion.asInt())

application.mainClass.set("$releaseGroup.$releaseArtifact.App")

ktlint.version.set(libs.versions.ktlint.get())

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(libs.kotlinx.coroutines)

    testImplementation(kotlin("test-junit5", libs.versions.kotlin.get()))
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.junit5)

    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks {
    compileJava {
        options.release = javaSupportVersion.asInt()
    }
    compileKotlin {
        compilerOptions.jvmTarget
            .set(JvmTarget.fromTarget(JavaVersion.toVersion(javaSupportVersion).toString()))
    }
    test {
        useJUnitPlatform()
    }
}
