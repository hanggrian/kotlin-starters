package com.johndoe.plugin

import org.gradle.api.Project

public class ProjectImpl(protected val project: Project) {
    public val count: Int get() = project.name.length
}
