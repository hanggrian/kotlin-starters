plugins {
    kotlin("android")
    kotlin("android.extensions")
    id("com.android.application")
}

android {
    compileSdk = sdk.versions.target.get().toInt()
    defaultConfig {
        minSdk = sdk.versions.min.get().toInt()
        targetSdk = compileSdk
        multiDexEnabled = true
        applicationId = "com.example.$RELEASE_ARTIFACT"
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
