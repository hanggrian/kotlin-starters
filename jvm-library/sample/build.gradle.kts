plugins {
    application
    kotlin("jvm")
}

application.mainClass.set("com.example.MyApp")

dependencies {
    implementation(project(":$RELEASE_ARTIFACT"))
}
