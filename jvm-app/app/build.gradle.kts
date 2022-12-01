plugins {
    kotlin("jvm") version libs.versions.kotlin
    kotlin("kapt") version libs.versions.kotlin
    application
    alias(libs.plugins.kotlinx.kover)
}

application.mainClass.set("$RELEASE_GROUP.app.MyApp")

kotlin.jvmToolchain(libs.versions.jdk.get().toInt())

dependencies {
    ktlint(libs.ktlint, ::ktlintAttributes)
    ktlint(libs.rulebook.ktlint)
    implementation(libs.kotlinx.coroutines)
    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.truth)
}
