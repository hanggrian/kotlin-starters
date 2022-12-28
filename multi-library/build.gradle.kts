import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.MavenPublishBasePlugin
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

plugins {
    kotlin("jvm") version libs.versions.kotlin apply false
    kotlin("kapt") version libs.versions.kotlin apply false
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlinx.kover) apply false
    alias(libs.plugins.maven.publish) apply false
}

allprojects {
    group = RELEASE_GROUP
    version = RELEASE_VERSION
}

subprojects {
    plugins.withType<KotlinPluginWrapper> {
        kotlinExtension.jvmToolchain(libs.versions.jdk.get().toInt())
    }
    plugins.withType<MavenPublishBasePlugin> {
        configure<MavenPublishBaseExtension> {
            publishToMavenCentral(SonatypeHost.S01)
            signAllPublications()
            pom(::configurePom)
            configure(KotlinJvm(JavadocJar.Dokka("dokkaJavadoc")))
        }
    }
}

tasks {
    register(LifecycleBasePlugin.CLEAN_TASK_NAME) {
        delete(buildDir)
    }
    dokkaHtmlMultiModule {
        outputDirectory.set(buildDir.resolve("dokka/dokka/"))
    }
}
