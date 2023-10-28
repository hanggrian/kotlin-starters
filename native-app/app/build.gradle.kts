plugins {
    kotlin("multiplatform") version libs.versions.kotlin
    alias(libs.plugins.kotlinx.kover)
    alias(libs.plugins.ktlint)
}

ktlint.version.set(libs.versions.ktlint.get())

kotlin {
    val os = System.getProperty("os.name")
    val isArm64 = System.getProperty("os.arch") == "aarch64"
    val nativeTarget =
        when {
            os == "Mac OS X" -> if (isArm64) macosArm64("native") else macosX64("native")
            os == "Linux" -> if (isArm64) linuxArm64("native") else linuxX64("native")
            os.startsWith("Windows") -> mingwX64("native")
            else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
        }
    nativeTarget.binaries.executable {
        entryPoint = "main"
    }
    sourceSets {
        val nativeMain by getting
        val nativeTest by getting
    }
}
