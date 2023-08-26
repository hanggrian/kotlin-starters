plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.maven.publish)
}

dependencies {
    ktlintRuleset(libs.ktlint)
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(libs.kotlinx.coroutines.core)

    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.truth)
}
