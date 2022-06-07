group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    kotlin("jvm")
    dokka
    `maven-publish`
    signing
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(8))
    }
}

dependencies {
    api(kotlin("stdlib", VERSION_KOTLIN))
    api(kotlinx("coroutines-core", VERSION_COROUTINES))
    testImplementation(kotlin("test-junit", VERSION_KOTLIN))
    testImplementation(google("truth", version = VERSION_TRUTH))
}

tasks {
    dokkaHtml {
        outputDirectory.set(buildDir.resolve("dokka/dokka"))
    }
}

ktlint()
mavenPublishJvm()