# Kotlin Project Templates

Personal Gradle project templates with emphasis on Kotlin, separated by target platform and kind of distribution.

Components included in each template:

- Gradle build tool:
  - [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) scripts with `buildSrc` containing project helpers.
  - Apply plugin using [legacy plugin application](https://docs.gradle.org/current/userguide/plugins.html#sec:old_plugin_application) because classpath need to exist in root `build.gradle.kts`.
  - Version catalog configured in `settings.gradle.kts`.
- Kotlin framework:
  - [Standard Library](https://kotlinlang.org/api/latest/jvm/stdlib/) and [Coroutines Support Library](https://github.com/Kotlin/kotlinx.coroutines/).
  - [Kover](https://github.com/Kotlin/kotlinx-kover/) code coverage.
- Test dependencies:
  - [Kotlin Test Library](https://kotlinlang.org/api/latest/kotlin.test/) with JUnit dependencies.
  - [Google Truth](https://github.com/google/truth/) assertion.
- [ktlint](https://github.com/pinterest/ktlint/) code style, imported using [Spotless](https://github.com/diffplug/spotless/) plugin.
- Website module:
  - [Minimal Theme](https://github.com/hendraanggrian/minimal-theme/) webpage displaying README's content and documentation links (if any).
  - [gradle-git-publish](https://github.com/ajoberstar/gradle-git-publish/) plugin, necessary for uploading to [GitHub Pages](https://pages.github.com/).
- [Travis CI](https://travis-ci.com/) configuration file.

Situational components differ by target:

|                 | Plugins                              | Publications           | Others           |
|-----------------|--------------------------------------|------------------------|------------------|
| android-app     | [Android], [kapt]                    |                        |                  |
| android-library | [Android], [Dokka]                   | [Maven Central]        |                  |
| gradle-plugin   | [Gradle Plugin Development], [Dokka] | [Gradle Plugin Portal] | [Gradle TestKit] |
| jvm-app         | [Application], [kapt]                |                        |                  |
| jvm-library     | [Dokka]                              | [Maven Central]        |                  |
| multi-module    | [Dokka]                              | [Maven Central]        |                  |

[Dokka]: https://github.com/Kotlin/dokka/
[kapt]: https://kotlinlang.org/docs/kapt.html
[Application]: https://docs.gradle.org/current/userguide/application_plugin.html
[Android]: https://developer.android.com/studio/build/
[Gradle Plugin Development]: https://docs.gradle.org/current/userguide/java_gradle_plugin.html
[Gradle TestKit]: https://docs.gradle.org/current/userguide/test_kit.html
[Maven Central]: https://search.maven.org/
[Gradle Plugin Portal]: https://plugins.gradle.org/
