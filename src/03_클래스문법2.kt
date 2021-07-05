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

fun main() {
    // final Car car = new Car()
    val car = Car()
    val a = 100
    val b = 0xff0000 // Red
    val c = "Suwon"

    car.go()
    car.go(a)
    car.go(a, b)
    car.go(a, b, c)
}







