package com.johndoe.application

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.verify
import java.awt.Component
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class ComponentStatsTest {
    @Mock private lateinit var component: Component

    @Test
    fun test() {
        `when`(component.getWidth()).thenReturn(2)
        `when`(component.getHeight()).thenReturn(4)
        assertThat(ComponentStats(component).size).isEqualTo(8)
        verify(component).getWidth()
        verify(component).getHeight()
    }
}
