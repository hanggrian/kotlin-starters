package com.hendraanggrian.generator.dependencies

import com.hendraanggrian.kotlinpoet.FileSpecBuilder

object GitPublish : Dependency("gitpublish") {

    override fun FileSpecBuilder.initialize() {
        properties {
            bintrayVal("VERSION_GIT_PUBLISH", "ajoberstar", "maven", "gradle-git-publish")
        }
        functions {
            dependencyFun("gitPublish") {
                append("return %P", "org.ajoberstar:gradle-git-publish:\$VERSION_GIT_PUBLISH")
            }
        }
        properties.pluginVal("git-publish") {
            append("return id(%S)", "org.ajoberstar.git-publish")
        }
    }
}