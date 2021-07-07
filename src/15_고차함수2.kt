// 15_고차함수2.kt
package ex15_2

import java.util.function.Predicate

// 인터페이스 기반 정책으로 분리합니다.
// => 동작 파라미터화 설계

//interface Predicate<E> {
//    fun test(e: E): Boolean
//}

fun filter(data: List<Int>, predicate: Predicate<Int>): List<Int> {
    val result = mutableListOf<Int>()

    for (e in data) {
        if (predicate.test(e)) { // !!!
            result.add(e)
        }
    }

    return result
}

// Predicate 인터페이스를 기반으로 정책 클래스를 만듭니다.
object EvenPredicate : Predicate<Int> {
    override fun test(e: Int): Boolean = e % 2 == 0
}

object OddPredicate : Predicate<Int> {
    override fun test(e: Int): Boolean = e % 2 == 1
}


fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val result1 = filter(list, EvenPredicate)
    val result2 = filter(list, OddPredicate)

    println(result1)
    println(result2)

    // 익명 객체를 기반으로 정책을 전달할 수 있습니다.
    val result3 = filter(list, object: Predicate<Int> {
        override fun test(t: Int): Boolean {
            return t % 2 == 0
        }
    })

    println(result3)
}





