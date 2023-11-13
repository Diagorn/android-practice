package com.turing.android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.turing.android.converters.AbstractConverter
import com.turing.android.converters.CurrencyConverter
import com.turing.android.converters.LengthConverter
import com.turing.android.converters.WeightConverter

/**
 * Активити конверсии величин
 *
 * @author Diagorn
 */
class MainActivity : AppCompatActivity() {

    /**
     * Мапа нужных конвертеров под нужные величины
     * key = айдишник радиокнопки типа конверсии
     * value = конвертер этой величины
     */
    private val convertersMap = mapOf(
        R.id.weight_radio_button to WeightConverter(),
        R.id.length_radio_button to LengthConverter(),
        R.id.currency_radio_button to CurrencyConverter()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        val convertButton: Button = findViewById(R.id.convert_button)
        val resultTextView: TextView = findViewById(R.id.result_text_view)
        val inputText: EditText = findViewById(R.id.input_text)
        var activeConverter: AbstractConverter = getActiveConverter(radioGroup.checkedRadioButtonId)
        val conversionTypeView: TextView = findViewById(R.id.conversion_type_display_text_view)

        conversionTypeView.text = activeConverter.displayName

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            activeConverter = getActiveConverter(checkedId)
            conversionTypeView.text = activeConverter.displayName
            resultTextView.text = ""
        }

        convertButton.setOnClickListener {
            val input = inputText.text.toString()

            when {
                input.isEmpty() -> {
                    showToast(getString(R.string.conversion_empty_input))
                    return@setOnClickListener
                }

                input.toDouble() <= 0.0 -> {
                    showToast(getString(R.string.conversion_below_zero_input))
                    return@setOnClickListener
                }

                else -> {
                    resultTextView.text = activeConverter.convert(input.toDouble()).toString()
                    showToast(getString(R.string.conversion_success))
                }
            }
        }
    }

    /**
     * Достает текущий активный конвертер под выбор пользователя
     */
    private fun getActiveConverter(activeRadioButtonId: Int): AbstractConverter {
        return convertersMap.getOrDefault(activeRadioButtonId, WeightConverter())
    }

    /**
     * Показать тоаст с кастомным сообщением
     */
    private fun showToast(toastMessage: String) {
        Toast
            .makeText(this, toastMessage, Toast.LENGTH_LONG)
            .show()
    }
}