val RELEASE_ARTIFACT: String by project

plugins {
    kotlin("jvm") version libs.versions.kotlin
    application
}

application.mainClass.set("com.example.App")

dependencies {
    implementation(project(":$RELEASE_ARTIFACT-extension"))
}
