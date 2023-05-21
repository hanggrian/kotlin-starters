package com.example.plugin

import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property

open class MyExtension(project: Project) {
    val line: Property<String> = project.objects.property()
}
