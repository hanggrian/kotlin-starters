[![CircleCI](https://img.shields.io/circleci/build/gh/johndoe/library)](https://app.circleci.com/pipelines/gh/johndoe/library/)
[![Plugin Portal](https://img.shields.io/gradle-plugin-portal/v/com.johndoe.plugin)](https://plugins.gradle.org/plugin/com.johndoe.plugin)
[![Java](https://img.shields.io/badge/java-8+-informational)](https://docs.oracle.com/javase/8/)

# My Plugin

Some cool stuff going on here.

## Download

Using plugins DSL:

```gradle
plugins {
    id('com.johndoe.plugin') version "$version"
}
```

Using legacy plugin application:

```gradle
buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.johndoe:plugin:$version")
    }
}

apply plugin: 'com.johndoe.plugin'
```

## Usage

Work in progress.
