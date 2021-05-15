group = "com.example"
version = "1.0"

plugins {
    application
    kotlin("jvm")
}

application {
    mainClass.set("com.example.MyApp")
}

sourceSets {
    main {
        java.srcDir("src")
        resources.srcDir("res")
    }
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(project(":$RELEASE_ARTIFACT"))
}