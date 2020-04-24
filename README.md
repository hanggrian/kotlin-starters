Kotlin Project Templates
------------------------
My Kotlin project templates, only tested on IntelliJ IDEA.

|  | jvm-library | jvm-app | android-library | android-app | gradle-plugin | Note |
|-------------------------|--------------------|--------------------|--------------------|--------------------|--------------------|-----------------------------------------------------------------------------------|
| Gradle version | 6.3 | 6.3 | 5.6.4 | 6.3 | 6.3 | `android-library` are stuck to Gradle version 5 until Bintray Release is updated. |
| Kotlin Standard Library | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | Also includes Kotlin testing library with JUnit. |
| Kotlin Kapt plugin |  | :heavy_check_mark: |  | :heavy_check_mark: |  |  |
| Dokka plugin | :heavy_check_mark: |  | :heavy_check_mark: |  | :heavy_check_mark: | When paired with Git Publish, also uploads Dokka generated content. |
| Git Publish plugin | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | Necessary for uploading website to `gh-pages`. |
| Bintray Release plugin | :heavy_check_mark: |  | :heavy_check_mark: |  | :heavy_check_mark: |  |
| Ktlint code style | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |  |
| Travis config file | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |  |
