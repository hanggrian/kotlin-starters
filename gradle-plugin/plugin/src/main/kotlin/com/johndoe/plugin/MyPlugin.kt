package com.johndoe.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class MyPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.tasks.register("myTask") { task ->
            task.description = "Print a line"
            task.doLast {
                println("${ProjectImpl(project).count} characters")
            }
        }
    }
}
