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
            val koverVersion = "0.5.1"
            val androidVersion = "7.2.1"
            val spotlessVersion = "6.7.2"
            val mavenPublishVersion = "0.20.0"
            val pagesVersion = "0.1"
            val gitPublishVersion = "3.0.1"
            library("kotlin", "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
            library("kotlin.kover", "org.jetbrains.kotlinx:kover:$koverVersion")
            library("dokka", "org.jetbrains.dokka:dokka-gradle-plugin:$kotlinVersion")
            library("android", "com.android.tools.build:gradle:$androidVersion")
            library("spotless", "com.diffplug.spotless:spotless-plugin-gradle:$spotlessVersion")
            library("maven-publish", "com.vanniktech:gradle-maven-publish-plugin:$mavenPublishVersion")
            library("pages", "com.hendraanggrian:pages-gradle-plugin:$pagesVersion")
            library("git-publish", "org.ajoberstar.git-publish:gradle-git-publish:$gitPublishVersion")
        }
        register("libs") {
            val coroutinesVersion = "1.6.2"
            val androidxCoreKtxVersion = "1.4.0-alpha01"
            val multidexVersion = "2.0.1"
            library("kotlinx-coroutines", "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
            library("material", "com.google.android.material:material:$androidxVersion")
            library("androidx-appcompat", "androidx.appcompat:appcompat:$androidxVersion")
            library("androidx-core-ktx", "androidx.core:core-ktx:$androidxCoreKtxVersion")
            library("androidx-multidex", "androidx.multidex:multidex:$multidexVersion")
        }
        register("testLibs") {
            val androidxJunitVersion = "1.1.3"
            val androidxTruthVersion = "1.4.0"
            val androidxEspressoVersion = "3.4.0"
            library("kotlin-junit", "org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
            library("androidx-core-ktx", "androidx.test:core-ktx:$androidxVersion")
            library("androidx-runner", "androidx.test:runner:$androidxVersion")
            library("androidx-rules", "androidx.test:rules:$androidxVersion")
            library("androidx-junit-ktx", "androidx.test.ext:junit-ktx:$androidxJunitVersion")
            library("androidx-truth", "androidx.test.ext:truth:$androidxTruthVersion")
            library("androidx-espresso-core", "androidx.test.espresso:espresso-core:$androidxEspressoVersion")
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
