package dev.falsehonesty.day3

import dev.falsehonesty.utils.day

fun main() {
    val input = day(3)
    val totalPriority = input.windowed(size = 3, step = 3).sumOf { rucksacks ->
        val sharedItem = rucksacks.map { it.toSet() }.reduce(Set<Char>::intersect).first()
        if (sharedItem.isLowerCase()) sharedItem - 'a' + 1 else sharedItem - 'A' + 27
    }
    println("Total priority: $totalPriority")
}