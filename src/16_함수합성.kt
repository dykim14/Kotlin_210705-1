// 16_함수합성.kt
package ex16

// f(x) -> y
// g(y) -> z

// x -> f(x) -> y -> g(y) -> z
// x -> f(x) * g(y) -> z

/*
fun main() {
    val f: (String) -> Int = String::length
    val g: (Any) -> Int = Any::hashCode

    val x = "hello"
    val y = f(x)
    val z = g(y)

    println(z)
}
*/

//                x         y        y       z        x         z
fun compose(f: (String) -> Int, g: (Any) -> Int): (String) -> Int {
    return { x ->
        val y = f(x)
        val z = g(y)
        z
    }
}

fun main() {
    val h = compose(String::length, Any::hashCode)
    val x = "hello"
    val z = h(x)

    println(z)
}













