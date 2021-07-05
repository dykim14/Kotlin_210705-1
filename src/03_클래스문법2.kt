// 03_클래스문법2.kt
package ex3_2

class Car {
    fun go() {
        println("Car go")
    }

    fun go(speed: Int) {
        // println("Car go - " + speed)
        println("Car go - ${speed}km/s")
    }

    fun go(speed: Int, color: Int) {
        println("Car go - ${speed}km/s $color")
    }

    fun go(speed: Int, color: Int, destination: String) {
        println("Car go - ${speed}km/s $color $destination")
    }
}