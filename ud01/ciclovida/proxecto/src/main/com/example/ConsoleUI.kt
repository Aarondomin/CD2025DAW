package com.example

import com.example.Calculator

class ConsoleUI(private val calculator: Calculator = Calculator()) {

    fun run() {
        while (true) {
            println(
                """
                === Calculadora (Kotlin) ===
                1) Sumar
                2) Restar
                3) Multiplicar
                4) Dividir
                0) Saír
                Elixe unha opción:
                """.trimIndent()
            )

            when (readLine()?.trim()) {
                "1" -> operate("suma") { a, b -> calculator.add(a, b) }
                "2" -> operate("resta") { a, b -> calculator.sub(a, b) }
                "3" -> operate("multiplicación") { a, b -> calculator.mul(a, b) }
                "4" -> operate("división") { a, b -> calculator.div(a, b) }
                "0" -> {
                    println("Ata logo!")
                    return
                }
                else -> println("Opción non válida.")
            }
            println()
        }
    }

    private fun operate(nome: String, op: (Double, Double) -> Double) {
        val a = readNumber("Introduce o primeiro número:")
        val b = readNumber("Introduce o segundo número:")
        try {
            val res = op(a, b)
            println("Resultado da $nome: $res")
        } catch (e: IllegalArgumentException) {
            println("Erro: ${e.message}")
        }
    }

    private fun readNumber(prompt: String): Double {
        while (true) {
            print("$prompt ")
            val input = readLine()?.trim()
            val num = input?.toDoubleOrNull()
            if (num != null) return num
            println("Entrada non válida. Usa punto como separador decimal (ex.: 3.14).")
        }
    }
}