plugins {
    alias(libs.plugins.android.application)
    kotlin("android") version libs.versions.kotlin
    kotlin("android.extensions") version libs.versions.kotlin
    kotlin("kapt") version libs.versions.kotlin
}

android {
    defaultConfig {
        applicationId = "com.example"
        multiDexEnabled = true
    }
    lint.abortOnError = false
}

dependencies {
    api(project(":$RELEASE_ARTIFACT"))
    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.multidex)
}
