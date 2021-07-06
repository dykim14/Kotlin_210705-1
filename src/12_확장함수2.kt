package ex12

open class View {
    // 1
    open fun click() = println("View click")
}


class Button : View() {
    // 2
    override fun click() = println("Button click")
}

fun View.click() = println("View click")
fun Button.click() = println("Button click")
// 1. 확장함수는 일반 함수이기 때문에,
//    동적 바인딩이 아닌 정적 바인딩 기반으로 동작합니다.
//  val view: View = Button()
//              |       |
//          정적바인딩     + 동적 바인딩

// 2. 동일한 이름의 함수가 이미 메소드로 존재한다면,
//    확장 함수가 절대 호출되지 않습니다.

fun main() {
    val view: View = Button()
    view.click()
}