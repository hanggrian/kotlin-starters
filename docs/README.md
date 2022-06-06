[![analysis](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081)](https://ktlint.github.io)

Kotlin Project Templates
========================

Personal Gradle project templates with emphasis on Kotlin, separated by target platform and kind of distribution.

Components included in each template:
- Gradle build tool:
  - [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) scripts with `buildSrc` containing project-level helpers.
  - Apply plugin using [legacy plugin application](https://docs.gradle.org/current/userguide/plugins.html#sec:old_plugin_application) for better integration with `buildSrc`.
  - Flattened source sets `src`, `res`, and subsequently `tests/src`, `tests/res`.
- Kotlin framework:
  - [Standard Library](https://kotlinlang.org/api/latest/jvm/stdlib).
  - [Coroutines Support Library](https://github.com/Kotlin/kotlinx.coroutines).
- Test dependencies:
  - [Kotlin Test Library](https://kotlinlang.org/api/latest/kotlin.test) with JUnit dependencies.
  - [Google Truth](https://github.com/google/truth) assertion.
- [ktlint](https://github.com/pinterest/ktlint) code style.
- Website module:
  - [Minimal](https://github.com/hendraanggrian/minimal) theme displaying README's content and documentation links (if any).
  - [gradle-git-publish](https://github.com/ajoberstar/gradle-git-publish) plugin, necessary for uploading to [GitHub Pages](https://pages.github.com).
- [Travis CI] configuration file.

Situational components differ by target:
|                 | Plugins                              | Publications           | Others           |
|-----------------|--------------------------------------|------------------------|------------------|
| android-app     | [Android], [kapt]                    |                        |                  |
| android-library | [Android], [Dokka]                   | [Maven Central]        |                  |
| gradle-plugin   | [Gradle Plugin Development], [Dokka] | [Gradle Plugin Portal] | [Gradle TestKit] |
| jvm-app         | [Application], [kapt]                |                        |                  |
| jvm-library     | [Dokka]                              | [Maven Central]        |                  |
| multi-module    | [Dokka]                              | [Maven Central]        |                  |

[Travis CI]: https://travis-ci.com
[Dokka]: https://github.com/Kotlin/dokka
[kapt]: https://kotlinlang.org/docs/kapt.html
[Application]: https://docs.gradle.org/current/userguide/application_plugin.html
[Android]: https://developer.android.com/studio/build
[Gradle Plugin Development]: https://docs.gradle.org/current/userguide/java_gradle_plugin.html
[Gradle TestKit]: https://docs.gradle.org/current/userguide/test_kit.html
[Maven Central]: https://search.maven.org/
[Gradle Plugin Portal]: https://plugins.gradle.org/
