include("app")
include("website")

dependencyResolutionManagement {
    versionCatalogs {
        val kotlinVersion = "1.6.21"
        register("sdk") {
            version("jdk", "8")
        }
        register("plugs") {
            library("kotlin", "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
            library("kotlin.kover", "org.jetbrains.kotlinx:kover:0.5.1")
            library("dokka", "org.jetbrains.dokka:dokka-gradle-plugin:$kotlinVersion")
            library("spotless", "com.diffplug.spotless:spotless-plugin-gradle:6.7.2")
            library("pages", "com.hendraanggrian:pages-gradle-plugin:0.1")
            library("git-publish", "org.ajoberstar.git-publish:gradle-git-publish:3.0.1")
        }
        register("libs") {
            library("kotlinx-coroutines", "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
        }
        register("testLibs") {
            library("kotlin-junit", "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
            library("truth", "com.google.truth:truth:1.1.3")
        }
    }
}
