group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    dokka
    `maven-publish`
    signing
}

sourceSets {
    main {
        java.srcDir("src")
        resources.srcDir("res")
    }
    register("integrationTest") {
        java.srcDir("integration-tests/src")
        resources.srcDir("integration-tests/res")
        compileClasspath += sourceSets.main.get().output + configurations.testRuntimeClasspath
        runtimeClasspath += output + compileClasspath
    }
    register("functionalTest") {
        java.srcDir("functional-tests/src")
        resources.srcDir("functional-tests/res")
        compileClasspath += sourceSets.main.get().output + configurations.testRuntimeClasspath
        runtimeClasspath += output + compileClasspath
    }
}

gradlePlugin {
    plugins {
        register(RELEASE_ARTIFACT) {
            id = "$RELEASE_GROUP.$RELEASE_ARTIFACT"
            implementationClass = "$id.MyPlugin"
        }
    }
    testSourceSets(sourceSets["integrationTest"])
    testSourceSets(sourceSets["functionalTest"])
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlinx("coroutines-core", VERSION_COROUTINES))
    "integrationTestImplementation"(gradleTestKit())
    "integrationTestImplementation"(kotlin("test-junit", VERSION_KOTLIN))
    "functionalTestImplementation"(gradleTestKit())
    "functionalTestImplementation"(kotlin("test-junit", VERSION_KOTLIN))
}

ktlint()

tasks {
    val deploy by registering {
        dependsOn("build")
        projectDir.resolve("build/libs").listFiles()?.forEach {
            it.renameTo(File(rootDir.resolve("example"), it.name))
        }
    }

    val integrationTest by registering(Test::class) {
        description = "Runs the integration tests."
        group = LifecycleBasePlugin.VERIFICATION_GROUP
        testClassesDirs = sourceSets["integrationTest"].output.classesDirs
        classpath = sourceSets["integrationTest"].runtimeClasspath
        mustRunAfter(test)
    }
    val functionalTest by registering(Test::class) {
        description = "Runs the functional tests."
        group = LifecycleBasePlugin.VERIFICATION_GROUP
        testClassesDirs = sourceSets["functionalTest"].output.classesDirs
        classpath = sourceSets["functionalTest"].runtimeClasspath
        mustRunAfter(test)
    }
    check { dependsOn(integrationTest, functionalTest) }

    dokkaJavadoc {
        dokkaSourceSets {
            "main" {
                sourceLink {
                    localDirectory.set(projectDir.resolve("src"))
                    remoteUrl.set(getReleaseSourceUrl())
                    remoteLineSuffix.set("#L")
                }
            }
        }
    }
    val javadocJar by registering(Jar::class) {
        archiveClassifier.set("javadoc")
        from(dokkaJavadoc)
        dependsOn(dokkaJavadoc)
    }
    val sourcesJar by registering(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }
}

publishJvm()