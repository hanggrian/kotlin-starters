buildscript {
    repositories {
        mavenCentral()
        maven(REPOSITORIES_GIT_PUBLISH)
        maven(REPOSITORIES_GRADLE_PORTAL)
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(dokka())
        classpath(gitPublish())
        classpath(gradlePublish())
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
    tasks {
        withType<Delete> {
            delete(projectDir.resolve("out"))
        }
    }
}