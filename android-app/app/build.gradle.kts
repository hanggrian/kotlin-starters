plugins {
    id("com.android.application")
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.android.extensions)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.spotless)
}

android {
    compileSdk = libs.versions.sdkTarget.get().toInt()
    defaultConfig {
        minSdk = libs.versions.sdkMin.get().toInt()
        targetSdk = libs.versions.sdkTarget.get().toInt()
        version = RELEASE_VERSION
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        applicationId = "$RELEASE_GROUP.$RELEASE_ARTIFACT"
    }
    compileOptions {
        targetCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
    }
    kotlinOptions {
        jvmTarget = JavaVersion.toVersion(libs.versions.jdk.get()).toString()
    }
    buildTypes {
        debug {
            enableAndroidTestCoverage = true
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

kotlin.jvmToolchain {
    languageVersion.set(JavaLanguageVersion.of(libs.versions.jdk.get()))
}

spotless.kotlin {
    ktlint()
}

dependencies {
    implementation(libs.material)
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.core.ktx)
    androidTestImplementation(libs.material)
    androidTestImplementation(libs.kotlin.test.junit)
    androidTestImplementation(libs.bundles.androidx.test)
}
