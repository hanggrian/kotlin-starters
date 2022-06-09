group = "com.example"
version = "1.0"

plugins {
    application
    kotlin("jvm")
}

application {
    mainClass.set("com.example.MyApp")
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(project(":$RELEASE_ARTIFACT"))
}