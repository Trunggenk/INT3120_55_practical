package com.example.myapplication

fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8

    val result = add(firstNumber, secondNumber)
    val anotherResult = add(firstNumber, thirdNumber)

    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $anotherResult")
    println("$firstNumber - $secondNumber = ${subtract(firstNumber, secondNumber)}")
    println("$firstNumber - $thirdNumber = ${subtract(firstNumber, thirdNumber)}")

}

// Define add() function below this line
fun add(a: Int, b: Int): Int {
    return a + b
}
fun subtract(a: Int, b: Int): Int {
    return a - b
}