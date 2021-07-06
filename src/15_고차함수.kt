// 15_고차함수.kt
//  : 고차함수(Higher Order Function)
//  - 함수를 인자로 전달받거나, 함수를 반환하는 함수

package ex15

// Kotlin
//     List<E> : 수정이 불가능한 기능(읽기 전용) - Immutable
//       |
//  MutableList<E> : 수정에 대한 기능

//     Set<E>
//       |
//  MutableSet<E>

//    Map<K, V>
//       |
// MutableMap<K, V>

fun filterOdds(data: List<Int>): List<Int> {
    // val result = emptyList<Int>()
    val result = mutableListOf<Int>()

    for (e in data) {
        if (e % 2 == 1) {
            result.add(e)
        }
    }

    return result
}


fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)


}