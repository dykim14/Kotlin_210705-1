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

    // 문제점
    // - 어떤 값이 어떤 파라미터로 전달되는지 알기 어렵다.
    // 해결방법
    // - 파라미터 지정 호출
    /*
    car.go()
    car.go(a)
    car.go(a, b)
    car.go(a, b, c)
    */

    car.go(speed = a, color = b, destination = c)
}







