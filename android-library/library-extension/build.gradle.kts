val releaseGroup: String by project
val releaseArtifact: String by project

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.dokka)
    alias(libs.plugins.dokka.javadoc)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.maven.publish)
}

kotlin.explicitApi()

android {
    namespace = "$releaseGroup.$releaseArtifact.ext"
    testNamespace = "$namespace.test"
    testOptions.unitTests.isIncludeAndroidResources = true
    buildTypes {
        debug {
            enableAndroidTestCoverage = true
        }
    }
}

dependencies {
    api(project(":$releaseArtifact"))

    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.bundles.junit4)
}
