// 10_위임.kt
package ex10

// 위임: 하나 이상의 메소드의 호출을 다른 객체에게 위임한다.
//   => 기존 클래스의 기능을 재사용
//     1) 상속

interface UIElement {
    fun getHeight(): Int
    fun getWidth(): Int
}

open class Rectangle(val x1: Int, val x2: Int, val y1: Int, val y2: Int) : UIElement {
    override fun getHeight(): Int {
        return y2 - y1
    }

    override fun getWidth(): Int {
        return x2 - x1
    }
}

class Panel(x1: Int, x2: Int, y1: Int, y2: Int) : Rectangle(x1, x2, y1, y2)

fun main() {
    val panel = Panel(10, 20, 30, 40)

    println(panel.getWidth())
    println(panel.getHeight())
}






//     2) 포함(컴포지션)