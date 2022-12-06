package dev.falsehonesty.day5

import dev.falsehonesty.utils.day

fun main() {
    val input = day(5)
    val stackIdLine = input.indexOfFirst { it.startsWith(" 1 ") }
    val stacks = input[stackIdLine].mapIndexedNotNull { index, c ->
        if (!c.isDigit())
            return@mapIndexedNotNull null
        val stack = ArrayDeque<Char>()
        for (line in 0 until stackIdLine) {
            val char = input[line].getOrNull(index) ?: continue
            if (!char.isLetter()) continue
            stack.addLast(char)
        }
        stack
    }
    for (instruction in input.drop(stackIdLine + 2)) {
        val (count, from, to) = Regex("""move (\d+) from (\d+) to (\d+)""").matchEntire(instruction)!!.destructured
        val toAdd = (0 until count.toInt()).map { stacks[from.toInt() - 1].removeFirst() }.reversed()
        toAdd.forEach { stacks[to.toInt() - 1].addFirst(it) }
    }
    println("Tops: ${stacks.joinToString(separator = "") { it.first().toString() }}")
}