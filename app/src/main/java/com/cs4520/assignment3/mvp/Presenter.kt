package com.cs4520.assignment3.mvp

import com.cs4520.assignment3.Model

class Presenter(private val view: MVPFragment) {
    private val model = Model()

    fun onAdd(num1: Double, num2: Double) {
        val result = model.add(num1, num2)
        if (java.lang.Double.isNaN(result)) {
            view.onError("Enter two numbers.")
            view.setResultText("")
        } else {

            view.setResultText("Result: $result")
        }
    }

    fun onSubtract(num1: Double, num2: Double) {
        val result = model.subtract(num1, num2)
        if (java.lang.Double.isNaN(result)) {
            view.onError("Enter two numbers.")
            view.setResultText("")
        } else {

            view.setResultText("Result: $result")
        }
    }

    fun onMultiply(num1: Double, num2: Double) {
        val result = model.multiply(num1, num2)
        if (java.lang.Double.isNaN(result)) {
            view.onError("Enter two numbers.")
            view.setResultText("")
        } else {

            view.setResultText("Result: $result")
        }
    }

    fun onDivide(num1: Double, num2: Double) {
        if (num2 == 0.0) {
            view.onError("Cannot divide by zero.")
            view.setResultText("")
            return
        }

        val result = model.divide(num1, num2)
        if (java.lang.Double.isNaN(result)) {
            view.onError("Enter two numbers.")
            view.setResultText("")
        } else {

            view.setResultText("Result: $result")
        }
    }
}