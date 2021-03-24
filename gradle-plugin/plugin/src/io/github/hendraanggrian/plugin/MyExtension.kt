@file:Suppress("UnstableApiUsage")

package io.github.hendraanggrian.plugin

import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property

open class MyExtension(project: Project) {

    val line: Property<String> = project.objects.property()
}
