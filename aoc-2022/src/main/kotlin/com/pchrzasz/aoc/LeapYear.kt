package com.pchrzasz.aoc

fun main() {
    println("Hello, world!!!")
    println(isLeapYear(2000))
    println(isLeapYear(1900))
}

fun isLeapYear(year: Int): Boolean {
    return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
}
