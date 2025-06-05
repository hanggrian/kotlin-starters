#!/bin/bash

RED="$(tput setaf 1)" && readonly RED
GREEN="$(tput setaf 2)" && readonly GREEN
YELLOW="$(tput setaf 3)" && readonly YELLOW
END="$(tput sgr0)" && readonly END

warn() { echo "$YELLOW$*$END"; } >&2
die() { echo; echo "$RED$*$END"; echo; exit 1; } >&2

SOURCE_ROOT="$(cd "$(dirname "$0")" && pwd)" && readonly SOURCE_ROOT
declare -a ANDROID_PROJECTS=(
  "$(cd "$SOURCE_ROOT/android-app" && pwd)"
  "$(cd "$SOURCE_ROOT/android-library" && pwd)"
) && readonly ANDROID_PROJECTS
declare -a JAVA_PROJECTS=(
  "$(cd "$SOURCE_ROOT/jvm-app" && pwd)"
  "$(cd "$SOURCE_ROOT/jvm-library" && pwd)"
) && readonly JAVA_PROJECTS
declare -a OTHER_PROJECTS=(
  "$(cd "$SOURCE_ROOT/gradle-plugin" && pwd)"
  "$(cd "$SOURCE_ROOT/js-app" && pwd)"
  "$(cd "$SOURCE_ROOT/native-app" && pwd)"
) && readonly OTHER_PROJECTS

KOVER_FILE='build/reports/kover/report.xml' && readonly KOVER_FILE
PAGES_DIR='website/build/pages/' && readonly PAGES_DIR

for project in "${ANDROID_PROJECTS[@]}"; do
  warn "Testing $project..."

  echo '(1/3) Running Gradle tasks'
  cd "$project" || exit 1
  ./gradlew -q clean check koverXmlReport deployPages

  echo '(2/3) Checking coverage file'
  is_app=false
  if [[ "$project" == *'-app' ]]; then
    is_app=true
    if [[ ! -e "$KOVER_FILE" ]]; then
      die 'Coverage not found.'
    fi
  else
    if [[ ! -e "library/$KOVER_FILE" ]] ||
      [[ ! -e "library-extension/$KOVER_FILE" ]]; then
      die 'Coverage not found.'
    fi
  fi

  echo '(3/3) Checking website directory'
  if [[ "$is_app" = true ]]; then
    if [[ ! -e "$PAGES_DIR" ]]; then
      die 'Website not built.'
    fi
  else
    if [[ ! -e "${PAGES_DIR}dokka/library" ]] ||
      [[ ! -e "${PAGES_DIR}dokka/library-extension" ]]; then
      die 'Website not built.'
    fi
  fi
done

for project in "${JAVA_PROJECTS[@]}"; do
  warn "Testing $project..."

  echo '(1/3) Running Gradle tasks'
  cd "$project" || exit 1
  ./gradlew -q clean check koverXmlReport deployPages

  echo '(2/3) Checking coverage file'
  is_app=false
  if [[ "$project" == *'-app' ]]; then
    is_app=true
    if [ ! -e "$KOVER_FILE" ]; then
      die 'Coverage not found.'
    fi
  else
    if [[ ! -e "library/$KOVER_FILE" ]] ||
      [[ ! -e "library-extension/$KOVER_FILE" ]]; then
      die "Coverage not found."
    fi
  fi

  echo '(3/3) Checking website directory'
  if [[ "$is_app" = true ]]; then
    if [[ ! -e "$PAGES_DIR" ]]; then
      die 'Website not built.'
    fi
  else
    if [[ ! -e "${PAGES_DIR}dokka/library" ]] ||
      [[ ! -e "${PAGES_DIR}dokka/library-extension" ]]; then
      die 'Website not built.'
    fi
  fi
done

for project in "${OTHER_PROJECTS[@]}"; do
  warn "Testing $project..."

  echo '(1/2) Running Gradle tasks'
  cd "$project" || exit 1
  ./gradlew -q clean check deployPages

  echo '(2/2) Checking website directory'
  if [[ ! -e "$PAGES_DIR" ]]; then
    die 'Website not built.'
  fi
done

echo "${GREEN}Tests complete.$END"
