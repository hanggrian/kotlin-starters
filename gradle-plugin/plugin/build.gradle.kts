group = RELEASE_GROUP
version = RELEASE_VERSION

plugins {
    `kotlin-dsl`
    dokka
    `gradle-publish`
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(8))
    }
}

sourceSets {
    register("integrationTest") {
        java.srcDir("src/integrationTest/kotlin")
        resources.srcDir("src/integrationTest/resources")
        compileClasspath += sourceSets.main.get().output + configurations.testRuntimeClasspath
        runtimeClasspath += output + compileClasspath
    }
    register("functionalTest") {
        java.srcDir("src/functionalTest/kotlin")
        resources.srcDir("src/functionalTest/resources")
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

pluginBundle {
    website = RELEASE_GITHUB
    vcsUrl = "$RELEASE_GITHUB.git"
    description = RELEASE_DESCRIPTION
    tags = listOf("hello", "world")
}

dependencies {
    implementation(kotlin("stdlib", VERSION_KOTLIN))
    implementation(kotlinx("coroutines-core", VERSION_COROUTINES))
    "integrationTestImplementation"(gradleTestKit())
    "integrationTestImplementation"(kotlin("test-junit", VERSION_KOTLIN))
    "integrationTestImplementation"(google("truth", version = VERSION_TRUTH))
    "functionalTestImplementation"(gradleTestKit())
    "functionalTestImplementation"(kotlin("test-junit", VERSION_KOTLIN))
    "functionalTestImplementation"(google("truth", version = VERSION_TRUTH))
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
        outputDirectory.set(buildDir.resolve("dokka/dokka"))
    }
}

ktlint()