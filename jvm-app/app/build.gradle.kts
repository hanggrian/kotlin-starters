plugins {
    application
    kotlin("jvm")
    kotlin("kapt")
    id("kover")
    id("com.diffplug.spotless")
}

application.mainClass.set("$RELEASE_GROUP.app.MyApp")

kotlin.jvmToolchain {
    (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(sdk.versions.jdk.get()))
}

kover.generateReportOnCheck = false

spotless.kotlin { ktlint() }

dependencies {
    implementation(libs.kotlinx.coroutines)
    testImplementation(testLibs.kotlin.junit)
    testImplementation(testLibs.truth)
}
