plugins {
    application
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlinx.kover)
}

application.mainClass.set("$RELEASE_GROUP.app.MyApp")

kotlin.jvmToolchain(libs.versions.jdk.get().toInt())

dependencies {
    ktlint(libs.ktlint, ::ktlintAttributes)
    ktlint(libs.lints.ktlint)
    implementation(libs.kotlinx.coroutines)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.truth)
}
