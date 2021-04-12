buildscript {
    repositories {
        google()
        mavenCentral()
        maven(REPOSITORIES_GIT_PUBLISH)
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(android())
        classpath(gitPublish())
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}