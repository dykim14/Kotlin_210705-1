// 23_범위지정함수
package ex23

import java.lang.StringBuilder

// 1. let
//  : Nullable를 다룰 때 사용합니다.

// 2. apply
//  : 인자가 this로 전달되는 람다 => 수신 객체 지정 람다
//    (T) -> Unit
//    - 첫번째 인자가 it 으로 전달됩니다.
//   T.() -> Unit    - 수신 객체 지정 람다
//    - 첫번째 인자가 this 로 전달됩니다.
fun alphabet1(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z')
        result.append(letter)

    return result.toString()
}


// apply 구현입니다.
//  : 객체의 초기화 과정을 블록을 통해 캡슐화할 때 사용합니다.
//   - 빌더 등의 초기화 과정이 복잡한 객체에서 사용합니다.
inline fun <T> T.apply3(block: T.() -> Unit): T {
    // block(this)
    // this.block()
    block()
    return this
}

fun alphabet_apply2(): String {
    return StringBuilder().apply {
        for (letter in 'A'..'Z')
            append(letter)
    }.toString()
}

fun alphabet3(): String = StringBuilder().apply {
    for (letter in 'A'..'Z')
        append(letter)
}.toString()

// buildString
fun alphabet_buildString(): String = buildString {
    for (letter in 'A'..'Z')
        append(letter)
}


fun main() {
    val result = alphabet1()
    println(result)
}