// 15_고차함수3.kt
package ex15_3

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
}