// 07_봉인클래스.kt
package ex7

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
}

fun main() {
    val color = Color.ORANGE
    print(color.green)
}