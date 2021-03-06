// 07_봉인클래스.kt
package ex7

import java.lang.Exception

// 1. enum class
// 2. enum은 자바와 동일하게 프로퍼티와 메소드를 가질 수 있는 객체 타입입니다.
/*
enum class Color {
    RED, ORANGE, YELLOW, GREEN
}
*/
enum class Color(
    val red: Int,
    val green: Int,
    val blue: Int
) {
    RED(255, 0, 0),
    BLUE(0, 0, 255),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0)
    ;

    // 메소드를 정의하기 위해서는 반드시 토큰의 분리를 표시해야 합니다
    fun rgb(): Int {
        return (red * 255 + green) * 255 + blue
    }
}

//   Java: switch-case
// Kotlin: switch-case statement(문) 이 존재하지 않습니다.
//         when expression(식)을 통해 대체할 수 있습니다.

// Statement vs Expression
//  - Statement은 결과가 존재하지 않습니다.
//  - Expression은 결과가 존재합니다.

// when
// - 객체 동등성 비교
fun mix(c1: Color, c2: Color): Color {
    val set: Set<Color> = setOf(c1, c2)
    return when (set) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        else -> throw Exception("Unknown")
    }
}

fun main() {
    val result1 = mix(Color.RED, Color.YELLOW)
    val result2 = mix(Color.YELLOW, Color.RED)
    println(result1)
    println(result2)


    val color = Color.BLUE
    println(color.green)

    println(color.rgb())

    val name = getWarmth(color)
    println(name)
}

fun getWarmth(color: Color): String {
    return when (color) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "Warm"
        Color.BLUE, Color.GREEN -> "Cold"
    }
}

fun getName(color: Color): String {
    // Statement
    /*
    when (color) {
        Color.RED -> return "RED"
        Color.BLUE -> return "BLUE"
        Color.GREEN -> return "GREEN"
        else -> return "UNKNOWN"
    }
    */
    return when (color) {
        Color.RED -> "RED"
        Color.BLUE -> "BLUE"
        Color.GREEN -> "GREEN"
        else -> "UNKNOWN"
    }
}

