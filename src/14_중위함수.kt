// 14_중위함수.kt
package ex14

// 1. Generic Function
// fun<K, V> pa(key: K, value: V) = Pair(key, value)

// 2. Extension Function
// fun<K, V> K.pa(value: V) = Pair(this, value)

// 3. 코틀린은 인자가 하나 뿐인 메소드 또는 확장 함수에 대해서
//    중위(infix) 함수를 사용할 수 있습니다.
infix fun <K, V> K.pa(value: V) = Pair(this, value)

fun main() {
    // Map<String, Any> : JSON
    // => Map은 Pair로 이루어져 있습니다.

    // val pair1 = Pair("name", "Tom")
    // val pair2 = Pair("age", 42)

    // val pair1 = pa("name", "Tom")
    // val pair2 = pa("age", 42)

    // val pair1 = "name".pa("Tom")
    // val pair2 = "age".pa(42)

    val pair1 = "name" to "Tom"
    val pair2 = "age" pa 42

    val map = mapOf(
        "name" to "Tom",
        "age" pa 42
    )
    println(map)
}