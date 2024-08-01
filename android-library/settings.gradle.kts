pluginManagement.repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}
dependencyResolutionManagement.repositories {
    mavenCentral()
    google()
}

rootProject.name = "android-library"

include("library", "library-extension")
include("sample")
include("website")
