package dev.falsehonesty.utils

fun day(day: Int) = resource("/day${day}in.txt")

fun resource(name: String): List<String> = ::resource.javaClass.getResourceAsStream(name).bufferedReader().readLines()