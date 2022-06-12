plugins {
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("com.android.application")
    id("com.diffplug.spotless")
}

android {
    compileSdk = sdk.versions.androidTarget.getInt()
    defaultConfig {
        minSdk = sdk.versions.androidMin.getInt()
        targetSdk = sdk.versions.androidTarget.getInt()
        multiDexEnabled = true
        applicationId = "$RELEASE_GROUP.$RELEASE_ARTIFACT"
        version = RELEASE_VERSION
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(libs.material)
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.core.ktx)
    androidTestImplementation(libs.material)
    androidTestImplementation(testLibs.kotlin.junit)
    androidTestImplementation(testLibs.bundles.androidx)
}
