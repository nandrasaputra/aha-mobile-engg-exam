package com.nandra.ahaexamcalculator

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.nandra.ahaexamcalculator.databinding.ActivityMainBinding
import java.util.Locale


var appLanguage: Locale = Locale.getDefault()
var currentTheme: Int = 0

class MainActivity : AppCompatActivity() {
    private lateinit var view: View

    private lateinit var binding: ActivityMainBinding

    private val viewModel: CalculatorSharedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Themes
        val themes = Themes(this)
        themes.applyDayNightOverride()
        setTheme(themes.getTheme())

        currentTheme = themes.getTheme()

        binding = ActivityMainBinding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)

        setupView()
    }

    private fun setupView() {
        binding.rightButton?.setOnClickListener {
            viewModel.onArrowClick(R.id.calculatorFragment2)
        }

        binding.leftButton?.setOnClickListener {
            viewModel.onArrowClick(R.id.calculatorFragment)
        }
    }
}