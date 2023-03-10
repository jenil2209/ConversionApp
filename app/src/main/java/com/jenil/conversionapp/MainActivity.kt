package com.jenil.conversionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.jenil.conversionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val units = arrayOf("km", "mi", "m", "ft", "yd", "cm", "mm")

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

            }
        }
    }
}