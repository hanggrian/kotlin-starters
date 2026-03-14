val releaseArtifact: String by project

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.ksp)
    application
}

application.mainClass.set("com.example.App")

dependencies {
    implementation(project(":$releaseArtifact-extension"))
    implementation(libs.kotlinx.coroutines)
    implementation(libs.dagger)

    ksp(libs.dagger.compiler)
}
