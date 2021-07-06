// 08_데이터클래스.kt
package ex8

// VO(Value Object)
// DTO(Data Transfer Object)
/*
class User(val name: String, val age: Int) {
    override fun toString(): String {
        return "User{name=$name, age=$age}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (name != other.name) return false
        if (age != other.age) return false
        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + age
        return result
    }
}
*/

data class User(val name: String, val age: Int)

fun main() {
    val user1 = User("Tom", 42)
    val user2 = User("Tom", 42)

    // 1. 객체를 문자열로 표현하는 방법
    //   : toString()
    println(user1)
    println(user2)

    // 2. 동등성 판단 - equals / hashCode
    println(user1 == user2)

    // 3. 객체 복제
}