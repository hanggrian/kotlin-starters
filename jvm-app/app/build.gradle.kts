group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    application
    kotlin("jvm")
    kotlin("kapt")
}

application {
    mainClass.set("$RELEASE_GROUP.$RELEASE_ARTIFACT.MyApp")
}

sourceSets {
    main {
        java.srcDir("src")
        resources.srcDir("res")
    }
    test {
        java.srcDir("tests/src")
        resources.srcDir("tests/res")
    }
}

dependencies {
    api(kotlin("stdlib", VERSION_KOTLIN))
    api(kotlinx("coroutines-core", VERSION_COROUTINES))
    testImplementation(kotlin("test-junit", VERSION_KOTLIN))
}

ktlint()