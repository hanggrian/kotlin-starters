plugins {
    android("library")
    kotlin("android")
    dokka
    `maven-publish`
    signing
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
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        targetCompatibility = JavaVersion.VERSION_11
        sourceCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
    buildFeatures {
        buildConfig = false
    }
}

dependencies {
    api(kotlin("stdlib", VERSION_KOTLIN))
    api(kotlinx("coroutines-core", VERSION_COROUTINES))
    api(androidx("appcompat"))
    androidTestImplementation(kotlin("test-junit", VERSION_KOTLIN))
    androidTestImplementation(androidx("test", "core-ktx", VERSION_ANDROIDX_TEST))
    androidTestImplementation(androidx("test", "runner", VERSION_ANDROIDX_TEST))
    androidTestImplementation(androidx("test", "rules", VERSION_ANDROIDX_TEST))
    androidTestImplementation(androidx("test.ext", "junit-ktx", VERSION_ANDROIDX_JUNIT))
    androidTestImplementation(androidx("test.ext", "truth", VERSION_ANDROIDX_TRUTH))
    androidTestImplementation(androidx("test.espresso", "espresso-core", VERSION_ESPRESSO))
}

tasks {
    dokkaHtml {
        outputDirectory.set(buildDir.resolve("dokka/dokka"))
    }
}

ktlint()
mavenPublishAndroid(sources = android.sourceSets["main"].java.srcDirs)