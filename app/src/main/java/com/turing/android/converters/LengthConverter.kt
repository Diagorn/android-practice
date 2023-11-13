package com.turing.android.converters

private const val LENGTH_COEF = 2.54
private const val LENGTH_NAME = "Дюймы в сантиметры"

/**
 * Конвертер дюймов в сантиметры
 *
 * @author Diagorn
 */
class LengthConverter : AbstractConverter(LENGTH_COEF, LENGTH_NAME)