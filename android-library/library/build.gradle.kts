import com.vanniktech.maven.publish.AndroidSingleVariantLibrary

plugins {
    kotlin("android")
    id("com.android.library")
    id("org.jetbrains.dokka")
    id("com.diffplug.spotless")
    id("com.vanniktech.maven.publish.base")
}

android {
    compileSdk = sdk.versions.target.get().toInt()
    defaultConfig {
        minSdk = sdk.versions.min.get().toInt()
        targetSdk = compileSdk
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
    buildFeatures {
        buildConfig = false
    }
}

mavenPublishing.configure(AndroidSingleVariantLibrary())

dependencies {
    implementation(libs.kotlinx.coroutines)
    implementation(libs.androidx.appcompat)
    androidTestImplementation(testLibs.kotlin.junit)
    androidTestImplementation(testLibs.bundles.androidx)
}
