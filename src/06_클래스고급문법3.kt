// 06_클래스고급문법3.kt
package ex6_3

import java.io.*

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

    // 코틀린은 기본이 중첩 클래스 입니다.
    // 코틀린에서는 내부 클래스를 inner 키워드를 통해 만들 수 있습니다.
    // private inner class ButtonState(
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

// 코틀린에서는 예외처리가 강제가 아닙니다.
//  => 예외가 발생할 경우, 처리되지 않은 예외로 인해서, 런타임 오류가 발생할 가능성이
//     있습니다.
fun main() {
    /*
    val button = Button(x = 10, y = 20, width = 30, height = 40)

    val fos = FileOutputStream("button2.dat")
    val oos = ObjectOutputStream(fos)
    oos.writeObject(button.state)
    */

    val button = Button(x = 0, y = 0, width = 30, height = 40)

    val fis = FileInputStream("button2.dat")
    val ois = ObjectInputStream(fis)
    val state: State = ois.readObject() as State
    button.state = state

    println(button)
}