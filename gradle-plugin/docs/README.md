[![version](https://img.shields.io/maven-metadata/v?label=plugin-portal&metadataUrl=https%3A%2F%2Fplugins.gradle.org%2Fm2%2Forg%2Fjetbrains%2Fkotlin%2Fjvm%2Forg.jetbrains.kotlin.jvm.gradle.plugin%2Fmaven-metadata.xml)](https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm)
[![build](https://img.shields.io/travis/com/jetbrains/pty4j)](https://www.travis-ci.com/github/jetbrains/pty4j)
[![analysis](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081)](https://ktlint.github.io)

My Plugin
=========

Some cool stuff going on here.

Download
--------

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

Usage
-----

Work in progress.