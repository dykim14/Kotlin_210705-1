// 10_위임2.kt
package ex10_2

import kotlin.reflect.KProperty

// 프로퍼티 위임
//  : 접근자 메소드에 대한 동작을 다른 객체에게 위임

class SampleDelegate {
    operator fun getValue(thisRef: User, property: KProperty<*>): String {
        println("getValue")
        return "Tom"
    }
}

// 동작 방식
//  var name: String by SampleDelegate()
//   : name 프로퍼티에 대해서 getter / setter의 호출이 SampleDelegate 객체가 제공하는
//     약속된 메소드(연산자 오버로딩)를 통해 수행됩니다.
//  - Type 'SampleDelegate' has no method 'getValue(User, KProperty<*>)'
//    and thus it cannot serve as a delegate

class User {
    val name: String by SampleDelegate()
}

fun main() {
    val user = User()
    println(user.name)
}