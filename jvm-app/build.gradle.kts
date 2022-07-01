buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    dependencies.classpath(plugs.pages) {
        capability("pages-minimal")
    }
}

allprojects {
    group = RELEASE_GROUP
    version = RELEASE_VERSION
    repositories.mavenCentral()
}
