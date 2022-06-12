import com.vanniktech.maven.publish.AndroidSingleVariantLibrary

plugins {
    kotlin("android")
    id("kover")
    id("com.android.library")
    id("org.jetbrains.dokka")
    id("com.diffplug.spotless")
    id("com.vanniktech.maven.publish.base")
}

android {
    compileSdk = sdk.versions.androidTarget.getInt()
    defaultConfig {
        minSdk = sdk.versions.androidMin.getInt()
        targetSdk = sdk.versions.androidTarget.getInt()
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
