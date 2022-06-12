plugins {
    kotlin("android")
    kotlin("android.extensions")
    id("com.android.application")
}

android {
    compileSdk = sdk.versions.androidTarget.getInt()
    defaultConfig {
        minSdk = sdk.versions.androidMin.getInt()
        targetSdk = sdk.versions.androidTarget.getInt()
        multiDexEnabled = true
        applicationId = "com.example.$RELEASE_ARTIFACT"
    }
    compileOptions {
        targetCompatibility = sdk.versions.jdk.getJavaVersion()
        sourceCompatibility = sdk.versions.jdk.getJavaVersion()
    }
    kotlinOptions {
        jvmTarget = sdk.versions.jdk.get()
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
    implementation(project(":$RELEASE_ARTIFACT"))
    implementation(libs.material)
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.core.ktx)
}
