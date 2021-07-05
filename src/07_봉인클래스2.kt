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

sealed class Expr
// 다른 파일에서 Expr 클래스의 자식 클래스를 생성할 수 없습니다.
// 오직 같은 파일에서만 허용합니다.
// => 봉인된 클래스

class Num(val value: Int) : Expr()
class Sum(val left: Expr, val right: Expr) : Expr()

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
}