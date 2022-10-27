# Kotlin Starters

Personal Gradle project templates with emphasis on Kotlin, separated by target platform and kind of
distribution.

Components included in each template:

- GitHub project layout:
  - [README](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-readmes/)
    and [LICENSE](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/licensing-a-repository/)
    file in root directory.
- Gradle build tool:
  - [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) scripts with `buildSrc`
    containing project helpers.
  - Apply plugin using [plugins DSL](https://docs.gradle.org/current/userguide/plugins.html).
  - [Version catalogs](https://docs.gradle.org/current/userguide/platforms.html) in TOML file to
    avoid typing unsafe dependencies.
- Kotlin framework:
  - Plugin for each platform
    and [Coroutines Support Library](https://github.com/Kotlin/kotlinx.coroutines/).
  - [Kover](https://github.com/Kotlin/kotlinx-kover/) code coverage.
- Test dependencies:
  - [Kotlin Test Library](https://kotlinlang.org/api/latest/kotlin.test/) with JUnit dependencies.
  - [Google Truth](https://github.com/google/truth/) assertion tool.
- [ktlint](https://github.com/pinterest/ktlint/) code style, imported
  using [Spotless](https://github.com/diffplug/spotless/) plugin.
- Website module:
  - [Pages Gradle Plugin](https://github.com/hendraanggrian/pages-gradle-plugin/) for generating
    webpage displaying README's content and documentation links (except for apps).
  - [gradle-git-publish](https://github.com/ajoberstar/gradle-git-publish/) plugin, necessary for
    uploading to [GitHub Pages](https://pages.github.com/).
- Third-party services:
  - [Travis CI](https://travis-ci.com/) to run test every commit.
  - [Codecov](https://about.codecov.io/) integration within Travis CI, except for `gradle-plugin`.

Situational components differ by target:

| | Plugins | Publications | Others |
| --- | --- | --- | --- |
| android-app | [Android], [kapt] | | [Robolectric] unit test |
| android-library | [Android], [Dokka] | [Maven Central] | [Robolectric] unit test |
| gradle-plugin | [Gradle Plugin Development], [Dokka] | [Gradle Plugin Portal] | [Gradle TestKit] |
| jvm-app | [Application], [kapt] | | |
| jvm-library | [Dokka] | [Maven Central] | |
| multi-module | [Dokka] | [Maven Central] | |

[Dokka]: https://github.com/Kotlin/dokka/
[kapt]: https://kotlinlang.org/docs/kapt.html
[Application]: https://docs.gradle.org/current/userguide/application_plugin.html
[Android]: https://developer.android.com/studio/build/
[Gradle Plugin Development]: https://docs.gradle.org/current/userguide/java_gradle_plugin.html
[Gradle Plugin Portal]: https://plugins.gradle.org/
[Gradle TestKit]: https://docs.gradle.org/current/userguide/test_kit.html
[Maven Central]: https://search.maven.org/
[Robolectric]: http://robolectric.org/
