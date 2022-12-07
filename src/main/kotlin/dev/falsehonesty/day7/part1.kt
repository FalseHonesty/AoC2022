package dev.falsehonesty.day7

import dev.falsehonesty.utils.day
import dev.falsehonesty.utils.splitWhen

fun main() {
    data class Size(var size: Int)

    val input = day(7)
    val sizes = mutableMapOf<String, Size>()
    var currentDirectory = "/"

    input.splitWhen(includeBoundary = true) { it.startsWith("$") }.forEach { list ->
        val command = list.first().split(" ")
        when (command[1]) {
            "cd" -> currentDirectory = when (command[2]) {
                ".." -> currentDirectory.take(currentDirectory.dropLast(1).indexOfLast { it == '/' }) + "/"
                "/" -> "/"
                else -> {
                    val newDirectory = currentDirectory + "${command[2]}/"
                    sizes.putIfAbsent(newDirectory, Size(0))
                    newDirectory
                }
            }
            "ls" -> {
                val parentDirectories = sizes.filterKeys { currentDirectory.startsWith(it) }
                list.drop(1).filter { !it.startsWith("dir") }.forEach { listing ->
                    val size = listing.split(" ")[0].toInt()
                    parentDirectories.forEach { it.value.size += size }
                }
            }
        }
    }
    val totalSize = sizes.values.filter { it.size <= 100_000 }.sumOf { it.size }
    println("Value: $totalSize")
}
