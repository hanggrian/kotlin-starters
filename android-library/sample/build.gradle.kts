plugins {
    id("com.android.application")
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.android.extensions)
    alias(libs.plugins.kotlin.kapt)
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
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.core.ktx)
}
