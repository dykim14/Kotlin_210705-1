// 05_프로퍼티2.kt
package ex5_2


// Backing Field가 없는 프로퍼티
//  => field 키워드를 사용할 수 없습니다.
class Person(
    var firstName: String,
    var lastName: String
) {
    var fullName: String
        get() {
            return "$firstName, $lastName"
        }
        set(value) {
            val arr = value.split(", ")
            firstName = arr[0]
            lastName = arr[1]
        }
}

fun main() {
    val person = Person("Gildong", "Hong")
    println(person.fullName)

    person.fullName = "Soonshin, Lee"
    println(person.firstName)
    println(person.lastName)
}