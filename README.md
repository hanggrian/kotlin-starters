[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)
[![license](https://img.shields.io/github/license/hendraanggrian/kt-project-templates)](http://www.apache.org/licenses/LICENSE-2.0)

Kotlin Project Templates
------------------------
Personal Gradle project templates with emphasis on Kotlin, separated by target platform and kind of distribution.

Each template includes:
* Gradle DSL scripts with `buildSrc` directory containing release and dependencies information.
* Kotlin Gradle plugin, Standard and Testing library with JUnit.
* Ktlint code style.
* Git Publish plugin, necessary for uploading website module to `gh-pages`.
* Travis configuration file.

|  | jvm-library | jvm-app | android-library | android-app | gradle-plugin | Note |
|------------------------|--------------------|--------------------|--------------------|--------------------|--------------------|---------------------------------------------------------------------|
| Kotlin Kapt plugin |  | :heavy_check_mark: |  | :heavy_check_mark: |  |  |
| Dokka plugin | :heavy_check_mark: |  | :heavy_check_mark: |  | :heavy_check_mark: | When paired with Git Publish, also uploads Dokka generated content. |
| Bintray Release plugin | :heavy_check_mark: |  | :heavy_check_mark: |  | :heavy_check_mark: |  |
