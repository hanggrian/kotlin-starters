import org.gradle.jvm.toolchain.JavaLanguageVersion
import org.gradle.kotlin.dsl.apply
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.KtlintPlugin

val releaseGroup: String by project
val releaseVersion: String by project
val releaseArtifact: String by project

val javaCompileVersion = JavaLanguageVersion.of(libs.versions.java.compile.get())
val javaSupportVersion = JavaVersion.toVersion(libs.versions.java.support.get())

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
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.ksp)
    application
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint.gradle)
}

java {
    toolchain.languageVersion.set(javaCompileVersion)
    sourceCompatibility = javaSupportVersion
    targetCompatibility = javaSupportVersion
}

kotlin {
    jvmToolchain {
        languageVersion.set(javaCompileVersion)
    }
    compilerOptions.jvmTarget.set(JvmTarget.fromTarget(javaSupportVersion.toString()))
}

application.mainClass.set("$releaseGroup.$releaseArtifact.App")

ktlint.version.set(libs.versions.ktlint.get())

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(libs.kotlinx.coroutines)
    implementation(libs.dagger)

    ksp(libs.dagger.compiler)

    testImplementation(kotlin("test-junit5", libs.versions.kotlin.get()))
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.junit5)

    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.test {
    useJUnitPlatform()
}
