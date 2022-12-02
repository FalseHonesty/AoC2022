package dev.falsehonesty.day1

import dev.falsehonesty.utils.day
import dev.falsehonesty.utils.splitWhen

fun main() {
    val input = day(1)
    val sumOfTopThree = input.splitWhen { it.isEmpty() }
        .map { calories -> calories.sumOf { it.toInt() } }
        .sortedDescending()
        .take(3)
        .sum()
    println("Sum of top three calorie counts: $sumOfTopThree")
}