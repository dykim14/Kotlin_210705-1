package ex10_4

import kotlin.reflect.KProperty

class SampleDelegate<T>(
    var field: T,
    val onValueChanged: (property: KProperty<*>, old: T, new: T) -> Unit
) {
    operator fun getValue(thisRef: Any, property: KProperty<*>): T {
        return field
    }

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        val old = field
        field = value

        onValueChanged(property, old, value)
    }
}

fun <T> observable(
    initialValue: T,
    onValueChanged: (property: KProperty<*>, old: T, new: T) -> Unit
): SampleDelegate<T> {
    return SampleDelegate(initialValue, onValueChanged)
}

class User {
    /*
    var name: String by SampleDelegate("Tom") { property, old, new ->
        println("${property.name}: $old -> $new")
    }
    */

    var name: String by observable("Tom") { property, old, new ->
        println("${property.name}: $old -> $new")
    }
}

fun main() {
    val user = User()
    println(user.name)
    user.name = "Bob"
    println(user.name)
}