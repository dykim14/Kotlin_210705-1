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

// fun add2(a: Int, b: Int): Int = a + b
fun add2(a: Int, b: Int) = a + b
// > 반환 타입의 생략이 가능합니다.
//   함수의 반환 타입에 대한 추론이 가능합니다.
//   - 함수가 제네릭 기반으로 되어 있다면, 타입 추론이 가능합니다.

// var a: Int = 10
// var a = 10

// 2. 함수 타입
//   코틀린에서는 함수의 타입은 함수의 인자의 정보, 반환 타입에 의해서 결정됩니다.
//  => 인자와 반환 타입이 동일한 함수는 같은 타입의 함수 입니다.
//  => 함수의 시그니처(인자 타입과 반환 타입 정보)가 동일하면, 동일한 타입입니다.

// 3. 전역 함수는 :: 을 통해 참조할 수 있습니다.
// 4. 함수 타입 표현 방법
//    (Int, Int) -> Int

fun foo(a: Int, b: Char, c: String): Double = 3.14

// 5. 지역 함수
//  : 전역 공간의 이름 충돌을 신경쓰지 않아도 됩니다.
//    클로저(Closure)를 사용할 수 있습니다.
//     : 외부 컨텍스트(함수)의 변수를 암묵적으로 참조(캡쳐)할 수 있습니다.
fun printArea(width: Int, height: Int) {

    // 함수 내부에서만 사용되는 함수를 정의할 수 있습니다.
    fun calcArea(width: Int, height: Int) = width * height
    fun calcArea2() = width * height

    // val area1 = width * height
    // val area2 = width * height
    // val area1 = calcArea(width, height)
    // val area2 = calcArea(width, height)

    val area1 = calcArea2()
    val area2 = calcArea2()

    println(area1)
    println(area2)
}

fun main() {
    printArea(100, 30)

    var fn1: (Int, Int) -> Int = ::add1
    fn1 = ::add2
    fn1(10, 20)

    val fn2: (Int, Char, String) -> Double = ::foo
    foo(42, 'a', "Hello")

    val result1 = add1(10, 20)
    val result2 = add2(10, 20)
}





