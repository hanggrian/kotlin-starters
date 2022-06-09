plugins {
    kotlin("jvm")
    dokka
    spotless
    `gradle-maven-publish`
}

mavenPublishing {
    configure(
        com.vanniktech.maven.publish.JavaLibrary(
            com.vanniktech.maven.publish.JavadocJar.Dokka("dokkaJavadoc")
        )
    )
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlinx("coroutines-core", VERSION_COROUTINES))
    testImplementation(kotlin("test-junit", VERSION_KOTLIN))
    testImplementation(google("truth", version = VERSION_TRUTH))
}