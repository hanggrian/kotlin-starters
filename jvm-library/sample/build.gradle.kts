val releaseArtifact: String by project

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.ktlint.gradle)
    application
}

application.mainClass.set("com.example.App")

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(project(":$releaseArtifact"))
    implementation(project(":$releaseArtifact-extension"))
}
