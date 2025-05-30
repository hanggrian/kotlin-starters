package com.johndoe.plugin

import com.google.common.truth.Truth.assertThat
import org.gradle.api.Project
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.Test

@RunWith(MockitoJUnitRunner::class)
class ProjectImplTest {
    @Mock private lateinit var project: Project

    @Test
    fun test() {
        `when`(project.name).thenReturn("Hello World")
        assertThat(ProjectImpl(project).count).isEqualTo(11)
        verify(project).name
    }
}
