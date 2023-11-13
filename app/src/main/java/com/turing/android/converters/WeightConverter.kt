package com.turing.android.converters

private const val WEIGHT_COEF = 0.453592
private const val WEIGHT_NAME = "Фунты в килограммы"

/**
 * Конвертер фунтов в килограммы
 *
 * @author Diagorn
 */
class WeightConverter : AbstractConverter(WEIGHT_COEF, WEIGHT_NAME)