Kotlin Project Templates
------------------------
My Kotlin project templates, only tested on IntelliJ IDEA.

|  | jvm-library | jvm-app | android-library | android-app | gradle-plugin | Note |
|-------------------------|--------------------|--------------------|--------------------|--------------------|--------------------|-----------------------------------------------------------------------------------|
| Gradle version | 6.3 | 6.3 | 5.6.4 | 6.3 | 6.3 | `android-library` are stuck to Gradle version 5 until Bintray Release is updated. |
| Kotlin Standard Library | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | Also includes testing library with JUnit. |
| Kotlin Kapt plugin |  | :heavy_check_mark: |  | :heavy_check_mark: |  |  |
| Dokka plugin | :heavy_check_mark: |  | :heavy_check_mark: |  | :heavy_check_mark: | When paired with Git Publish, also uploads Dokka content. |
| Git Publish plugin | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | Necessary for uploading website to `gh-pages`. |
| Bintray Release plugin | :heavy_check_mark: |  | :heavy_check_mark: |  | :heavy_check_mark: |  |
| Ktlint code style | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |  |
| Travis config file | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: | :heavy_check_mark: |  |

License
-------
    Copyright 2019 Hendra Anggrian

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
