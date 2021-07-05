// 06_클래스고급문법3.kt
package ex6_3

import java.io.Serializable

// Inner class(내부 클래스) vs Nested class(중첩 클래스)
interface State : Serializable

// 프로퍼티도 인터페이스의 명세로 제공할 수 있습니다.
interface View {
    var state: State
}

class Button(
    var x: Int,
    var y: Int,
    var width: Int,
    var height: Int
) : View {
    override var state: State
        get() {
            return ButtonState(x, y, width, height)
        }
        set(value) {
            value as ButtonState
            x = value.x
            y = value.y
            width = value.width
            height = value.height
        }

    private class ButtonState(
        val x: Int,
        val y: Int,
        val width: Int,
        val height: Int
    ) : State

    override fun toString(): String {
        return "Button(x=$x, y=$y, width=$width, height=$height)"
    }
}