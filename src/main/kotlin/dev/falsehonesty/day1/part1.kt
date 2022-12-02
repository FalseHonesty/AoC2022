package dev.falsehonesty.day1

import dev.falsehonesty.utils.day
import dev.falsehonesty.utils.splitWhen

fun main() {
    val input = day(1)
    val maxCalories = input.splitWhen { it.isEmpty() }.maxOf { calories -> calories.sumOf { it.toInt() } }
    println("Max calories: $maxCalories")
}