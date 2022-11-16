import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.android.library")
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

android {
    buildFeatures.buildConfig = false
    testOptions.unitTests.isIncludeAndroidResources = true
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01)
    signAllPublications()
    pom(::pom)
    configure(AndroidSingleVariantLibrary())
}

dependencies {
    ktlint(libs.ktlint, ::ktlintAttributes)
    ktlint(libs.lints.ktlint)
    implementation(libs.kotlinx.coroutines)
    implementation(libs.androidx.appcompat)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.bundles.androidx.test)
}

tasks.dokkaHtml {
    outputDirectory.set(buildDir.resolve("dokka/dokka"))
}
