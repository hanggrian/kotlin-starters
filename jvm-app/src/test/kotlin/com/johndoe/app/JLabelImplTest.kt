package com.johndoe.app

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import javax.swing.JLabel
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class JLabelImplTest {
    @Mock private lateinit var label: JLabel

    @Test
    fun test() {
        `when`(label.getWidth()).thenReturn(2)
        `when`(label.getHeight()).thenReturn(4)
        assertThat(JLabelImpl(label).size).isEqualTo(8)
        verify(label).getWidth()
        verify(label).getHeight()
    }
}
