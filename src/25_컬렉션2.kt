// 25_컬렉션2.kt
package ex25_2

fun main() {
    val list = listOf(
        "Seoul", "Suwon", "Busan", "Yongin", "Daegu"
    )

    // 1. forEach - 순회
    // list.forEach { println(it) }
    // list.forEach(::println)

    // 2. map
    //   : transform
    //   List<T>   ->  map  -> List<U>
    list.map(String::lowercase)
        .forEach(::println)

    list.map(String::length)
        .forEach(::println)

}