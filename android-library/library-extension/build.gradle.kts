val releaseGroup: String by project
val releaseArtifact: String by project

plugins {
    alias(libs.plugins.android.library)
    kotlin("android") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.dokka.javadoc)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint.gradle)
    alias(libs.plugins.maven.publish)
}

kotlin.explicitApi()

android {
    namespace = "$releaseGroup.$releaseArtifact.ext"
    testNamespace = "$namespace.test"
    buildFeatures.buildConfig = false
    testOptions.unitTests.isIncludeAndroidResources = true
    kotlinOptions {
        jvmTarget = JavaVersion.toVersion(libs.versions.jdk.get()).toString()
    }
}

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(project(":$releaseArtifact"))
    implementation(libs.kotlinx.coroutines)
    implementation(libs.androidx.appcompat)

    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.bundles.junit4)
}
