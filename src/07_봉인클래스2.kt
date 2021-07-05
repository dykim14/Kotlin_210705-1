// 07_봉인클래스2.kt
package ex7_2

import java.lang.IllegalArgumentException

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

    println(eval(sum))
}