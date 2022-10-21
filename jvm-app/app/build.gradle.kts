plugins {
    application
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.spotless)
}

application.mainClass.set("$RELEASE_GROUP.app.MyApp")

kotlin.jvmToolchain {
    languageVersion.set(JavaLanguageVersion.of(libs.versions.jdk.get()))
}

spotless.kotlin {
    ktlint()
}

dependencies {
    implementation(libs.kotlinx.coroutines)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.truth)
}
