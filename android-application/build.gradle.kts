import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.KtlintPlugin

val releaseGroup: String by project
val releaseArtifact: String by project
val releaseVersion: String by project

val javaCompileVersion = JavaLanguageVersion.of(libs.versions.java.compile.get())
val javaSupportVersion = JavaVersion.toVersion(libs.versions.java.support.get())

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint.gradle)
}

allprojects {
    group = releaseGroup
    version = releaseVersion

    plugins.apply(KtlintPlugin::class)

    afterEvaluate {
        the<KtlintExtension>().version.set(libs.versions.ktlint.get())

        dependencies.ktlintRuleset(libs.rulebook.ktlint)
    }
}

kotlin.jvmToolchain(javaCompileVersion.asInt())

android {
    namespace = "$releaseGroup.$releaseArtifact"
    testNamespace = "$namespace.test"
    compileSdk = libs.versions.android.compile.get().toInt()
    defaultConfig {
        targetSdk = libs.versions.android.compile.get().toInt()
        minSdk = libs.versions.android.support.get().toInt()
        versionName = releaseVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        applicationId = namespace
    }
    compileOptions {
        sourceCompatibility = javaSupportVersion
        targetCompatibility = javaSupportVersion
    }
    buildTypes {
        debug {
            enableAndroidTestCoverage = true
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    testOptions.unitTests.isIncludeAndroidResources = true
}

dependencies {
    implementation(libs.kotlinx.coroutines)
    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt)

    ksp(libs.hilt.compiler)

    debugImplementation(libs.leakcanary)

    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.bundles.junit4)
}
