plugins {
    id("com.android.application")
    alias(plugs.plugins.kotlin.android)
    alias(plugs.plugins.kotlin.android.extensions)
    alias(plugs.plugins.kotlin.kapt)
    alias(plugs.plugins.kotlinx.kover)
    alias(plugs.plugins.spotless)
}

android {
    compileSdk = sdk.versions.androidTarget.get().toInt()
    defaultConfig {
        minSdk = sdk.versions.androidMin.get().toInt()
        targetSdk = sdk.versions.androidTarget.get().toInt()
        version = RELEASE_VERSION
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        applicationId = "$RELEASE_GROUP.$RELEASE_ARTIFACT"
    }
    compileOptions {
        targetCompatibility = JavaVersion.toVersion(sdk.versions.androidJdk.get())
        sourceCompatibility = JavaVersion.toVersion(sdk.versions.androidJdk.get())
    }
    kotlinOptions {
        jvmTarget = JavaVersion.toVersion(sdk.versions.androidJdk.get()).toString()
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
