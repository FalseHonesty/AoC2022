package dev.falsehonesty.utils

fun <T> List<T>.splitWhen(predicate: (T) -> Boolean): List<List<T>> {
    return flatMapIndexed { index: Int, value: T ->
        when {
            index == 0 || index == this.lastIndex -> listOf(index)
            predicate(value) -> listOf(index - 1, index + 1)
            else -> emptyList()
        }
    }.windowed(size = 2, step = 2) { (from, to) -> slice(from..to) }
}


fun <T> Iterable<T>.cycle() = generateSequence { this }.flatten()

fun <T> Collection<T>.eachCount() = this.groupingBy { it }.eachCount()