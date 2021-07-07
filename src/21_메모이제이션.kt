// 21_메모이제이션.kt
package ex21

// 함수의 결과를 저장해서, 재활용하는 최적화
// "메모이제이션"
//   순수 함수(pure function)
//    : 인자가 동일하면, 결과도 동일하다.
//    => 참조적 투명성

// when expresion을 이용해서, 코드를 작성하면 편리합니다.
/*
fun fib(k: Int): Long = when (k) {
    0, 1 -> 1
    else -> fib(k - 1) + fib(k - 2)
}
*/

/*
val cache = mutableMapOf<Int, Long>()
fun fib(k: Int): Long = when (k) {
    0, 1 -> 1
    else -> {
        val result = cache[k]
        if (result != null)
            result
        else {
            val n = fib(k - 1) + fib(k - 2)
            cache[k] = n
            n
        }
    }
}
*/

// Map에서 메모이제이션을 쉽게 사용할 수 있는 기능을 제공합니다.
//  => Extension Function
val cache = mutableMapOf<Int, Long>()
fun fib(k: Int): Long = cache.getOrPut(k) {
    when (k) {
        0, 1 -> 1
        else -> fib(k - 1) + fib(k - 2)
    }
}


fun main() {
    val result = fib(100)

    println(result)
}