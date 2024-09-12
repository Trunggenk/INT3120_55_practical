package com.example.myapplication

fun main() {
    val Steps = 4000
    val caloriesBurned = pedometerStepsToCalories(Steps);
    println("Walking $Steps steps burns $caloriesBurned calories")
}

fun pedometerStepsToCalories(NumberOfSteps: Int): Double {
    val CaloriesBURNEDforEachStep = 0.04
    val TotalCALORIESburned = NumberOfSteps * CaloriesBURNEDforEachStep
    return TotalCALORIESburned
}