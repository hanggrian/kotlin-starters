import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val releaseGroup: String by project
val releaseArtifact: String by project
val releaseVersion: String by project

val javaCompileVersion = JavaLanguageVersion.of(libs.versions.java.compile.get())
val javaSupportVersion = JavaLanguageVersion.of(libs.versions.java.support.get())

allprojects {
    group = releaseGroup
    version = releaseVersion
}

plugins {
    alias(libs.plugins.android.application)
    kotlin("android") version libs.versions.kotlin
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint.gradle)
}

kotlin.jvmToolchain(javaCompileVersion.asInt())

ktlint.version.set(libs.versions.ktlint.get())

android {
    namespace = "$releaseGroup.$releaseArtifact"
    testNamespace = "$namespace.test"
    compileSdk = libs.versions.android.compile.get().toInt()
    defaultConfig {
        targetSdk = libs.versions.android.compile.get().toInt()
        minSdk = libs.versions.android.support.get().toInt()
        version = releaseVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        applicationId = namespace
    }
    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(javaSupportVersion)
        targetCompatibility = JavaVersion.toVersion(javaSupportVersion)
    }
    kotlinOptions {
        jvmTarget = JavaVersion.toVersion(javaSupportVersion).toString()
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
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(libs.kotlinx.coroutines)

    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.multidex)

    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.bundles.junit4)
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions.jvmTarget
        .set(JvmTarget.fromTarget(JavaVersion.toVersion(javaSupportVersion).toString()))
}
