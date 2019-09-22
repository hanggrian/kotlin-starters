buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(gitPublish())
    }
}

allprojects {
    repositories {
        jcenter()
        maven("https://dl.bintray.com/hendraanggrian/maven")
    }
    tasks.withType<Delete> {
        delete(projectDir.resolve("out"))
    }
}

tasks {
    register<Delete>("clean") {
        delete(rootProject.buildDir)
    }
    named<Wrapper>("wrapper") {
        gradleVersion = VERSION_GRADLE
    }
}
