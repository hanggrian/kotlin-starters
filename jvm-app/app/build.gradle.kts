import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val releaseGroup: String by project
val releaseArtifact: String by project

val jdkVersion = JavaLanguageVersion.of(libs.versions.jdk.get())
val jreVersion = JavaLanguageVersion.of(libs.versions.jre.get())

plugins {
    kotlin("jvm") version libs.versions.kotlin
    application
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint)
}

kotlin.jvmToolchain(jdkVersion.asInt())

application.mainClass.set("$releaseGroup.$releaseArtifact.App")

ktlint.version.set(libs.versions.ktlint.get())

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(libs.kotlinx.coroutines)

    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.truth)
}

tasks {
    compileJava {
        options.release = jreVersion.asInt()
    }
    compileKotlin {
        compilerOptions.jvmTarget
            .set(JvmTarget.fromTarget(JavaVersion.toVersion(jreVersion).toString()))
    }
}
