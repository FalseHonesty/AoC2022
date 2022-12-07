package dev.falsehonesty.day7

import dev.falsehonesty.utils.day
import dev.falsehonesty.utils.splitWhen

fun main() {
    data class Size(var size: Int)

    val input = day(7)
    val sizes = mutableMapOf<String, Size>()
    sizes["/"] = Size(0)
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

    val mustFree = 30_000_000 - (70_000_000 - sizes.getValue("/").size)
    val smallest = sizes.values.filter { it.size >= mustFree }.minBy { it.size }
    println("Can free directory with size: $smallest")
}
