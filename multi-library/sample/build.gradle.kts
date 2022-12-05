plugins {
    application
    kotlin("jvm") version libs.versions.kotlin
    kotlin("kapt") version libs.versions.kotlin
}

application.mainClass.set("com.example.MyApp")

dependencies {
    implementation(project(":$RELEASE_ARTIFACT-a"))
    implementation(project(":$RELEASE_ARTIFACT-b"))
}
