plugins {
    android("application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(11))
    }
}

android {
    compileSdk = SDK_TARGET
    defaultConfig {
        minSdk = SDK_MIN
        targetSdk = SDK_TARGET
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
        jvmTarget = JavaVersion.VERSION_11.toString()
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
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(material())
    implementation(androidx("multidex", version = VERSION_MULTIDEX))
    implementation(androidx("core", "core-ktx", "1.4.0-alpha01"))
    androidTestImplementation(material())
    androidTestImplementation(kotlin("test-junit", VERSION_KOTLIN))
    androidTestImplementation(androidx("test", "core-ktx", VERSION_ANDROIDX_TEST))
    androidTestImplementation(androidx("test", "runner", VERSION_ANDROIDX_TEST))
    androidTestImplementation(androidx("test", "rules", VERSION_ANDROIDX_TEST))
    androidTestImplementation(androidx("test.ext", "junit-ktx", VERSION_ANDROIDX_JUNIT))
    androidTestImplementation(androidx("test.ext", "truth", VERSION_ANDROIDX_TRUTH))
    androidTestImplementation(androidx("test.espresso", "espresso-core", VERSION_ESPRESSO))
}

ktlint()