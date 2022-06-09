plugins {
    android("library")
    kotlin("android")
    dokka
    spotless
    `gradle-maven-publish`
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

mavenPublishing {
    configure(com.vanniktech.maven.publish.AndroidSingleVariantLibrary())
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlinx("coroutines-core", VERSION_COROUTINES))
    implementation(androidx("appcompat"))
    androidTestImplementation(kotlin("test-junit", VERSION_KOTLIN))
    androidTestImplementation(androidx("test", "core-ktx", VERSION_ANDROIDX_TEST))
    androidTestImplementation(androidx("test", "runner", VERSION_ANDROIDX_TEST))
    androidTestImplementation(androidx("test", "rules", VERSION_ANDROIDX_TEST))
    androidTestImplementation(androidx("test.ext", "junit-ktx", VERSION_ANDROIDX_JUNIT))
    androidTestImplementation(androidx("test.ext", "truth", VERSION_ANDROIDX_TRUTH))
    androidTestImplementation(androidx("test.espresso", "espresso-core", VERSION_ESPRESSO))
}
