// 20_Nullable.kt
package ex20

import ex18_2.add
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

// Nullable
//  : 'null'을 안전하게 다루는 기술입니다.
//  => 코틀린은 언어적으로 널 안정성을 지원합니다.
//     : Optional / Maybe
//    Java8 : Optional class

class Country(val name: String, val city: City?)
class City(val name: String, val address: Address?)
class Address(val name: String)

/*
fun main() {
    val country: Country? = Country("KR", City("Seoul", Address("Gangnam")))

    // Java
    if (country != null) {
        val city = country.city
        if (city != null) {
            val address = city.address
            if (address != null) {
                println(address.name)
            }
        }
    }

    // Kotlin - Safe-Call(?.)
    val name = country?.city?.address?.name
    if (name != null) {
        println(name)
    }
}
*/

// 범위 지정 함수
inline fun <T, R> T.let(block: (T) -> R): R {
    return block(this)
}

class User {
    fun sendMail(email: String) {
        println("User::sendMail - $email")
    }

    fun sendMail2(email: String?) {
        // 1) Smart Cast
        if (email != null) {
            println("User::sendMail - $email")
        }

        // 2) let + Safe Call
        // : email이 null이 아니면 let 블록을 실행하겠다.
        email?.let { println("User::sendMail - $it") }
    }

    fun sendMail(email: String?, subject: String?) {
        // 3) Elvis operator - ?:
        //  : null 일 때 실행한 표현식을 정의합니다.

        email ?: return
        subject ?: return

        println("send mail - $email, $subject")

        /*
        // let은 중첩될 경우, 코드의 가독성이 떨어집니다.
        email?.let { email ->
            subject?.let { subject ->
                println("send mail - $email, $subject")
            }
        }

        if (email != null && subject != null) {
            println("send mail - $email, $subject")
        }
        */


    }

}

// 단일 실패 원인을 갖는 함수의 경우, Nullable를 사용하면 편리합니다.
fun getUser(): User? {
    return null
}

open class Car
class Truck(val name: String) : Car()

fun foo(): Car {
    // return Car()
    return Truck("Dump")
}

// Car?
//  |
// Car
//  |
// Truck?
//  |
// Truck
//  : Nullable 타입은 Nullable이 아닌 타입의 부모 타입으로 취급됩니다.

fun main() {
    val p: Car = Truck("x")
    val p1: Car = p


    val car: Car = foo()

    // car as Truck
    // println(car.name)

    if (car is Truck)
        println(car.name)  // Smart cast

    // as?: 캐스팅이 실패할 경우, 예외가 발생하는 것이 아니라
    //      null을 반환합니다.
    val truck = car as? Truck
    truck?.name?.let {
        println(it)
    }


    val user = getUser()
    user?.sendMail2("hello@gmail.com")
}















