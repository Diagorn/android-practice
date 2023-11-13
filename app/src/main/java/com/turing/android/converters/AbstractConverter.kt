package com.turing.android.converters

/**
 * Класс-конвертер дробных величин
 *
 * @author Diagorn
 */
abstract class AbstractConverter(
    private val coefficient: Double, // коэффициент конверсии
    val displayName: String // отображаемое на интерфейсе наименование
) {

    fun convert(argument: Double) : Double {
        return argument * coefficient
    }
}