// 22_SAM.kt
package ex22

import javasample.ex22.OnClickListener

//interface OnClickListener {
//    fun onClick()
//}

class Button {
    var onClickListener: OnClickListener? = null

    fun click() {
        onClickListener?.onClick()
    }
}

// 일반적으로 코틀린은 함수 타입에 대해서만 람다 표현식을 사용할 수 있습니다.
// => 자바의 함수형 인터페이스를 사용할 때 불편하다.
// => 코틀린에서는 자바로 작성된 함수형 인터페이스에 대해서, 람다 표현식을
//    사용할 수 있습니다.
//    SAM(Single Abstract Method) 지원

fun main() {
    val button = Button()
    /*
    button.onClickListener = object: OnClickListener {
        override fun onClick() {
            println("Button click")
        }
    }
    */
    button.onClickListener = OnClickListener {
        println("Button click")
    }

    button.click()
}