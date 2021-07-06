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

    // 코틀린에서 객체를 복사할 때 사용하는 방법.
    fun copy(name: String = this.name, age: Int = this.age): User {
        return User(name, age)
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

    // 2. 동등성 판단 : equals / hashCode
    println(user1 == user2)

    // 3. 객체 복제
    //  Java: clone - "clone"은 문제가 있습니다.
    //  Kotlin: clone X
    //          finalize X
    //    finalize: 객체가 GC에 의해 수거되는 시점에 호출되는 메소드
    //     1. 정확한 호출 시점을 알 수 없다.
    //     2. 자식 클래스가 재정의하고, 부모의 finalize을 명시적으로 호출하지
    //        않는다면, 호출되지 않는다.
    //     3. 호출이 보장되지 않습니다.
    val user3 = user1.copy()
    val user4 = user1.copy(name = "Bob")  // "Bob" / 42
    val user5 = user1.copy(age = 100)     // "Tom" / 100

    println(user3)
    println(user4)
    println(user5)

    // 4. 비구조화 선언
    val list = listOf(user1, user2, user3, user4, user5)
    // List<User>
    for (e in list) {
        println("name=${e.name}, age=${e.age}")
    }

    for ((name, age) in list) {
        println("$name / $age")
    }

}