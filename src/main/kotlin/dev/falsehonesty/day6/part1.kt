package dev.falsehonesty.day6

import dev.falsehonesty.utils.day

fun main() {
    val input = day(6).first()
    val index = input.windowed(size = 4).indexOfFirst { it.toCharArray().distinct().size == 4 } + 4
    println("Index: $index")
}
