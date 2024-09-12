package com.example.myapplication

fun main() {
    val firstUserEmailId = "user_one@gmail.com"
    val firstUserOperatingSystem = ""
    // The following line of code assumes that you named your parameter as emailId.
    // If you named it differently, feel free to update the name.
    println(displayAlertMessage(firstUserOperatingSystem,firstUserEmailId))
    println()

    val secondUserOperatingSystem = "Windows"
    val secondUserEmailId = "user_two@gmail.com"

    println(displayAlertMessage(secondUserOperatingSystem, secondUserEmailId))
    println()

    val thirdUserOperatingSystem = "Mac OS"
    val thirdUserEmailId = "user_three@gmail.com"

    println(displayAlertMessage(thirdUserOperatingSystem, thirdUserEmailId))
    println()
}

// Define your displayAlertMessage() below this line.
fun displayAlertMessage(operatingSystem: String, emailId: String): String {
    if (operatingSystem == "Windows" || operatingSystem == "Mac OS") {
        return "There's a new sign-in request on $operatingSystem for your Google Account $emailId.\n"
    } else  {
        return "There's a new sign-in request on Unknown OS for your Google Account $emailId.\n"
    }

}