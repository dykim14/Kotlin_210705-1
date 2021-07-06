// 11_함수형프로그래밍2.kt
package ex11_2

// (Int) -> Unit
fun go(speed: Int) {
    println("go")
}

class Car {
    // (Int) -> Unit        - X
    // (Car, Int) -> Unit
    // 메소드의 시그니처는 반드시 객체를 첫번째 인자로 전달받아야 합니다.
    fun go(speed: Int) {
        println("Car go")
    }
}

fun main() {
    var fn: (Int) -> Unit = ::go
    // fn = Car::go

    val car = Car()
    val fn2: (Car, Int) -> Unit = Car::go
    fn2(car, 100)
    
    car.go(10)  // Car::go(car, 10)
    // - 메소드의 첫번째 인자로 전달되는 참조를 'this'를 통해 접근합니다.
}