// 11_함수형프로그래밍2.kt
package ex11_2

// (Int) -> Unit
fun go(speed: Int) {
    println("go")
}

class Car {
    companion object {
        // this가 전달되지 않기 때문에
        // (Int) -> Unit
        fun go(speed: Int) {
            println("Companion Car go")
        }
    }

    // (Car, Int) -> Unit
    // 메소드의 시그니처는 반드시 객체를 첫번째 인자로 전달받아야 합니다. - this
    fun go(speed: Int) {
        println("Car go")
    }
}

fun main() {
    // 일반 함수 - ::go
    var fn: (Int) -> Unit = ::go

    // Companion object method reference: (Car)::go
    //                  method reference: Car::go
    val fn3: (Int) -> Unit = (Car)::go
    fn3(100)

    val car = Car()
    val fn2: (Car, Int) -> Unit = Car::go
    fn2(car, 100)

    // 메소드 참조에서 이미 this가 결정된 경우의 메소드 참조
    // => Bound Reference(바운드 참조)
    val fn4: (Int) -> Unit = car::go

    car.go(10)  // Car::go(car, 10)
    // - 메소드의 첫번째 인자로 전달되는 참조를 'this'를 통해 접근합니다.
}