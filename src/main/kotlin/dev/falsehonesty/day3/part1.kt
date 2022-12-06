package dev.falsehonesty.day3

import dev.falsehonesty.utils.day

fun main() {
    val input = day(3)
    val totalPriority = input.sumOf { rucksack ->
        val compartmentSize = rucksack.length / 2
        val firstCompartment = rucksack.take(compartmentSize)
        val secondCompartment = rucksack.takeLast(compartmentSize)
        val sharedItem = firstCompartment.toSet().intersect(secondCompartment.toSet()).first()
        if (sharedItem.isLowerCase()) sharedItem - 'a' + 1 else sharedItem - 'A' + 27
    }
    println("Total priority: $totalPriority")
}