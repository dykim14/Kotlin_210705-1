// 09_object3.kt
package ex9_3

// 1. 동반 객체는 상속이나 인터페이스를 구현할 수 있습니다.
// JSONObject
//   Java: Map<String, Object>
// Kotlin: Map<String, Any>

interface MapFactory<T> {
    fun fromMap(map: Map<String, Any>): T
}

data class Person(val name: String, val age: Int) {
    companion object : MapFactory<Person> {
        override fun fromMap(map: Map<String, Any>): Person {
            val name = map["name"] as String
            val age = map["age"] as Int
            return Person(name, age)
        }
    }
}

data class User(val name: String) {
    companion object : MapFactory<User> {
        override fun fromMap(map: Map<String, Any>): User {
            val name = map["name"] as String
            return User(name)
        }
    }
}

fun <T> fromJson(json: Map<String, Any>, factory: MapFactory<T>): T {
    return factory.fromMap(json)
}

fun main() {
    val json = mapOf(
        "name" to "Tom",
        "age" to 42,
    )

    val person: Person = fromJson(json, Person)
    val user: User = fromJson(json, User)

    println(user)
    println(person)
}






