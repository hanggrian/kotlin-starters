[![ktlint](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)
[![license](https://img.shields.io/github/license/hendraanggrian/kt-project-templates)](http://www.apache.org/licenses/LICENSE-2.0)

Kotlin Project Templates
------------------------
Personal Gradle project templates with emphasis on Kotlin, separated by target platform and kind of distribution.

Each template includes:
* Gradle Kotlin DSL scripts with `buildSrc` directory containing release and dependencies information.
* [Kotlin Standard Library] and [Kotlin Test Library] with JUnit dependencies.
* [ktlint] code style.
* [gradle-git-publish] plugin, necessary for uploading website module to `gh-pages`.
* [Travis CI] configuration file.

Full configuration:
|                 | Plugins                              | Publications           | Others           |
|-----------------|--------------------------------------|------------------------|------------------|
| jvm-library     | [Dokka]                              | [Maven Central]        |                  |
| jvm-app         | [Application], [kapt]                |                        |                  |
| android-library | [Android], [Dokka]                   | [Maven Central]        |                  |
| android-app     | [Android], [kapt]                    |                        |                  |
| gradle-plugin   | [Gradle Plugin Development], [Dokka] | [Gradle Plugin Portal] | [Gradle TestKit] |

[Kotlin Standard Library]: https://kotlinlang.org/api/latest/jvm/stdlib/
[Kotlin Test Library]: https://kotlinlang.org/api/latest/kotlin.test/
[ktlint]: https://github.com/pinterest/ktlint
[gradle-git-publish]: https://github.com/ajoberstar/gradle-git-publish
[Travis CI]: https://travis-ci.com
[Dokka]: https://github.com/Kotlin/dokka
[kapt]: https://kotlinlang.org/docs/kapt.html
[Application]: https://docs.gradle.org/current/userguide/application_plugin.html
[Android]: https://developer.android.com/studio/build
[Gradle Plugin Development]: https://docs.gradle.org/current/userguide/java_gradle_plugin.html
[Gradle TestKit]: https://docs.gradle.org/current/userguide/test_kit.html
[Maven Central]: https://search.maven.org/
[Gradle Plugin Portal]: https://plugins.gradle.org/