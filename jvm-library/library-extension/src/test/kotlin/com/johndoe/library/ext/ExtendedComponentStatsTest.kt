package com.johndoe.library.ext

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import java.awt.Component
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class ExtendedComponentStatsTest {
    @Mock private lateinit var component: Component

    @Test
    fun test() {
        `when`(component.getX()).thenReturn(0)
        `when`(component.getY()).thenReturn(1)
        assertThat(ExtendedComponentStats(component).position).isEqualTo("(0,1)")
        verify(component).getX()
        verify(component).getY()
    }
}
