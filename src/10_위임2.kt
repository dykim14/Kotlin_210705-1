// 10_위임2.kt
package ex10_2

import kotlin.reflect.KProperty

// 프로퍼티 위임
//  : 접근자 메소드에 대한 동작을 다른 객체에게 위임
/*
class SampleDelegate {
    operator fun getValue(thisRef: User, property: KProperty<*>): String {
        println("getValue")
        return "Tom"
    }

    operator fun setValue(thisRef: User, property: KProperty<*>, value: String) {
        println("setValue - $value")
    }
}

// 동작 방식
//  var name: String by SampleDelegate()
//   : name 프로퍼티에 대해서 getter / setter의 호출이 SampleDelegate 객체가 제공하는
//     약속된 메소드(연산자 오버로딩)를 통해 수행됩니다.
//  - Type 'SampleDelegate' has no method 'getValue(User, KProperty<*>)'
//    and thus it cannot serve as a delegate
//  - Type 'SampleDelegate' has no method 'setValue(User, KProperty<*>, String)'
//    and thus it cannot serve as a delegate for var (read-write property)

class User {
    var name: String by SampleDelegate()
}

fun main() {
    val user = User()
    println(user.name)

    user.name = "Bob"
}
*/

// 활용
// : 프로퍼티의 값의 변경될 때 마다 수행되는 로직을 캡슐화하고 싶다.
interface OnValueChanged {
    fun onValueChanged(old: String, new: String)
}

class SampleDelegate(var field: String, private val onValueChanged: OnValueChanged) {
    operator fun getValue(thisRef: User, property: KProperty<*>): String {
        return field
    }

    operator fun setValue(thisRef: User, property: KProperty<*>, value: String) {
        val old = field
        field = value

        onValueChanged.onValueChanged(old, field)
    }
}

class User {
    var name: String by SampleDelegate("Tom",
        onValueChanged = object : OnValueChanged {
            override fun onValueChanged(old: String, new: String) {
                println("name: $old -> $new")
            }
        }
    )
}

fun main() {
    val user = User()
    println(user.name)
    user.name = "Bob"
    println(user.name)
}
















