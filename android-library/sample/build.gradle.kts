plugins {
    id("com.android.application")
    alias(plugs.plugins.kotlin.android)
    alias(plugs.plugins.kotlin.android.extensions)
    alias(plugs.plugins.kotlin.kapt)
}

android {
    defaultConfig {
        applicationId = "com.example"
        multiDexEnabled = true
    }
    buildTypes {
        named("debug") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        named("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    lint {
        abortOnError = false
    }
}

dependencies {
    api(project(":$RELEASE_ARTIFACT"))
    implementation(libs.material)
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.core.ktx)
}
