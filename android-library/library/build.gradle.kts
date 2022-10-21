import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.android.library")
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.dokka)
    alias(libs.plugins.spotless)
    alias(libs.plugins.maven.publish)
}

android {
    buildFeatures.buildConfig = false
    testOptions.unitTests.isIncludeAndroidResources = true
}

spotless.kotlin {
    ktlint()
}

mavenPublishing {
    publishToMavenCentral(SonatypeHost.S01)
    signAllPublications()
    pom {
        name.set(project.name)
        description.set(RELEASE_DESCRIPTION)
        url.set(RELEASE_URL)
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }
        scm {
            connection.set("scm:git:https://github.com/$DEVELOPER_ID/$RELEASE_ARTIFACT.git")
            developerConnection.set("scm:git:ssh://git@github.com/$DEVELOPER_ID/$RELEASE_ARTIFACT.git")
            url.set(RELEASE_URL)
        }
        developers {
            developer {
                id.set(DEVELOPER_ID)
                name.set(DEVELOPER_NAME)
                url.set(DEVELOPER_URL)
            }
        }
    }
    configure(AndroidSingleVariantLibrary())
}

dependencies {
    implementation(libs.kotlinx.coroutines)
    implementation(libs.androidx.appcompat)
    androidTestImplementation(libs.kotlin.test.junit)
    androidTestImplementation(libs.bundles.androidx.test)
}

tasks.dokkaHtml {
    outputDirectory.set(buildDir.resolve("dokka/dokka"))
}
