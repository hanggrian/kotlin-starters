import org.jetbrains.kotlin.gradle.dsl.JvmTarget

val developerId: String by project
val releaseArtifact: String by project
val releaseGroup: String by project
val releaseDescription: String by project
val releaseUrl: String by project

val jdkVersion = JavaLanguageVersion.of(libs.versions.jdk.get())
val jreVersion = JavaLanguageVersion.of(libs.versions.jre.get())

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.ktlint.gradle)
    alias(libs.plugins.gradle.publish)
}

kotlin.jvmToolchain(jdkVersion.asInt())

ktlint.version.set(libs.versions.ktlint.get())

gradlePlugin {
    website.set(releaseUrl)
    vcsUrl.set("https://github.com/$developerId/$releaseArtifact.git")
    plugins.register("myPlugin") {
        id = "$releaseGroup.$releaseArtifact"
        implementationClass = "$releaseGroup.$releaseArtifact.MyPlugin"
        displayName = "My Plugin"
        description = releaseDescription
        tags.set(listOf("first-tag", "second-tag"))
    }
    testSourceSets(sourceSets.test.get())
}

dependencies {
    ktlintRuleset(libs.rulebook.ktlint)

    compileOnly(kotlin("gradle-plugin-api"))

    implementation(gradleKotlinDsl())

    testImplementation(gradleTestKit())
    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.bundles.junit4)
}

tasks {
    compileJava {
        options.release = jreVersion.asInt()
    }
    compileKotlin {
        compilerOptions.jvmTarget
            .set(JvmTarget.fromTarget(JavaVersion.toVersion(jreVersion).toString()))
    }
}
