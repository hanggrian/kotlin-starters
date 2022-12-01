pluginManagement.repositories {
    gradlePluginPortal()
    mavenCentral()
}
dependencyResolutionManagement.repositories.mavenCentral()

rootProject.name = "multi-library"

include("library-a")
include("library-b")
include("sample")
include("website")
