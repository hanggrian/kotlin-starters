plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.gradle.publish)
}

kotlin.jvmToolchain(libs.versions.jdk.get().toInt())

gradlePlugin {
    website.set(RELEASE_URL)
    vcsUrl.set("$RELEASE_URL.git")
    plugins.register("myPlugin") {
        id = "$RELEASE_GROUP.$RELEASE_ARTIFACT"
        displayName = "My Plugin"
        description = RELEASE_DESCRIPTION
        tags.set(listOf("hello", "world"))
        implementationClass = "$id.MyPlugin"
    }
    testSourceSets(sourceSets.test.get())
}

dependencies {
    ktlint(libs.ktlint, ::configureKtlint)
    ktlint(libs.rulebook.ktlint)
    compileOnly(kotlin("gradle-plugin-api"))
    implementation(gradleKotlinDsl())
    implementation(libs.kotlinx.coroutines)
    testImplementation(gradleTestKit())
    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.truth)
}

tasks.dokkaHtml {
    outputDirectory.set(buildDir.resolve("dokka/dokka/"))
}
