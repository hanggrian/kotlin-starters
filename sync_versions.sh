#!/bin/bash

RED="$(tput setaf 1)" && readonly RED
GREEN="$(tput setaf 2)" && readonly GREEN
YELLOW="$(tput setaf 3)" && readonly YELLOW
END="$(tput sgr0)" && readonly END

warn() { echo "$YELLOW$*$END"; } >&2
die() { echo; echo "$RED$*$END"; echo; exit 1; } >&2

SOURCE_ROOT="$(cd "$(dirname "$0")" && pwd)" && readonly SOURCE_ROOT
declare -a PROJECTS=(
  "$(cd "$SOURCE_ROOT/android-application" && pwd)"
  "$(cd "$SOURCE_ROOT/android-library" && pwd)"
  "$(cd "$SOURCE_ROOT/gradle-plugin" && pwd)"
  "$(cd "$SOURCE_ROOT/jvm-application" && pwd)"
  "$(cd "$SOURCE_ROOT/jvm-library" && pwd)"
) && readonly PROJECTS

GRADLE_WRAPPER_FILE='gradle/wrapper/gradle-wrapper.properties' && \
  readonly GRADLE_WRAPPER_FILE
LIBS_FILE='gradle/libs.versions.toml' && readonly LIBS_FILE

update_gradle_wrapper() {
  perl -i -pe "s|^$1=.*$|$1=$2|" "$GRADLE_WRAPPER_FILE"
}
update_libs() {
  perl -i -pe "s|^$1 = \".*\"|$1 = \"$2\"|" "$LIBS_FILE"
}

for project in "${PROJECTS[@]}"; do
  warn "Syncing $project..."

  echo '(1/4) Generating Gradle wrapper'
  cd "$project" || exit 1
  update_gradle_wrapper 'distributionUrl' \
    'https\\\://services.gradle.org/distributions/gradle-9.4.0-bin.zip'
  ./gradlew -q wrapper

  echo '(2/4) Updating base'
  update_libs 'java-compile' '21'
  update_libs 'java-support' '8'
  update_libs 'kotlin' '2.3.10'
  update_libs 'dokka' '2.1.0'
  update_libs 'ktlint' '1.8.0'
  update_libs 'kotlinx-kover' 'org.jetbrains.kotlinx.kover:0.9.7'
  update_libs 'ksp' 'com.google.devtools.ksp:2.3.6'
  update_libs 'ktlint-gradle' 'org.jlleitschuh.gradle.ktlint:14.2.0'
  update_libs 'git-publish' 'org.ajoberstar.git-publish:5.1.3'
  update_libs 'pages' 'com.hanggrian.pages:0.3'
  update_libs 'rulebook-ktlint' \
    'com.hanggrian.rulebook:rulebook-ktlint:0.2'
  update_libs 'mockito-kotlin' 'org.mockito.kotlin:mockito-kotlin:6.2.3'
  update_libs 'truth' 'com.google.truth:truth:1.4.5'

  mockito_version='5.23.0'
  dagger_version='2.59.2'

  if [[ "$project" == *'android-'* ]]; then
    echo '(3/4) Updating Android'
    update_libs 'hilt' "$dagger_version"
    update_libs 'android-compile' '36'
    update_libs 'android-support' '21'
    update_libs 'android-plugin' '9.1.0'
    update_libs 'material' 'com.google.android.material:material:1.13.0'
    update_libs 'androidx-appcompat' 'androidx.appcompat:appcompat:1.7.1'
    update_libs 'androidx-core-ktx' 'androidx.core:core-ktx:1.17.0'
    update_libs 'androidx-test-core' 'androidx.test:core:1.7.0'
    update_libs 'androidx-test-runner' 'androidx.test:runner:1.7.0'
    update_libs 'androidx-test-junit' 'androidx.test.ext:junit:1.3.0'
    update_libs 'leakcanary' 'com.squareup.leakcanary:leakcanary-android:2.14'
    update_libs 'robolectric' 'org.robolectric:robolectric:4.16.1'
  elif [[ "$project" == *'jvm-'* ]]; then
    echo '(3/4) Updating JVM'
    update_libs 'dagger' "$dagger_version"
    update_libs 'junit' '5.14.3'
    update_libs 'junit-platform-launcher' \
      'org.junit.platform:junit-platform-launcher:1.14.3'
    update_libs 'mockito-junit-jupiter' \
      "org.mockito:mockito-junit-jupiter:$mockito_version"
  else
    echo '(3/4) Updating Gradle Publish'
    update_libs 'gradle-publish' 'com.gradle.plugin-publish:2.1.0'
    update_libs 'junit' 'junit:junit:4.13.2'
  fi

  if [[ "$project" == *'-library' ]]; then
    echo '(4/4) Updating Maven Publish'
    update_libs 'maven-publish' 'com.vanniktech.maven.publish.base:0.36.0'
  else
    echo '(4/4) Skip Maven Publish'
  fi
done

echo "${GREEN}Sync complete.$END"
echo
echo 'Goodbye!'
