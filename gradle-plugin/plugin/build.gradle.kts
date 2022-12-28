plugins {
    `java-gradle-plugin`
    `kotlin-dsl` version libs.versions.gradle.kotlin.dsl
    kotlin("jvm") version libs.versions.kotlin
    alias(libs.plugins.dokka)
    alias(libs.plugins.gradle.publish)
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
    plugins.register("myPlugin") {
        id = "$RELEASE_GROUP.plugin"
        implementationClass = "$id.MyPlugin"
        displayName = "My plugin"
        description = RELEASE_DESCRIPTION
    }
    testSourceSets(sourceSets["integrationTest"])
    testSourceSets(sourceSets["functionalTest"])
}

kotlin.jvmToolchain(libs.versions.jdk.get().toInt())

pluginBundle {
    website = RELEASE_URL
    vcsUrl = "$RELEASE_URL.git"
    description = RELEASE_DESCRIPTION
    tags = listOf("hello", "world")
}

val integrationTestImplementation by configurations.getting
val functionalTestImplementation by configurations.getting

dependencies {
    ktlint(libs.ktlint, ::configureKtlint)
    ktlint(libs.rulebook.ktlint)
    implementation(libs.kotlinx.coroutines)
    integrationTestImplementation(gradleTestKit())
    integrationTestImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    integrationTestImplementation(libs.truth)
    functionalTestImplementation(gradleTestKit())
    functionalTestImplementation(kotlin("test-junit", libs.versions.kotlin.get()))
    functionalTestImplementation(libs.truth)
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
    check {
        dependsOn(/*integrationTest, */functionalTest)
    }

    dokkaHtml {
        outputDirectory.set(buildDir.resolve("dokka/dokka/"))
    }
}
