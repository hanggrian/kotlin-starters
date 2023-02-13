plugins {
    kotlin("jvm") version libs.versions.kotlin
    kotlin("kapt") version libs.versions.kotlin
    application
    alias(libs.plugins.kotlinx.kover)
}

kotlin.jvmToolchain(libs.versions.jdk.get().toInt())

application.mainClass.set("$RELEASE_GROUP.app.MyApp")

dependencies {
    ktlint(libs.ktlint, ::configureKtlint)
    ktlint(libs.rulebook.ktlint)
    implementation(libs.kotlinx.coroutines)
    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.truth)
}
