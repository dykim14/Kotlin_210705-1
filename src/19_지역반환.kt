// 19_지역반환
package ex19

class Person(val name: String)

// 1. for-loop
fun lookForAlice1(people: List<Person>) {
    for (person in people) {
        if (person.name == "Alice") {
            println("Found!")
            return
            // break
        }
    }

    println("Failed to find Alice")
}

// 2. forEach
// 1.
//    Found!

// 2.
//    Found!
//    "Failed to find Alice"

// * 람다 표현식은 함수가 아닙니다.
//   람다 표현식은 비지역 반환을 수행합니다.

// * 지역 반환

fun lookForAlice2(people: List<Person>) {

    people.forEach { person ->
        if (person.name == "Alice") {
            println("Found!")
            // return              // 비지역 반환
            return@forEach         // 지역 반환
        }
    }

    println("Failed to find Alice")
}


fun main() {
    val list = listOf(
        Person("Tom"),
        Person("Bob"),
        Person("Alice"),
    )

    lookForAlice2(list)
}