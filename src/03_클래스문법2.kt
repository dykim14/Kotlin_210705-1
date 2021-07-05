// 03_클래스문법2.kt
package ex3_2

/*
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
    car.go(color = a, speed = b, destination = c)

    // Kotlin 1.4
    // 순서가 일치할 경우, 부분 지정이 가능합니다.
    car.go(a, color = b, destination = c)
    car.go(speed = a, b, destination = c)

    // => Trailing comma
    car.go(
        speed = a,
        color = b,
        destination = c,
    )
}
*/

// 코틀린에서 생성자의 인자가 많을 경우,
// 코드를 작성하는 방법
//  1) 파라미터 지정 호출
//  2) 파라미터 기본값

class Person(
    val name: String,
    val address: String = "",
    val phone: String = "",
    val age: Int = 0
)

fun main() {
    val person1 = Person(
        name = "Tom",
        address = "Suwon",
        phone = "000-1111-2222",
        age = 10
    )

    val person2 = Person(
        name = "Tom",
    )
}




