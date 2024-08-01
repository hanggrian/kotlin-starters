val releaseArtifact: String by project

plugins {
    kotlin("jvm") version libs.versions.kotlin
    application
}

application.mainClass.set("com.example.App")

dependencies {
    implementation(project(":$releaseArtifact"))
    implementation(project(":$releaseArtifact-extension"))
}
