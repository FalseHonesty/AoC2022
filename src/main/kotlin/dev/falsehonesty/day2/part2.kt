package dev.falsehonesty.day2

import dev.falsehonesty.utils.day

fun main() {
    val input = day(2)
    val totalScore = input.sumOf {
        val outcome = it[2] - 'X'
        val opponentShape = it[0] - 'A'
        val shape = when (outcome) {
            0 -> (opponentShape + 2) % 3
            1 -> opponentShape
            else -> (opponentShape + 1) % 3
        }
        (outcome * 3) + (shape + 1)
    }
    println("Total score: $totalScore")
}