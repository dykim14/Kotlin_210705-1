// 10_위임.kt
package ex10

// 위임: 하나 이상의 메소드의 호출을 다른 객체에게 위임한다.
//   => 기존 클래스의 기능을 재사용
//     1) 상속


/*
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

// 상속은 부모 클래스의 기능을 암묵적으로 재사용할 수 있습니다.
class Panel(x1: Int, x2: Int, y1: Int, y2: Int) : Rectangle(x1, x2, y1, y2)

fun main() {
    val panel = Panel(10, 20, 30, 40)

    println(panel.getWidth())
    println(panel.getHeight())
}
*/

// 상속
//  - 부모와 자식 클래스의 강한 결합
//  - 부모의 변화가 자식 클래스에 의도치 않은 영향을 줄 수 있다.


//     2) 포함(컴포지션)
//   - 의존하는 객체를 런타임에 교체 가능하다.
//   - 인터페이스: 교체 가능한 유연한 설계
//      : 의존성 주입(Dependency Injection)
//
//   컴포지션 문제점
//    : 명시적으로 위임의 코드를 작성해야 한다.

interface UIElement {
    fun getHeight(): Int
    fun getWidth(): Int
}

class Rectangle(val x1: Int, val x2: Int, val y1: Int, val y2: Int) : UIElement {
    override fun getHeight(): Int {
        return y2 - y1
    }

    override fun getWidth(): Int {
        return x2 - x1
    }
}

// 코틀린은 컴포지션에서 클래스 위임에 대한 코드를 자동으로 생성할 수 있는 문법을 제공합니다.
/*
class Panel(private val rectangle: UIElement) : UIElement {
    override fun getHeight(): Int {
        return rectangle.getHeight()
    }

    override fun getWidth(): Int {
        return rectangle.getWidth()
    }
}
*/

// class Panel(private val rectangle: UIElement) : UIElement by rectangle

class Panel(rectangle: UIElement) : UIElement by rectangle

fun main() {
    val rectangle = Rectangle(10, 20, 30, 40)
    val panel = Panel(rectangle)

    println(panel.getWidth())
    println(panel.getHeight())
}







