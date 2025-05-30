package com.johndoe.library.ext

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import javax.swing.JLabel
import kotlin.test.Test

@ExtendWith(MockitoExtension::class)
class JLabelExtImplTest {
    @Mock private lateinit var label: JLabel

    @Test
    fun test() {
        `when`(label.getX()).thenReturn(0)
        `when`(label.getY()).thenReturn(1)
        assertThat(JLabelExtImpl(label).position).isEqualTo("(0,1)")
        verify(label).getX()
        verify(label).getY()
    }
}
