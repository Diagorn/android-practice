package com.turing.android

import com.turing.android.converters.CurrencyConverter
import com.turing.android.converters.LengthConverter
import com.turing.android.converters.WeightConverter
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ConverterTest {
    @Test
    @DisplayName("Конвертер валют")
    fun itShouldConvertCurrencies() {
        // given
        val converter = CurrencyConverter()
        val expected = 91450.0

        // when
        val actual = converter.convert(1000.0)

        // then
        assertEquals(expected, actual)
    }

    @Test
    @DisplayName("Конвертер длины")
    fun itShouldConvertLengths() {
        // given
        val converter = LengthConverter()
        val expected = 2540.0

        // when
        val actual = converter.convert(1000.0)

        // then
        assertEquals(expected, actual)
    }

    @Test
    @DisplayName("Конвертер веса")
    fun itShouldConvertWeights() {
        // given
        val converter = WeightConverter()
        val expected = 453.592

        // when
        val actual = converter.convert(1000.0)

        // then
        assertEquals(expected, actual)
    }
}