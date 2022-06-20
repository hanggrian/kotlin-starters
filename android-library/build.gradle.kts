import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
    dependencies {
        classpath(plugs.kotlin)
        classpath(plugs.kotlin.kover)
        classpath(plugs.dokka)
        classpath(plugs.android)
        classpath(plugs.spotless)
        classpath(plugs.maven.publish)
        classpath(plugs.pages) { features("pages-minimal") }
        classpath(plugs.git.publish)
    }
}

allprojects {
    group = RELEASE_GROUP
    version = RELEASE_VERSION
    repositories {
        mavenCentral()
        google()
    }
}

subprojects {
    afterEvaluate {
        val configureAndroid: BaseExtension.() -> Unit = {
            setCompileSdkVersion(sdk.versions.androidTarget.getInt())
            defaultConfig {
                minSdk = sdk.versions.androidMin.getInt()
                targetSdk = sdk.versions.androidTarget.getInt()
                version = RELEASE_VERSION
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            compileOptions {
                targetCompatibility = sdk.versions.jdk.getJavaVersion()
                sourceCompatibility = sdk.versions.jdk.getJavaVersion()
            }
            (this as ExtensionAware).extensions.configure<KotlinJvmOptions>("kotlinOptions") {
                jvmTarget = sdk.versions.jdk.get()
            }
        }
        extensions.find<LibraryExtension> { configureAndroid() }
        extensions.find<BaseAppModuleExtension> { configureAndroid() }
        extensions.find<KotlinProjectExtension>()?.jvmToolchain {
            (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(sdk.versions.jdk.get()))
        }
    }
}
