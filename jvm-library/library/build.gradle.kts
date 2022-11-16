import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.dokka)
    alias(libs.plugins.maven.publish)
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01)
    signAllPublications()
    pom(::pom)
    configure(KotlinJvm(JavadocJar.Dokka("dokkaJavadoc")))
}

dependencies {
    ktlint(libs.ktlint, ::ktlintAttributes)
    ktlint(libs.lints.ktlint)
    implementation(libs.kotlinx.coroutines)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.truth)
}

tasks.dokkaHtml {
    outputDirectory.set(buildDir.resolve("dokka/dokka"))
}
