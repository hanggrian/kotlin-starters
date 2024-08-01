val developerId: String by project
val developerName: String by project
val developerUrl: String by project
val releaseGroup: String by project
val releaseArtifact: String by project
val releaseVersion: String by project
val releaseDescription: String by project
val releaseUrl: String by project

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    kotlin("android") version libs.versions.kotlin apply false
    alias(libs.plugins.dokka)
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.maven.publish) apply false
}

allprojects {
    group = releaseGroup
    version = releaseVersion
}

subprojects {
    plugins.withType<com.android.build.gradle.LibraryPlugin>().configureEach {
        modify(the<com.android.build.gradle.LibraryExtension>())
    }
    plugins.withType<com.android.build.gradle.AppPlugin>().configureEach {
        modify(the<com.android.build.gradle.internal.dsl.BaseAppModuleExtension>())
    }
    plugins.withType<org.jetbrains.kotlin.gradle.plugin.KotlinAndroidPluginWrapper>()
        .configureEach {
            the<org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension>()
                .jvmToolchain(libs.versions.jdk.get().toInt())
        }
    plugins.withType<org.jlleitschuh.gradle.ktlint.KtlintPlugin>().configureEach {
        the<org.jlleitschuh.gradle.ktlint.KtlintExtension>()
            .version.set(libs.versions.ktlint.get())
    }
    plugins.withType<com.vanniktech.maven.publish.MavenPublishBasePlugin> {
        configure<com.vanniktech.maven.publish.MavenPublishBaseExtension> {
            configure(com.vanniktech.maven.publish.AndroidSingleVariantLibrary())
            publishToMavenCentral(com.vanniktech.maven.publish.SonatypeHost.CENTRAL_PORTAL)
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
                    developerConnection.set("scm:git:ssh://git@github.com/$developerId/$releaseArtifact.git")
                }
            }
        }
    }
}

tasks {
    register(LifecycleBasePlugin.CLEAN_TASK_NAME) {
        delete(layout.buildDirectory)
    }
    dokkaHtmlMultiModule {
        outputDirectory.set(layout.buildDirectory.dir("dokka/dokka/"))
    }
}

fun modify(extension: com.android.build.gradle.BaseExtension) {
    extension.setCompileSdkVersion(libs.versions.sdk.target.get().toInt())
    extension.defaultConfig {
        minSdk = libs.versions.sdk.min.get().toInt()
        targetSdk = libs.versions.sdk.target.get().toInt()
        version = releaseVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    extension.compileOptions {
        targetCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jdk.get())
    }
}
