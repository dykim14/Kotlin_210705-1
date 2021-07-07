// 21_메모이제이션2.kt
package ex21

import com.google.gson.Gson

class User(
    val name: String,
    val age: Int,
    val address: String,
    val level: Int
)

class Car(
    var name: String,
    val type: String,
    val speed: Int
)

fun main() {
    val user = User("Tom", 42, "Suwon", 1)
    val car = Car("BMW", "Sedan", 100)

    // Gson
    val gson = Gson()
    val json1 = gson.toJson(user)
    val json2 = gson.toJson(car)

    println(json1)
    println(json2)
}



