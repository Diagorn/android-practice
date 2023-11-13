package com.turing.android.converters

private const val CURRENCY_COEF = 91.45 // Актуально на 13 ноября 19:09. TODO: по возможности переделать на запрос к API
private const val CURRENCY_NAME = "Доллары в рубли"

/**
 * Конвертер фунтов в килограммы
 *
 * @author Diagorn
 */
class CurrencyConverter : AbstractConverter(CURRENCY_COEF, CURRENCY_NAME)