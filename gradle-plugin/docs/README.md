[![Travis CI](https://img.shields.io/travis/com/hendraanggrian/plugin)](https://www.travis-ci.com/github/hendraanggrian/plugin/)
[![Plugin Portal](https://img.shields.io/maven-metadata/v?label=plugin-portal&metadataUrl=https%3A%2F%2Fplugins.gradle.org%2Fm2%2Fcom%2Fhendraanggrian%2Fplugin%2Fcom.hendraanggrian.plugin.gradle.plugin%2Fmaven-metadata.xml)](https://plugins.gradle.org/plugin/com.hendraanggrian.plugin/)
[![OpenJDK](https://img.shields.io/badge/jdk-1.8+-informational)](https://openjdk.java.net/projects/jdk8/)

# My Plugin

Some cool stuff going on here.

## Download

Using plugins DSL:

```gradle
plugins {
    id('com.hendraanggrian.plugin') version "$version"
}
```

Using legacy plugin application:

```gradle
buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.hendraanggrian:plugin:$version")
    }
}

apply plugin: 'com.hendraanggrian.plugin'
```

## Usage

Work in progress.
