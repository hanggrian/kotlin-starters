buildscript {
    repositories {
        mavenCentral()
        maven(REPOSITORIES_GIT_PUBLISH)
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(gitPublish())
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