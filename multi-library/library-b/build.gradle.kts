import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm

plugins {
    kotlin("jvm")
    id("kover")
    id("org.jetbrains.dokka")
    id("com.diffplug.spotless")
    id("com.vanniktech.maven.publish.base")
}

mavenPublishing.configure(KotlinJvm(JavadocJar.Dokka("dokkaJavadoc")))

dependencies {
    implementation(libs.kotlinx.coroutines)
    testImplementation(testLibs.kotlin.junit)
    testImplementation(testLibs.truth)
}
