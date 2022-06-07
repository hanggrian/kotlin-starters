group = "com.example"
version = "1.0"

plugins {
    application
    kotlin("jvm")
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(8))
    }
}

application {
    mainClass.set("com.example.MyApp")
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(project(":$RELEASE_ARTIFACT-a"))
    implementation(project(":$RELEASE_ARTIFACT-b"))
}