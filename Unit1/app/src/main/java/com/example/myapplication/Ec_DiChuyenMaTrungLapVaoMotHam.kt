package com.example.myapplication

fun main() {
    val city1 = "Ankara"
    val low1 = 27
    val high1 = 31
    val rain1 = 82
    val city2 = "Tokyo"
    val low2 = 32
    val high2 = 36
    val rain2 = 10
    val city3 = "Cape Town"
    val low3 = 59
    val high3 = 64
    val rain3 = 2
    val city4 = "Guatemala City"
    val low4 = 50
    val high4 = 55
    val rain4 = 7
    printWeather(city1, low1, high1, rain1)
    printWeather(city2, low2, high2, rain2)
    printWeather(city3, low3, high3, rain3)
    printWeather(city4, low4, high4, rain4)

}

fun printWeather(city: String, low: Int, high: Int, rain: Int) {
    println("City: $city")
    println("Low temperature: $low, High temperature: $high")
    println("Chance of rain: $rain%")
    println()
}