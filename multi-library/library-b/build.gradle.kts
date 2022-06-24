plugins {
    alias(plugs.plugins.kotlin.jvm)
    alias(plugs.plugins.kotlinx.kover)
    alias(plugs.plugins.dokka)
    alias(plugs.plugins.spotless)
    alias(plugs.plugins.mvn.publish)
}

dependencies {
    implementation(libs.kotlinx.coroutines)
    testImplementation(testLibs.kotlin.junit)
    testImplementation(testLibs.truth)
}
