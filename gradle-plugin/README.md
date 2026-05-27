[![GitHub Actions](https://shields.io/github/actions/workflow/status/johndoe/plugin/code-analysis.yaml)](https://github.com/johndoe/plugin/actions/workflows/code-analysis.yaml)
[![Renovate](https://shields.io/badge/renovate-enabled-brightgreen)](https://developer.mend.io/github/johndoe/plugin/)
[![Plugin Portal](https://shields.io/gradle-plugin-portal/v/com.johndoe.plugin)](https://plugins.gradle.org/plugin/com.johndoe.plugin)
[![Java](https://shields.io/badge/java-8+-informational)](https://docs.oracle.com/javase/8/)

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
