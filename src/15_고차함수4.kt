// 15_고차함수4.kt
package ex15_4

// 1) 함수를 인자로 전달하는 함수
// => 다양한 시나리오 동작하는 함수의 코드 중복을 없앨 수 있다.

// 2) 함수를 반환하는 함수

// foo함수는 (String) -> String 시그니처의 함수를 반환합니다.
/*
fun foo(): (String) -> String {

    // (String) -> String
    return { str ->
        str.reversed()
    }
}
*/
// 우항의 타입을 기반으로 반환 타입이 추론됩니다.
/*
fun foo1() = { str: String ->
    str.reversed()
}
*/

// 반환 타입을 기반으로 람다 표현식의 타입이 추론됩니다.
fun foo(): (String) -> String = { str ->
    str.reversed()
}

fun main() {
    val fn: (String) -> String = foo()
    val result = fn("hello")

    println(result)
}





