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

/*
//                x         y        y       z        x         z
fun compose(f: (String) -> Int, g: (Any) -> Int): (String) -> Int {
    return { x ->
        val y = f(x)
        val z = g(y)
        z
    }
}
*/
/*
fun compose(f: (String) -> Int, g: (Any) -> Int): (String) -> Int = { x ->
    g(f(x))
}
*/

// 1. 일반화
/*
fun <X, Y, Z> compose(f: (X) -> Y, g: (Y) -> Z) : (X) -> Z = { x ->
    g(f(x))
}
*/

// 2. 확장 함수 + 중위 함수
infix fun <X, Y, Z> ((X) -> Y).compose(g: (Y) -> Z) : (X) -> Z = { x ->
    g(this(x))
}

fun main() {
    // val h = (String::length).compose(Any::hashCode)

    val h = String::length compose Any::hashCode
    val x = "hello"
    val z = h(x)

    println(z)
}













