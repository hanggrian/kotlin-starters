import org.gradle.api.Project

val Dependencies.`gradle-publish` get() = "com.gradle.publish:plugin-publish-plugin:0.13.0"
val Plugins.`gradle-publish` get() = id("com.gradle.plugin-publish")

fun Project.gradlePublish(vararg tags: String) {
    checkNotNull(plugins.findPlugin("com.gradle.plugin-publish")) { "Missing plugin `java-gradle-plugin` for this publication" }
    extensions.configure<com.gradle.publish.PluginBundleExtension>("pluginBundle") {
        website = RELEASE_GITHUB
        vcsUrl = RELEASE_GITHUB
        description = RELEASE_DESCRIPTION
        setTags(tags.asList())
    }
}