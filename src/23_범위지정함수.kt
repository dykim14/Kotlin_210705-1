// 23_범위지정함수
package ex23

import java.lang.StringBuilder

// 1. let
//  : Nullable를 다룰 때 사용합니다.
fun alphabet1(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z')
        result.append(letter)

    return readLine().toString()
}

// 2. apply
//  : 인자가 this로 전달되는 람다 => 수신 객체 지정 람다
fun alphabet2(): String {
    return StringBuilder().apply {
        for (letter in 'A'..'Z')
            append(letter)
    }.toString()
}

fun main() {
    val result = alphabet1()
    println(result)
}