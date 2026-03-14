import com.vanniktech.maven.publish.JavadocJar
import com.vanniktech.maven.publish.KotlinJvm
import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.MavenPublishBasePlugin
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.KtlintPlugin

val developerId: String by project
val developerName: String by project
val developerUrl: String by project
val releaseGroup: String by project
val releaseArtifact: String by project
val releaseVersion: String by project
val releaseDescription: String by project
val releaseUrl: String by project

val javaCompileVersion = JavaLanguageVersion.of(libs.versions.java.compile.get())
val javaSupportVersion = JavaVersion.toVersion(libs.versions.java.support.get())

plugins {
    kotlin("jvm") version libs.versions.kotlin apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.ktlint.gradle)
    alias(libs.plugins.maven.publish) apply false
}

allprojects {
    group = releaseGroup
    version = releaseVersion

    plugins.apply(KtlintPlugin::class)

    afterEvaluate {
        the<KtlintExtension>().version.set(libs.versions.ktlint.get())

        dependencies.ktlintRuleset(libs.rulebook.ktlint)
    }
}

subprojects {
    plugins.withType<KotlinPluginWrapper>().configureEach {
        configure<JavaPluginExtension> {
            toolchain.languageVersion.set(javaCompileVersion)
            sourceCompatibility = javaSupportVersion
            targetCompatibility = javaSupportVersion
        }
        configure<KotlinJvmProjectExtension> {
            jvmToolchain {
                languageVersion.set(javaCompileVersion)
            }
            compilerOptions.jvmTarget.set(JvmTarget.fromTarget(javaSupportVersion.toString()))
        }
    }
    plugins.withType<MavenPublishBasePlugin> {
        configure<MavenPublishBaseExtension> {
            configure(KotlinJvm(JavadocJar.Dokka("dokkaGeneratePublicationJavadoc")))
            publishToMavenCentral()
            signAllPublications()
            pom {
                name.set(project.name)
                description.set(releaseDescription)
                url.set(releaseUrl)
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set(developerId)
                        name.set(developerName)
                        url.set(developerUrl)
                    }
                }
                scm {
                    url.set(releaseUrl)
                    connection.set("scm:git:https://github.com/$developerId/$releaseArtifact.git")
                    developerConnection
                        .set("scm:git:ssh://git@github.com/$developerId/$releaseArtifact.git")
                }
            }
        }
    }

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}
