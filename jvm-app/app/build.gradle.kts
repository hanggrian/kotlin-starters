group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    application
    kotlin("jvm")
    kotlin("kapt")
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(8))
    }
}

application {
    mainClass.set("$RELEASE_GROUP.app.MyApp")
}

dependencies {
    api(kotlin("stdlib", VERSION_KOTLIN))
    api(kotlinx("coroutines-core", VERSION_COROUTINES))
    testImplementation(kotlin("test-junit", VERSION_KOTLIN))
    testImplementation(google("truth", version = VERSION_TRUTH))
}

ktlint()