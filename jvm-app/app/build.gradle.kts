plugins {
    application
    alias(plugs.plugins.kotlin.jvm)
    alias(plugs.plugins.kotlin.kapt)
    alias(plugs.plugins.kotlinx.kover)
    alias(plugs.plugins.spotless)
}

application.mainClass.set("$RELEASE_GROUP.app.MyApp")

kotlin.jvmToolchain {
    (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(sdk.versions.jdk.get()))
}

kover.generateReportOnCheck = false

spotless.kotlin {
    ktlint()
}

dependencies {
    implementation(libs.kotlinx.coroutines)
    testImplementation(testLibs.kotlin.junit)
    testImplementation(testLibs.truth)
}
