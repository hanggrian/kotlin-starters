plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

dependencies {
    ktlint(libs.ktlint, ::ktlintAttributes)
    ktlint(libs.lints.ktlint)
    implementation(libs.kotlinx.coroutines)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.truth)
}
