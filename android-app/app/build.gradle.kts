plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.android.extensions)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlinx.kover)
}

android {
    compileSdk = libs.versions.android.target.get().toInt()
    defaultConfig {
        minSdk = libs.versions.android.min.get().toInt()
        targetSdk = libs.versions.android.target.get().toInt()
        version = RELEASE_VERSION
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        applicationId = "$RELEASE_GROUP.$RELEASE_ARTIFACT"
    }
    compileOptions {
        targetCompatibility = JavaVersion.toVersion(libs.versions.android.jdk.get())
        sourceCompatibility = JavaVersion.toVersion(libs.versions.android.jdk.get())
    }
    kotlinOptions {
        jvmTarget = JavaVersion.toVersion(libs.versions.android.jdk.get()).toString()
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
    testOptions.unitTests.isIncludeAndroidResources = true
}

kotlin.jvmToolchain(libs.versions.jdk.get().toInt())

dependencies {
    ktlint(libs.ktlint, ::ktlintAttributes)
    ktlint(libs.lints.ktlint)
    implementation(libs.material)
    implementation(libs.androidx.multidex)
    implementation(libs.androidx.core.ktx)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.bundles.androidx.test)
}
