// 02_기본문법.kt
package ex2

import java.util.*

// 1. main 함수 만드는 방법
//  - fun main(args: Array<String>) {
//  - Kotlin 1.3 이후 - args 생략할 수 있습니다.

// 2. 함수를 만드는 방법
//    fun 함수이름(인자이름1: 인자타입1, 인자이름2: 인자타입): 반환타입 {}

// 3. 코틀린은 전역 함수를 만들 수 있습니다.
//    - 자바에서는 전역 함수를 만들 수 없습니다.
//     : 별도의 클래스에 정적 메소드를 모아놓는 형태로 사용합니다.
//       Arrays, Objects, Collections ...
//    - 별도의 파일에 전역 함수를 모아놓으면 됩니다.
//
// 4. 함수의 반환값이 없는 경우
//    -   Java: void
//    - Kotlin: Unit
//     : 결과가 존재하지 않음을 나타내는 값
//
// 5.  Java: Object-Oriented Programming
//   Kotlin: OOP + FP(Functional Programming)
//      - 순수 함수(Pure Function)
//        : 함수의 입력값이 동일하면, 결과값도 동일하다.
//
/*
fun add(a: Int, b: Int): Int {
    return a + b
}

// fun foo(): Unit {
fun foo() {
}

fun main() {
    println(foo())
    println(add(10, 20))
}
*/
// 6. 타입 시스템
//   Java
//    - Primitive Type
//      int, double, char, byte, long ...
//      : 값을 기반으로 동작합니다.
//        객체가 아니기 때문에, 필드와 메소드를 가질 수 없습니다.
//        객체가 아니기 때문에 제네릭의 인자로 사용할 수 없습니다.
//        => Wrapper Class
//           Integer, Double, Char, Byte, Long ...
//
//    - Reference Type
//      class, interface, enum, array
//      : 참조를 기반으로 동작합니다.
//
//   Kotlin
//   - 모든 타입은 객체 타입입니다.
//    : 필드와 메소드를 가질 수 있습니다.
//   - 강력한 타입 제약을 가지고 있습니다.
//    => 강타입 언어
//    : 암묵적인 타입 변환을 거의 허용하지 않습니다.
//
// 7. 변수 선언 방법
//    Java - int n = 42
//  Kotlin - var n: Int = 42  : 명시적인 타입 선언
//           var n = 42       : 암묵적인 타입 추론

fun main() {
    // 3.14.toString()
    var n: Int = 42
    var a: Long = n.toLong()
}



