val releaseArtifact: String by project

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.ktlint.gradle)
}

android {
    namespace = "com.example"
    testNamespace = "$namespace.test"
    defaultConfig {
        applicationId = namespace
        multiDexEnabled = true
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(project(":$releaseArtifact-extension"))
    implementation(libs.kotlinx.coroutines)
    implementation(libs.material)
    implementation(libs.androidx.core.ktx)
    implementation(libs.hilt)

    ksp(libs.hilt.compiler)

    debugImplementation(libs.leakcanary)
}
