package dev.falsehonesty.day4

import dev.falsehonesty.utils.day

fun main() {
    val input = day(4)
    val count = input.count { line ->
        val (first, second) = line.split(",").map { range ->
            range.split("-")
                .let { (start, end) -> start.toInt()..end.toInt() }
                .toSet()
        }
        first.intersect(second).isNotEmpty()
    }
    println("Total count: $count")
}