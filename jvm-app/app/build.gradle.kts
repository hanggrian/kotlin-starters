plugins {
    application
    kotlin("jvm")
    kotlin("kapt")
    id("com.diffplug.spotless")
}

application.mainClass.set("$RELEASE_GROUP.app.MyApp")

dependencies {
    implementation(libs.kotlinx.coroutines)
    testImplementation(testLibs.kotlin.junit)
    testImplementation(testLibs.truth)
}
