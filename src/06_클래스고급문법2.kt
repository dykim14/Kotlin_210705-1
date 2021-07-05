// 06_클래스고급문법2.kt
package ex6_2

// 인터페이스 문제점
// : 변화에 대응하기 어렵습니다.
//  => 새로운 기능이 추가되거나, 기능의 변경이 어렵습니다.
//     인터페이스는 기본 구현을 제공할 수 있습니다.
//
// 추상 클래스 vs 인터페이스
//  : 추상 클래스는 상태(프로퍼티, 필드)를 가질 수 있습니다.

interface Clickable {
    fun click()

    fun showOff() {
        println("Clickable")
    }
}

interface Focusable {
    fun focus()

    fun showOff() {
        println("Focusable")
    }
}

// class Button implements Clickable implements Focusable
// => 부모의 인터페이스가 동일한 기본 구현을 제공한다면,
//    반드시 오버라이딩을 통해 문제를 해결해야 합니다.
class Button : Clickable, Focusable {
    override fun showOff() {
        println("Button showOff")
        super<Focusable>.showOff()
        super<Clickable>.showOff()
    }

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