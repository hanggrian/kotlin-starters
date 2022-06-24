plugins {
    application
    alias(plugs.plugins.kotlin.jvm)
    alias(plugs.plugins.kotlin.kapt)
}

application.mainClass.set("com.example.MyApp")

dependencies {
    implementation(project(":$RELEASE_ARTIFACT"))
}
