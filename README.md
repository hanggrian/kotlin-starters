# Kotlin Starters

![](https://github.com/hanggrian/kotlin-starters/raw/assets/logo.png)

Common Gradle project templates with emphasis on **Kotlin,** separated by target
platform and kind of distribution.

| | Plugins | Testing | Publishing | Website | Coverage | Max Heap Size
--- | :---: | :---: | :---: | :---: | :---: | :---:
android-app | [Kotlin Android], [Android] | [JUnit 4], [Robolectric] | &cross; | [Cayman] | &check; | 4GB
android-library | [Kotlin Android], [Android] | [JUnit 4], [Robolectric] | [Maven Central] | [Dokka], [Minimal] | &check; | 4GB
gradle-plugin | [Kotlin DSL] | [JUnit 4] | [Plugin Portal] | [Dokka], [Minimal] | &cross; | 2GB
js-app | &cross; | &cross; | &cross; | [Cayman] | &check; | 2GB
jvm-app | [Kotlin JVM], [Application] | [JUnit 5] | &cross; | [Cayman] | &check; | 2GB
jvm-library | [Kotlin JVM] | [JUnit 5] | [Maven Central] | [Dokka], [Minimal] | &check; | 2GB
native-app | &cross; | &cross; | &cross; | [Cayman] | &check; | 2GB

## Frameworks

- Targeted plugin for each platform and [Coroutines Support Library](https://github.com/Kotlin/kotlinx.coroutines/).
- JUnit testing framework with [Kotlin Test](https://kotlinlang.org/api/latest/kotlin.test/)
  library support, [Mockito](https://site.mockito.org/) suite and [Truth](https://truth.dev/)
  asserter.
- [Ktlint](https://github.com/pinterest/ktlint/) code linter with third-party
  ruleset [Rulebook](https://github.com/hendraanggrian/rulebook/).
- [Kover](https://github.com/Kotlin/kotlinx-kover/) code coverage.

## Project layout

- Root directory:
  - GitHub [README](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-readmes/),
    [LICENSE](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/licensing-a-repository/),
    and [gitignore](https://docs.github.com/en/get-started/getting-started-with-git/ignoring-files/)
    file.
  - [EditorConfig](https://editorconfig.org/) enforces IDE settings.
  - [CircleCI](https://circleci.com/) to run test every commit, also triggers
    [Codecov](https://about.codecov.io/) integration within CircleCI.
- Gradle build tool:
  - [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    scripts with properties delegation.
  - Apply plugin using [plugins DSL](https://docs.gradle.org/current/userguide/plugins.html).
  - [Version catalogs](https://docs.gradle.org/current/userguide/platforms.html)
    in TOML file to avoid typing unsafe dependencies.
- Website module:
  - [Pages Gradle Plugin](https://github.com/hendraanggrian/pages-gradle-plugin/)
    for generating webpage displaying README's content and documentation links.
  - [gradle-git-publish](https://github.com/ajoberstar/gradle-git-publish/)
    plugin, necessary for uploading to [GitHub Pages](https://pages.github.com/).

[Kotlin JVM]: https://kotlinlang.org/docs/get-started-with-jvm-gradle-project.html
[Kotlin Android]: https://developer.android.com/kotlin/add-kotlin
[Kotlin DSL]: https://docs.gradle.org/current/userguide/kotlin_dsl.html
[Application]: https://docs.gradle.org/current/userguide/application_plugin.html
[Android]: https://developer.android.com/studio/build/
[JUnit 4]: https://junit.org/junit4/
[JUnit 5]: https://junit.org/junit5/
[Robolectric]: https://robolectric.org/
[Plugin Portal]: https://plugins.gradle.org/
[Maven Central]: https://central.sonatype.com/
[Dokka]: https://github.com/Kotlin/dokka/
[Cayman]: https://hanggrian.github.io/cayman-dark-theme/
[Minimal]: https://hanggrian.github.io/minimal-dark-theme/
