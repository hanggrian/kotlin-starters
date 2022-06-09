plugins {
    application
    kotlin("jvm")
    kotlin("kapt")
    spotless
}

application {
    mainClass.set("$RELEASE_GROUP.app.MyApp")
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlinx("coroutines-core", VERSION_COROUTINES))
    testImplementation(kotlin("test-junit", VERSION_KOTLIN))
    testImplementation(google("truth", version = VERSION_TRUTH))
}