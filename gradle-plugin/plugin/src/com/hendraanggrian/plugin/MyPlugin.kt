package com.hendraanggrian.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.registering

class MyPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val extension = project.extensions.create<MyExtension>("myPlugin", project)
        val myTask by project.tasks.registering(MyTask::class) {
            line.set(extension.line)
        }
    }
}
