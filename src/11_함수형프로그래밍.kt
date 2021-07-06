// 11_함수형프로그래밍.kt
package ex11

// 함수형 언어
// - Haskell, Lisp, Erlang, Scala ...

// 함수형 언어
//  1) 함수를 변수에 담을 수 있어야 한다.
//  2) 함수를 인자로 전달 할 수 있어야 한다.
//  3) 함수를 반환할 수 있어야 한다.
//  4) 실행 시간에 함수를 생성할 수 있어야 한다.
//  5) 함수를 익명으로 생성할 수 있어야 한다.
//  => 함수를 '일급 시민(First class citizen)'으로 취급합니다.

// 1. 코틀린은 단일 표현식 함수를 지원합니다.
fun add1(a: Int, b: Int): Int {
    return a + b
}

fun add2(a: Int, b: Int): Int = a + b