// 19_지역반환
package ex19

class Person(val name: String)

// 1. for-loop
fun lookForAlice1(people: List<Person>) {
    for (person in people) {
        if (person.name == "Alice") {
            println("Found!")
            // return
            // break
        }
    }

    println("Failed to find Alice")
}

fun lookForAlice3(people: List<Person>) {
    for (person in people) {
        if (person.name != "Alice") {
            continue
        }

        println("Found!")
    }

    println("Failed to find Alice")
}

fun lookForAlice4(people: List<Person>) {
    people.forEach { person ->

        run {
            if (person.name != "Alice") {
                return@run    // continue
            }

            println("Found!")
        }
    }

    println("Failed to find Alice")
}





// * 람다 표현식은 함수가 아닙니다.
//   람다 표현식은 비지역 반환을 수행합니다.

// * 지역 반환


inline fun <T> Iterable<T>.forEach2(action: (T) -> Unit) {
    for (element in this) action(element)
}

// 2. forEach - lambda expression
fun lookForAlice2(people: List<Person>) {

    people.forEach2 { person ->
        if (person.name == "Alice") {
            println("Found!")          //                      for-loop
            return                     // 비지역 반환 - inline  :   return
            // return@forEach2         // 지역 반환                break
        }
    }

    println("Failed to find Alice")
}

// 3. forEach - anonymous function
fun lookForAlice5(people: List<Person>) {
    people.forEach(fun(person) {
        if (person.name == "Alice") {
            println("Found!")
            return
        }
    })
    println("Failed to find Alice")
}

// 1.
//    Found!

// 2.
//    Found!
//    "Failed to find Alice"


fun main() {
    val list = listOf(
        Person("Tom"),
        Person("Bob"),
        Person("Alice"),
    )

    lookForAlice5(list)
}