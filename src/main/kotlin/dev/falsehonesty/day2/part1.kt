package dev.falsehonesty.day2

import dev.falsehonesty.utils.day

fun main() {
    val input = day(2)
    val totalScore = input.sumOf {
        val shape = it[2] - 'X'
        val opponentShape = it[0] - 'A'
        val outcomeScore = when (shape) {
            opponentShape -> 3
            (opponentShape + 1) % 3 -> 6
            else -> 0
        }
        outcomeScore + (shape + 1)
    }
    println("Total score: $totalScore")
}