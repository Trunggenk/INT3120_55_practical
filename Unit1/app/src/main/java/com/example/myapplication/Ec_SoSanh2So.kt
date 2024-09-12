package com.example.myapplication

fun main() {
    var timeSpentToday: Int = 0
    var timeSpentYesterday: Int = 0
    var s = readLine()
    if (s != null) {
        timeSpentToday = s.toInt()
    }
    s = readLine()
    if (s != null) {
        timeSpentYesterday = s.toInt()
    }
    println(compareTimeSpent(timeSpentToday, timeSpentYesterday))
}

fun compareTimeSpent(timeSpentToday: Int, timeSpentYesterday: Int): Boolean {
    return timeSpentToday > timeSpentYesterday
}