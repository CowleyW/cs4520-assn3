package com.cs4520.assignment3.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cs4520.assignment3.Model

class MVVMViewModel : ViewModel() {
    private val result = MutableLiveData<String>()
    val resultBinding: LiveData<String> = result
    private val model: Model = Model()

    fun onAdd(num1: Double, num2: Double) {
        val res = model.add(num1, num2)
        if (java.lang.Double.isNaN(res)) {
            result.value = "ERRNAN"
        } else {
            result.value = "Result: $res"
        }
    }

    fun onSubtract(num1: Double, num2: Double) {
        val res = model.subtract(num1, num2)
        if (java.lang.Double.isNaN(res)) {
            result.value = "ERRNAN"
        } else {
            result.value = "Result: $res"
        }
    }

    fun onMultiply(num1: Double, num2: Double) {
        val res = model.multiply(num1, num2)
        if (java.lang.Double.isNaN(res)) {
            result.value = "ERRNAN"
        } else {
            result.value = "Result: $res"
        }
    }

    fun onDivide(num1: Double, num2: Double) {
        if (num2 == 0.0) {
            result.value = "ERRINF"
            return
        }

        val res = model.divide(num1, num2)
        if (java.lang.Double.isNaN(res)) {
            result.value = "ERRNAN"
        } else {
            result.value = "Result: $res"
        }
    }
}