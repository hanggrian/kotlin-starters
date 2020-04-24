plugins {
    application
    kotlin("jvm")
}

application.mainClassName = "com.example.MyApp"

sourceSets.getByName("main") {
    java.srcDir("src")
    resources.srcDir("res")
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(project(":$RELEASE_ARTIFACT"))
}
