# Kotlin Starters

![The repository logo.](https://github.com/hendraanggrian/kotlin-starters/raw/assets/logo.png)

Personal Gradle project templates with emphasis on **Kotlin**, separated by
target platform and kind of distribution.

| | Plugins | Publication | Testing
--- | :---: | :---: | :---:
android-app | [Android] | &cross; | [Robolectric]
android-library | [Android], [Dokka] | [Maven Central] | [Robolectric]
js-app | &cross; | &cross; | &cross;
jvm-app | [Application] | &cross; | &cross;
jvm-library | [Dokka] | [Maven Central] | &cross;
native-app | &cross; | &cross; | &cross;

## Kotlin Frameworks

- Targeted plugin for each platform and [Coroutines Support Library](https://github.com/Kotlin/kotlinx.coroutines/).
- [Kotlin Test Library](https://kotlinlang.org/api/latest/kotlin.test/) with
  JUnit dependencies.
- [Ktlint](https://github.com/pinterest/ktlint/) code linter with third-party
  ruleset [Rulebook](https://github.com/hendraanggrian/rulebook/).
- [Kover](https://github.com/Kotlin/kotlinx-kover/) code coverage.

## Project Layout

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
    for generating webpage displaying README's content and documentation links
    (except for apps).
  - [gradle-git-publish](https://github.com/ajoberstar/gradle-git-publish/)
    plugin, necessary for uploading to [GitHub Pages](https://pages.github.com/).

[Dokka]: https://github.com/Kotlin/dokka/
[Application]: https://docs.gradle.org/current/userguide/application_plugin.html
[Android]: https://developer.android.com/studio/build/
[Maven Central]: https://search.maven.org/
[Robolectric]: http://robolectric.org/
