#!/bin/bash

RED="$(tput setaf 1)" && readonly RED
GREEN="$(tput setaf 2)" && readonly GREEN
YELLOW="$(tput setaf 3)" && readonly YELLOW
END="$(tput sgr0)" && readonly END

warn() { echo "$YELLOW$*$END"; } >&2
die() { echo; echo "$RED$*$END"; echo; exit 1; } >&2

SOURCE_ROOT="$(cd "$(dirname "$0")" && pwd)" && readonly SOURCE_ROOT
declare -a PROJECTS=(
  "$(cd "$SOURCE_ROOT/android-app" && pwd)"
  "$(cd "$SOURCE_ROOT/android-library" && pwd)"
  "$(cd "$SOURCE_ROOT/gradle-plugin" && pwd)"
  "$(cd "$SOURCE_ROOT/jvm-app" && pwd)"
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

MOCKITO_VERSION='5.18.0' && readonly MOCKITO_VERSION

for project in "${PROJECTS[@]}"; do
  warn "Syncing $project..."

  echo '(1/4) Generating Gradle wrapper'
  cd "$project" || exit 1
  update_gradle_wrapper 'distributionUrl' \
    'https\\\://services.gradle.org/distributions/gradle-8.14.2-bin.zip'
  ./gradlew -q wrapper

  echo '(2/4) Updating base'
  update_libs 'jdk' '21'
  update_libs 'jre' '8'
  update_libs 'kotlin' '2.0.0'
  update_libs 'ktlint' '1.6.0'
  update_libs 'kotlinx-kover' 'org.jetbrains.kotlinx.kover:0.9.1'
  update_libs 'ktlint-gradle' 'org.jlleitschuh.gradle.ktlint:12.3.0'
  update_libs 'git-publish' 'org.ajoberstar.git-publish:5.1.1'
  update_libs 'pages' 'com.hanggrian.pages:0.2'
  update_libs 'rulebook-ktlint' \
    'com.hanggrian.rulebook:rulebook-ktlint:0.1'
  update_libs 'truth' 'com.google.truth:truth:1.4.4'

  if [[ "$project" == *'android-'* ]]; then
    echo '(3/4) Updating Android'
    update_libs 'sdk-min' '21'
    update_libs 'sdk-target' '36'
    update_libs 'android-plugin' '8.10.1'
    update_libs 'material' 'com.google.android.material:material:1.12.0'
    update_libs 'androidx-appcompat' 'androidx.appcompat:appcompat:1.7.0'
    update_libs 'androidx-core-ktx' 'androidx.core:core-ktx:1.16.0'
    update_libs 'androidx-multidex' 'androidx.multidex:multidex:2.0.1'
    update_libs 'androidx-test-core' 'androidx.test:core:1.6.1'
    update_libs 'androidx-test-runner' 'androidx.test:runner:1.6.2'
    update_libs 'androidx-test-junit' 'androidx.test.ext:junit:1.2.1'
    update_libs 'mockito-kotlin' 'org.mockito.kotlin:mockito-kotlin:5.4.0'
    update_libs 'robolectric' 'org.robolectric:robolectric:4.14.1'
  elif [[ "$project" == *'jvm-'* ]]; then
    echo '(3/4) Updating JVM'
    update_libs 'junit' '5.13.0'
    update_libs 'junit-platform-launcher' \
      'org.junit.platform:junit-platform-launcher:1.13.0'
    update_libs 'mockito-junit-jupiter' \
      "org.mockito:mockito-junit-jupiter:$MOCKITO_VERSION"
  else
    echo '(3/4) Updating Gradle Publish'
    update_libs 'gradle-publish' 'com.gradle.plugin-publish:1.3.1'
    update_libs 'junit' 'junit:junit:4.13.2'
    update_libs 'mockito-kotlin' 'org.mockito.kotlin:mockito-kotlin:5.4.0'
  fi

  if [[ "$project" == *'-library' ]]; then
    echo '(4/4) Updating Maven Publish'
    update_libs 'maven-publish' 'com.vanniktech.maven.publish.base:0.32.0'
  else
    echo '(4/4) Skip Maven Publish'
  fi
done

echo "${GREEN}Sync complete.$END"
