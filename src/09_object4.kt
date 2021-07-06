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
    // lateinit var adapter: MouseAdapter

    // 스마트캐스트가 적용되지 않는 케이스에 대한 이해가 필요합니다.
    // : Smart cast to 'MouseAdapter' is impossible,
    //   because 'adapter' is a mutable property that could have been changed by this time
    fun click() {
        // 1. 강제로 호출하는 방법
        //  - !!
        // : adapter가 null일 경우, NullPointerException 으로 인해 비정상 종료 됩니다.
        /*
        if (adapter != null) {
            adapter!!.mouseClicked()
        }
        */

        // 2. lateinit var adapter: MouseAdapter
        //  : 이후에 초기화를 수행하겠다.
        //  => 초기화가 수행되지 않은 상태에서 수행될 경우,
        //     UninitializedPropertyAccessException 예외가 발생합니다.
        // adapter.mouseClicked()

        // 3. 별도의 지역 변수에 할당해서 사용합니다.
        //  : 컴파일러는 지역 변수에 대한 변경에 대해서는 추적이 가능합니다.
        // => null 체크 코드가 매번 발생하는 문제가 있습니다.
        /*
        val adapter = adapter
        if (adapter != null) {
            adapter.mouseClicked()
        }
        */

        // 4. Safe-Call
        // : adapter가 null이 아닐 경우, mouseClicked를 수행합니다.
        //  => 원자적으로 수행됩니다.
        adapter?.mouseClicked()
    }

    fun enter() {
        adapter?.mouseEntered()
    }
}

fun main() {
    val window = Window()

    var n = 0

    // 익명 객체는 외부 컨텍스트의 변수를 암묵적으로 참조 가능합니다.
    //  : 클로저(Closure)
    window.adapter = object : MouseAdapter {
        override fun mouseClicked() {
            println("mouseClicked - ${++n}")
        }

        override fun mouseEntered() {
            println("mouseEntered")
        }
    }

    window.click()
    window.click()
    window.click()
    window.click()
    window.enter()
}







