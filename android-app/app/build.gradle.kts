plugins {
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("com.android.application")
    id("com.diffplug.spotless")
}

android {
    compileSdk = sdk.versions.target.get().toInt()
    defaultConfig {
        minSdk = sdk.versions.min.get().toInt()
        targetSdk = compileSdk
        multiDexEnabled = true
        applicationId = "$RELEASE_GROUP.$RELEASE_ARTIFACT"
        version = RELEASE_VERSION
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "${JavaVersion.VERSION_11}"
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
