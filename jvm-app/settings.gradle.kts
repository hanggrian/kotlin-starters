include("app")
include("website")

dependencyResolutionManagement {
    versionCatalogs {
        val kotlinVersion = "1.7.0"
        register("sdk") {
            version("jdk", "8")
        }
        register("plugs") {
            plugin("kotlin-jvm", "org.jetbrains.kotlin.jvm").version(kotlinVersion)
            plugin("kotlin-kapt", "org.jetbrains.kotlin.kapt").version(kotlinVersion)
            plugin("kotlinx-kover", "org.jetbrains.kotlinx.kover").version("0.5.1")
            plugin("spotless", "com.diffplug.spotless").version("6.8.0")
            plugin("git-publish", "org.ajoberstar.git-publish").version("3.0.1")
            plugin("pages", "com.hendraanggrian.pages").version("0.1")
        }
        register("libs") {
            library("kotlinx-coroutines", "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3")
        }
        register("testLibs") {
            library("kotlin-junit", "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
            library("truth", "com.google.truth:truth:1.1.3")
        }
    }
}
