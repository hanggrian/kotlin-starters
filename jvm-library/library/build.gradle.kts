plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.dokka.javadoc)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint.gradle)
    alias(libs.plugins.maven.publish)
}

kotlin.explicitApi()

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(libs.kotlinx.coroutines)

    testImplementation(kotlin("test-junit5", libs.versions.kotlin.get()))
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.bundles.junit5)

    testRuntimeOnly(libs.junit.platform.launcher)
}
