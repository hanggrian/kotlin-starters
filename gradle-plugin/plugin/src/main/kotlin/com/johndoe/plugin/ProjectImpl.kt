package com.johndoe.plugin

import org.gradle.api.Project

class ProjectImpl(protected val project: Project) {
    val count: Int get() = project.name.length
}
