// 07_봉인클래스2.kt
package ex7_2

import java.lang.IllegalArgumentException

/*
interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    return when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }
}

fun main() {
    val left = Num(10)
    val right = Num(20)
    val sum = Sum(left, right)
    val sum2 = Sum(left, sum)

    println(eval(sum2))
}
*/

/*
sealed class Expr
// 다른 파일에서 Expr 클래스의 자식 클래스를 생성할 수 없습니다.
// 오직 같은 파일에서만 허용합니다.
// => 봉인된 클래스
//    봉인된 인터페이스(1.5)

class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()
*/
sealed interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    return when (e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
    }
}

fun main() {
    val left = Num(10)
    val right = Num(20)
    val sum = Sum(left, right)
    val sum2 = Sum(left, sum)

    println(eval(sum2))

    // if 조건도 Expression 입니다.
    // => 코틀린에서는 삼항 연산자가 존재하지 않습니다.
    val n = 10

    // val result = n < 10 ? "Tom" : "Bob" -  compile error!

    // val result = if (n < 10) "Tom" else "Bob"

    /*
    val result = if (n < 10) "Tom"
    else if (n < 0) "Bob"
    else "Alice"
    */
    val result = when {
        n < 10 -> "Tom"
        n < 0 -> "Bob"
        else -> "Alice"
    }
    println(result)

    // 기본 연산자를 사용하는 방법도 변경되었습니다.
    // val a = 0xf0f0
    val a = 0b1111000011110000
    println(a)

    //   Java:  <<,  >>,  >>>,   &,  |,   ^,   ~
    // Kotlin: shl, shr, ushr, and, or, xor, inv
    println(a shl 3)
    println(a shr 3)
    println(a ushr 3)
    println(a and 0b1111)
    println(a or 0b1111)
    println(a xor 0b1111)
    println(a.inv())

    // for-loop
    // 1 ~ 10

    // Range
    // Java: for (int i = 1; i <= 10; i++) {}
    // 1 ~ 10
    for (i in 1..10) {
        print(i)
    }
    println()

    // Java: for (int i = 0 ; i < 10; i++) {}
    for (i in 0 until 10) {
        print(i)
    }
    println()

    for (i in 0..10 step 2) {
        print(i)
    }
    println()

    for (i in 10 downTo 1) {
        print(i)
    }
}


// Kotlin
// 1) JVM 기반
//   => Android / Spring(Backend)
//------------------------------
// 2) JS 기반
//   => Node.js
// 3) Native 기반
//   => iOS / Linux / Windows






