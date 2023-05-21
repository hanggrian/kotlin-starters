package com.example.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.property

open class MyTask : DefaultTask() {
    @Input
    val line: Property<String> = project.objects.property()

    @TaskAction
    fun print() {
        println(line.get())
    }
}
