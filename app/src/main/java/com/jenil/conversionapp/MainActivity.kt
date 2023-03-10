package com.jenil.conversionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.jenil.conversionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val units = arrayOf("km", "mi", "m", "ft", "yd", "cm", "mm")
    var answer = 0.0
    var answerArray = mutableListOf<Double>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, units)
        binding.spDest.adapter = adapter
        binding.spSource.adapter = adapter

        binding.btnConvert.setOnClickListener {
            if (binding.etAmount.text.isEmpty()) {
                binding.etAmount.error = "Please enter amount"
            } else {
                println(binding.spDest.selectedItemPosition)
                val result =
                    answerArray[binding.spDest.selectedItemPosition] * binding.etAmount.text.toString()
                        .toDouble()
                binding.tvAnswer.text = result.toString()
            }
        }

        binding.spSource.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    0 -> {
                        answerArray =
                            arrayOf(
                                1.0,
                                0.621371,
                                1000.0,
                                3280.84,
                                1093.61,
                                100000.0,
                                1000000.0
                            ).toMutableList()
                    }
                    1 -> {
                        answerArray =
                            arrayOf(
                                1.60934,
                                1.0,
                                1609.34,
                                5280.0,
                                1760.0,
                                160934.0,
                                1609344.0
                            ).toMutableList()
                    }
                    2 -> {
                        answerArray =
                            arrayOf(
                                0.001,
                                0.000621371,
                                1.0,
                                3.28084,
                                1.09361,
                                100.0,
                                1000.0
                            ).toMutableList()
                    }
                    3 -> {
                        answerArray =
                            arrayOf(
                                0.0003048,
                                0.000189394,
                                0.3048,
                                1.0,
                                0.33333,
                                30.48,
                                304.8
                            ).toMutableList()
                    }
                    4 -> {
                        answerArray =
                            arrayOf(
                                0.0009144,
                                0.000568182,
                                0.9144,
                                3.0,
                                1.0,
                                91.44,
                                914.4
                            ).toMutableList()
                    }
                    5 -> {
                        answerArray =
                            arrayOf(
                                0.00001,
                                0.0000062137,
                                0.01,
                                0.010936133,
                                0.0328,
                                1.0,
                                10.0
                            ).toMutableList()
                    }
                    6 -> {
                        answerArray =
                            arrayOf(
                                1.0 / 1000000.0,
                                1.0 / 1609344.0,
                                1.0 / 1000.0,
                                1.0 / 0.001094,
                                1.0 / 305.0,
                                1.0 / 10.0,
                                1.0
                            ).toMutableList()
                    }
                }
            }
        }
    }
}