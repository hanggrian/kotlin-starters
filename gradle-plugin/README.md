[![Travis CI](https://img.shields.io/travis/com/example/plugin)](https://travis-ci.com/github/example/plugin/)
[![Plugin Portal](https://img.shields.io/maven-metadata/v.svg?label=plugin-portal&metadataUrl=https%3A%2F%2Fplugins.gradle.org%2Fm2%2Fcom%2Fexample%2Fplugin%2Fcom.example.plugin.gradle.plugin%2Fmaven-metadata.xml)](https://plugins.gradle.org/plugin/com.example.plugin)
[![OpenJDK](https://img.shields.io/badge/jdk-1.8%2B-informational)](https://openjdk.java.net/projects/jdk8/)

# My Plugin

Some cool stuff going on here.

## Download

Using plugins DSL:

```gradle
plugins {
    id('com.example.plugin') version "$version"
}
```

Using legacy plugin application:

```gradle
buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.example:plugin:$version")
    }
}

apply plugin: 'com.example.plugin'
```

## Usage

Work in progress.
