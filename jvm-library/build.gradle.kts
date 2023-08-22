import com.vanniktech.maven.publish.MavenPublishBaseExtension
import com.vanniktech.maven.publish.MavenPublishBasePlugin
import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.dsl.kotlinExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper

val DEVELOPER_ID: String by project
val DEVELOPER_NAME: String by project
val DEVELOPER_URL: String by project
val RELEASE_GROUP: String by project
val RELEASE_ARTIFACT: String by project
val RELEASE_VERSION: String by project
val RELEASE_DESCRIPTION: String by project
val RELEASE_URL: String by project

plugins {
    kotlin("jvm") version libs.versions.kotlin apply false
    kotlin("kapt") version libs.versions.kotlin apply false
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
            pom {
                name.set(project.name)
                description.set(RELEASE_DESCRIPTION)
                url.set(RELEASE_URL)
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set(DEVELOPER_ID)
                        name.set(DEVELOPER_NAME)
                        url.set(DEVELOPER_URL)
                    }
                }
                scm {
                    url.set(RELEASE_URL)
                    connection.set("scm:git:https://github.com/$DEVELOPER_ID/$RELEASE_ARTIFACT.git")
                    developerConnection.set("scm:git:ssh://git@github.com/$DEVELOPER_ID/$RELEASE_ARTIFACT.git")
                }
            }
        }
    }
}
