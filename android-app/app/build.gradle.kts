val RELEASE_GROUP: String by project
val RELEASE_ARTIFACT: String by project
val RELEASE_VERSION: String by project

plugins {
    alias(libs.plugins.android.application)
    kotlin("android") version libs.versions.kotlin
    kotlin("kapt") version libs.versions.kotlin
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint)
}

kotlin.jvmToolchain(libs.versions.jdk.get().toInt())

ktlint.version.set(libs.versions.ktlint.get())

android {
    namespace = "$RELEASE_GROUP.$RELEASE_ARTIFACT"
    testNamespace = "$namespace.test"
    compileSdk = libs.versions.sdk.target.get().toInt()
    defaultConfig {
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        version = RELEASE_VERSION
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        applicationId = namespace
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
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    ktlintRuleset(libs.ktlint)
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.multidex)

    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.bundles.androidx.test)
}
