[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)
[![license](https://img.shields.io/github/license/hendraanggrian/kt-project-templates)](http://www.apache.org/licenses/LICENSE-2.0)

Kotlin Project Templates
------------------------
Personal Gradle project templates with emphasis on Kotlin, separated by target platform and kind of distribution.

Each template includes:
* Gradle Kotlin DSL scripts with `buildSrc` directory containing release and dependencies information.
* [Kotlin Standard Library] and [Kotlin Test Library].
* [ktlint] code style.
* [gradle-git-publish] plugin, necessary for uploading website module to `gh-pages`.
* [Travis CI] configuration file.

|                 | Gradle |        Kapt        |        Dokka       |  [bintray-release] |
|-----------------|:------:|:------------------:|:------------------:|:------------------:|
| jvm-library     |    6   |                    | :heavy_check_mark: | :heavy_check_mark: |
| jvm-app         |    6   | :heavy_check_mark: |                    |                    |
| android-library |    5   |                    | :heavy_check_mark: | :heavy_check_mark: |
| android-app     |    6   | :heavy_check_mark: |                    |                    |
| gradle-plugin   |    6   |                    | :heavy_check_mark: | :heavy_check_mark: |

[Kotlin Standard Library]: https://kotlinlang.org/api/latest/jvm/stdlib/
[Kotlin Test Library]: https://kotlinlang.org/api/latest/kotlin.test/
[ktlint]: https://github.com/pinterest/ktlint
[gradle-git-publish]: https://github.com/ajoberstar/gradle-git-publish
[Travis CI]: https://travis-ci.com
[bintray-release]: https://github.com/novoda/bintray-release
