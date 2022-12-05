plugins {
    application
    kotlin("jvm") version libs.versions.kotlin
    kotlin("kapt") version libs.versions.kotlin
    alias(libs.plugins.kotlinx.kover)
}

application.mainClass.set("$RELEASE_GROUP.app.MyApp")

kotlin.jvmToolchain(libs.versions.jdk.get().toInt())

dependencies {
    ktlint(libs.ktlint, ::ktlintConfig)
    ktlint(libs.rulebook.ktlint)
    implementation(libs.kotlinx.coroutines)
    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.truth)
}
