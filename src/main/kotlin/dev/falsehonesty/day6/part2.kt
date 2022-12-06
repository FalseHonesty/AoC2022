package dev.falsehonesty.day6

import dev.falsehonesty.utils.day

fun main() {
    val input = day(6).first()
    val index = input.windowed(size = 14).indexOfFirst { it.toCharArray().distinct().size == 14 } + 14
    println("Index: $index")
}