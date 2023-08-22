val RELEASE_ARTIFACT: String by project

plugins {
    alias(libs.plugins.android.application)
    kotlin("android") version libs.versions.kotlin
    kotlin("kapt") version libs.versions.kotlin
}

android {
    namespace = "com.example"
    testNamespace = "$namespace.test"
    defaultConfig {
        applicationId = namespace
        multiDexEnabled = true
    }
    lint.abortOnError = false
}

dependencies {
    implementation(project(":$RELEASE_ARTIFACT"))
    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.multidex)
}
