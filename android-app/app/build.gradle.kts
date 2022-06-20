plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("kover")
    id("com.diffplug.spotless")
}

android {
    compileSdk = sdk.versions.androidTarget.getInt()
    defaultConfig {
        minSdk = sdk.versions.androidMin.getInt()
        targetSdk = sdk.versions.androidTarget.getInt()
        version = RELEASE_VERSION
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        applicationId = "$RELEASE_GROUP.$RELEASE_ARTIFACT"
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

kotlin.jvmToolchain {
    (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(sdk.versions.jdk.get()))
}

kover {
    generateReportOnCheck = false
    instrumentAndroidPackage = true
}

spotless.kotlin { ktlint() }

dependencies {
    implementation(libs.material)
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.core.ktx)
    androidTestImplementation(libs.material)
    androidTestImplementation(testLibs.kotlin.junit)
    androidTestImplementation(testLibs.bundles.androidx)
}
