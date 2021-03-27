buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", VERSION_KOTLIN))
        classpath(android())
        classpath(gitPublish())
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}