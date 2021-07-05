// 05_프로퍼티2.kt
package ex5_2


// Backing Field가 없는 프로퍼티
class Person(
    var firstName: String,
    var lastName: String
) {
    val fullName: String
        get() {
            return "$firstName, $lastName"
        }
}

fun main() {
    val person = Person("Gildong", "Hong")
    println(person.fullName)
}