// 15_고차함수3.kt
package ex15_3

// 고차 함수의 용도
// => 인자를 함수로 전달하는 경우
//    다양한 시나리오에서 동작하는 함수의 코드 중복을 없앨 수 있다.
// => 함수의 재사용성을 높일 수 있다.

fun filter(data: List<Int>, predicate: (Int) -> Boolean): List<Int> {
    val result = mutableListOf<Int>()

    for (e in data) {
        if (predicate(e)) {
            result.add(e)
        }
    }

    return result
}

fun isOdd(e: Int) = e % 2 == 1
fun isEven(e: Int) = e % 2 == 0

// (Int) -> Boolean

fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    val result1 = filter(list, ::isOdd)
    val result2 = filter(list, ::isEven)

    println(result1)
    println(result2)

    // 1. 익명 함수
    var result = filter(list, fun(e: Int): Boolean {
        return e % 2 == 0
    })
    println(result)


}