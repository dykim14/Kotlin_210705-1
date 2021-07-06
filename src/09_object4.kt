// 09_object4.kt
// 1. object 선언 - 싱글톤
// 2. 동반 객체    - 정적 필드 / 정적 메소드
//                 타입이 인터페이스와 상속을 구현할 수 있다.
package ex9_4
// 3. 익명 객체(Anonymous Object)

interface MouseAdapter {
    fun mouseClicked()
    fun mouseEntered()
}

class Window {
    var adapter: MouseAdapter? = null

    fun click() {

    }

    fun enter() {

    }
}

fun main() {
    val window = Window()
    window.adapter = object : MouseAdapter {
        override fun mouseClicked() {
            println("mouseClicked")
        }

        override fun mouseEntered() {
            println("mouseEntered")
        }
    }

    window.click()
    window.enter()
}







