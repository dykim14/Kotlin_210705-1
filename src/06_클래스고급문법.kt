// 06_클래스고급문법.kt
package ex6

// 상속
// 1. 상속하는 방법
//   Java: class Truck extends Car {}
// Kotlin: class Truck : Car()
//   주의: 코틀린은 모든 클래스가 기본적으로 final 입니다.
//     => 상속이 금지되어 있습니다.
//   * 상속 문제점
//    : 기본 클래스와 자식 클래스의 강한 결합이 형성됩니다.
//      기본 클래스에 대한 변경이 하위 클래스의 동작이 예기치않게 변경될 수 있습니다.
//    > 상속을 위한 설계와 문서를 갖추거나, 그럴 수 없다면 상속을 금지해라.
// 2. 상속이 가능한 클래스
//    open class Car
// 3. 클래스의 메소드는 기본적으로 오버라이딩이 금지되어있습니다.
//    Kotlin: fun foo() {}
//      Java: final void foo() {}
//   => 오버라이딩을 허용하기 위해서는 open 키워드를 통해 메소드를 작성해야 합니다.

// public final class Car {
//   private String name;
// }

open class Car(val name: String) {
    open fun display() {
        println("Car - $name")
    }
}
// open class Car

class Truck(name: String) : Car(name) {

    override fun display() {
        println("Truck - $name")
    }
}

fun main() {
    val car: Car = Truck("Dump")
    car.display()
}


