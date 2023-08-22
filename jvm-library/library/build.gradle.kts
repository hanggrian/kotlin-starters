import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm

plugins {
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.maven.publish)
}

ktlint.version.set(libs.versions.ktlint.get())

mavenPublishing.configure(KotlinJvm(JavadocJar.Dokka("dokkaJavadoc")))

dependencies {
    ktlintRuleset(libs.ktlint)
    ktlintRuleset(libs.rulebook.ktlint)

    implementation(libs.kotlinx.coroutines)

    testImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    testImplementation(libs.truth)
}

tasks.dokkaHtml {
    outputDirectory.set(buildDir.resolve("dokka/dokka/"))
}
