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
/*
interface OnValueChanged {
    fun onValueChanged(old: String, new: String)
}

// : 값이 조건을 만족해야만 변경되도록 하고 싶다.
interface Predicate {
    fun test(e: String): Boolean
}

class SampleDelegate(
    var field: String,
    private val onValueChanged: OnValueChanged,
    private val predicate: Predicate
) {
    operator fun getValue(thisRef: User, property: KProperty<*>): String {
        return field
    }

    operator fun setValue(thisRef: User, property: KProperty<*>, value: String) {
        if (predicate.test(value).not()) {
            return
        }

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
        },
        predicate = object : Predicate {
            override fun test(e: String): Boolean {
                return e.length >= 5
            }
        }
    )
}
*/

interface OnValueChanged<T> {
    fun onValueChanged(old: T, new: T)
}

// : 값이 조건을 만족해야만 변경되도록 하고 싶다.
interface Predicate<T> {
    fun test(e: T): Boolean
}

class SampleDelegate<T>(
    var field: T,
    private val onValueChanged: OnValueChanged<T>,
    private val predicate: Predicate<T>
) {
    operator fun getValue(thisRef: User, property: KProperty<*>): T {
        return field
    }

    operator fun setValue(thisRef: User, property: KProperty<*>, value: T) {
        if (predicate.test(value).not()) {
            return
        }

        val old = field
        field = value

        onValueChanged.onValueChanged(old, field)
    }
}


class User {
    val age: Int by SampleDelegate(0,
        onValueChanged = object : OnValueChanged<Int> {
            override fun onValueChanged(old: Int, new: Int) {
                println("age: $new -> $old")
            }
        },
        predicate = object : Predicate<Int> {
            override fun test(e: Int): Boolean {
                // 1 ~ 100
                // age > 0 && age <= 100
                return age in 1..100
            }
        })
    
    var name: String by SampleDelegate("Tom",
        onValueChanged = object : OnValueChanged<String> {
            override fun onValueChanged(old: String, new: String) {
                println("name: $old -> $new")
            }
        },
        predicate = object : Predicate<String> {
            override fun test(e: String): Boolean {
                return e.length >= 5
            }
        }
    )
}

fun main() {
    val user = User()
    println(user.name)

    user.name = "Bob"
    println(user.name)

    user.name = "Alice"
    println(user.name)
}
















