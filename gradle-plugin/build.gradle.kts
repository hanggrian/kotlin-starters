buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

allprojects {
    group = RELEASE_GROUP
    version = RELEASE_VERSION
    repositories.mavenCentral()
}
