package com.example.bmiviewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BMIViewModel: ViewModel() {
    var heightInput by  mutableStateOf("")
    var weightInput by  mutableStateOf("")
    var bmivalue by mutableStateOf("")

    init {
        calculateBMI()
    }


    private fun calculateBMI() {
        val height = heightInput.toDoubleOrNull() ?: 0.0
        val weight = weightInput.toDoubleOrNull() ?: 0.0
        if (height > 0.0 && weight > 0.0) {
            val bmi = weight / (height * height)
            bmivalue = String.format("%.2f", bmi)
        } else {
            bmivalue = ""
        }
    }
    fun onHeightInputChange(newHeight: String) {
        heightInput = newHeight
        calculateBMI()
    }

    fun onWeightInputChange(newWeight: String) {
        weightInput = newWeight
        calculateBMI()
    }

}