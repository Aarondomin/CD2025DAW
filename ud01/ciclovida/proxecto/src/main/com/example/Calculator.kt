package com.example

class Calculator {
    fun add(a: Double, b: Double) = a + b
    fun sub(a: Double, b: Double) = a - b
    fun mul(a: Double, b: Double) = a * b
    fun div(a: Double, b: Double): Double {
        require(b != 0.0) { "Non se pode dividir entre 0." }
        return a / b
    }
}