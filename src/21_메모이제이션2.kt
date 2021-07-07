// 21_메모이제이션2.kt
package ex21

import com.google.gson.Gson
import com.google.gson.GsonBuilder

// 맵의 키 값으로 사용된다면, 반드시 hashCode / equals 를 제공해야 합니다.
// => data class
data class User(
    val name: String,
    val age: Int,
    val address: String,
    val level: Int
)

data class Car(
    var name: String,
    val type: String,
    val speed: Int
)

// (T) -> String
fun <T> T.toJSON(): String {
    println("T::toJSON")
    val gson = GsonBuilder()
        .setPrettyPrinting()
        .create()
    return gson.toJson(this)
}
//---------

// OCP: Open-Close Principle
//      개방 폐쇄의 원칙
//   => 수정에는 닫혀 있고, 확장에는 열려 있어야 한다.
//   => 새로운 기능이 추가되어도 기존 코드는 수정되면 안된다.

// 기존 함수에 메모이제이션의 기능을 추가한 함수를 만드는 함수
fun <A, B> ((A) -> B).memoized(): (A) -> B {
    val cache = mutableMapOf<A, B>()
    return { k ->
        cache.getOrPut(k) {
            this(k)
        }
    }
}


fun main() {
    val user1 = User("Tom", 42, "Suwon", 1)
    val user2 = User("Tom", 42, "Suwon", 1)

    val car = Car("BMW", "Sedan", 100)

    val userToJSON = User::toJSON.memoized()
    println(userToJSON(user1))
    println(userToJSON(user2))

    // Gson
    // val gson = Gson()
    // val json1 = gson.toJson(user)
    // val json2 = gson.toJson(car)

    // val json1 = user.toJSON()
    // val json2 = car.toJSON()

    // println(json1)
    // println(json2)
}



