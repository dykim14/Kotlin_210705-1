// 06_클래스고급문법2.kt
package ex6_2

// 인터페이스 문제점
// : 변화에 대응하기 어렵습니다.
//  => 새로운 기능이 추가되거나, 기능의 변경이 어렵습니다.
//     인터페이스는 기본 구현을 제공할 수 있습니다.

interface Clickable {
    fun click()

    fun showOff() {
        println("Clickable")
    }
}

interface Focusable {
    fun focus()
}

// class Button implements Clickable implements Focusable
class Button : Clickable, Focusable {
    override fun click() {
        println("Button click")
    }

    override fun focus() {
        println("Button focus")
    }
}

fun main() {
    val button = Button()
    button.showOff()

    val clickable: Clickable = button
    clickable.click()

    val focusable: Focusable = button
    focusable.focus()
}