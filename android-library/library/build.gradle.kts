import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.android.library)
    kotlin("android") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.maven.publish)
}

android {
    buildFeatures.buildConfig = false
    testOptions.unitTests.isIncludeAndroidResources = true
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01)
    signAllPublications()
    pom(::pomConfig)
    configure(AndroidSingleVariantLibrary())
}

dependencies {
    ktlint(libs.ktlint, ::ktlintConfig)
    ktlint(libs.rulebook.ktlint)
    implementation(libs.kotlinx.coroutines)
    implementation(libs.androidx.appcompat)
    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.bundles.androidx.test)
}

tasks.dokkaHtml {
    outputDirectory.set(buildDir.resolve("dokka/dokka/"))
}
