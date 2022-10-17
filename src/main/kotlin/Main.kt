import models.User
import utils.isValidInRange
import utils.readValidEmail
import utils.validGender

val user = User()

fun main(){
    println("Welcome to Health Tracker")
    runApp()
}

fun runApp(){
    var input: Int
    do {
        input = menu()
        when(input) {
            1 -> addUser()
            2 -> listUser()
            in(3..6) -> println("Feature coming soon")
            0 -> println("Bye...")
            else -> print("Invalid Option")
        }
    } while (input != 0)
}

fun menu(): Int{
    print("""
        |Main Menu:
        |  1. Add User
        |  2. List User
        |  0. Exit
        |Please enter your option: """.trimMargin())
    return readLine()?.toIntOrNull() ?: -1
}

fun addUser(){
    println("Please enter the following for the user:")
    print("    Name: ")
    user.name = readLine()!!
    user.email = readValidEmail()
    print("    Id: ")
    user.id = readLine()?.toIntOrNull() ?: -1

    print ("   Height: ")
    val height = readLine()?.toFloatOrNull() ?: 0f
    if (isValidInRange(0.5,3.0, height.toDouble()))
        user.height = height
    else
        user.height = 0f

    print ("   Weight: ")
    val weight = readLine()?.toDoubleOrNull() ?: .0
    if (isValidInRange(25.0,500.0, weight))
        user.weight = weight
    else
        user.weight = 0.0

    print ("   Gender: ")
    user.gender = validGender(readLine()!!.getOrNull(0) ?: ' ')

}

fun listUser(){
    print("The user details are: $user")
}