group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
    dokka
    `gradle-publish`
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
    val simplePlugin by plugins.registering {
        id = "$RELEASE_GROUP.plugin"
        implementationClass = "$RELEASE_GROUP.plugin.MyPlugin"
        displayName = "My Plugin"
        description = RELEASE_DESCRIPTION
    }
    testSourceSets(sourceSets["integrationTest"])
    testSourceSets(sourceSets["functionalTest"])
}

ktlint()

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlinx("coroutines-core", VERSION_COROUTINES))
    "integrationTestImplementation"(gradleTestKit())
    "integrationTestImplementation"(kotlin("test-junit", VERSION_KOTLIN))
    "functionalTestImplementation"(gradleTestKit())
    "functionalTestImplementation"(kotlin("test-junit", VERSION_KOTLIN))
}

tasks {
    // TODO: find out why integration test is throwing
    //  "Test runtime classpath does not contain plugin metadata file 'plugin-under-test-metadata.properties'"
    /*val integrationTest by registering(Test::class) {
        description = "Runs the integration tests."
        group = LifecycleBasePlugin.VERIFICATION_GROUP
        testClassesDirs = sourceSets["integrationTest"].output.classesDirs
        classpath = sourceSets["integrationTest"].runtimeClasspath
        mustRunAfter(test)
    }*/
    val functionalTest by registering(Test::class) {
        description = "Runs the functional tests."
        group = LifecycleBasePlugin.VERIFICATION_GROUP
        testClassesDirs = sourceSets["functionalTest"].output.classesDirs
        classpath = sourceSets["functionalTest"].runtimeClasspath
        mustRunAfter(test)
    }
    check { dependsOn(/*integrationTest, */functionalTest) }

    dokkaHtml {
        outputDirectory.set(buildDir.resolve("dokka/$RELEASE_ARTIFACT"))
    }
}

pluginBundle {
    website = RELEASE_GITHUB
    vcsUrl = "$RELEASE_GITHUB.git"
    description = RELEASE_DESCRIPTION
    tags = listOf("hello", "world")
}