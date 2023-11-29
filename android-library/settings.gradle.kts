pluginManagement.repositories {
    mavenCentral()
    gradlePluginPortal()
    google()
}
dependencyResolutionManagement.repositories {
    mavenCentral()
    google()
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

rootProject.name = "android-library"

include("library", "library-ext")
include("sample")
include("website")
