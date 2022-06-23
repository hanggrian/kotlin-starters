include("app")
include("website")

dependencyResolutionManagement {
    versionCatalogs {
        val kotlinVersion = "1.6.21"
        val androidxVersion = "1.4.0"
        register("sdk") {
            version("jdk", "11")
            version("androidMin", "14")
            version("androidTarget", "32")
        }
        register("plugs") {
            library("android", "com.android.tools.build:gradle:7.2.1")
            library("kotlin", "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
            library("kotlin.kover", "org.jetbrains.kotlinx:kover:0.5.1")
            library("dokka", "org.jetbrains.dokka:dokka-gradle-plugin:$kotlinVersion")
            library("spotless", "com.diffplug.spotless:spotless-plugin-gradle:6.7.2")
            library("pages", "com.hendraanggrian:pages-gradle-plugin:0.1")
            library("git-publish", "org.ajoberstar.git-publish:gradle-git-publish:3.0.1")
        }
        register("libs") {
            library("kotlinx-coroutines", "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
            library("material", "com.google.android.material:material:$androidxVersion")
            library("androidx-appcompat", "androidx.appcompat:appcompat:$androidxVersion")
            library("androidx-core-ktx", "androidx.core:core-ktx:1.4.0-alpha01")
            library("androidx-multidex", "androidx.multidex:multidex:2.0.1")
        }
        register("testLibs") {
            library("kotlin-junit", "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
            library("androidx-core-ktx", "androidx.test:core-ktx:$androidxVersion")
            library("androidx-runner", "androidx.test:runner:$androidxVersion")
            library("androidx-rules", "androidx.test:rules:$androidxVersion")
            library("androidx-junit-ktx", "androidx.test.ext:junit-ktx:1.1.3")
            library("androidx-truth", "androidx.test.ext:truth:1.4.0")
            library("androidx-espresso-core", "androidx.test.espresso:espresso-core:3.4.0")
            bundle(
                "androidx",
                listOf(
                    "androidx-core-ktx", "androidx-runner", "androidx-rules",
                    "androidx-junit-ktx", "androidx-truth", "androidx-espresso-core"
                )
            )
        }
    }
}
