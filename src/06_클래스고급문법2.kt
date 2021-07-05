// 06_클래스고급문법2.kt
package ex6_2

interface Clickable {
    fun click()
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
    val clickable: Clickable = button
    clickable.click()

    val focusable: Focusable = button
    focusable.focus()
}