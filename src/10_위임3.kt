// 10_위임3.kt
package ex10_3

import java.util.concurrent.TimeUnit
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

// 코틀린이 이미 제공하는 프로퍼티 위임 객체가 있습니다.


class Data {
    init {
        println("Data 객체 생성 시작")
        TimeUnit.SECONDS.sleep(2)
        println("Data 객체 생성 완료")
    }
}

// 1. lazy
//   : 프로퍼티의 지연 초기화를 지원합니다.
//     처음 접근되는 시점에 해당 객체가 초기화 됩니다.
//     val에 대해서만 사용할 수 있습니다.
//     스레드 안전성을 보장합니다.

//     lateinit var data: Data
//     => var에 대해서만 사용할 수 있습니다.
//        자바에서 참조 타입으로 취급되는 것에 대해서만 사용할 수 있습니다.
//         : Int, Double, Long, Float
//        초기화되지 않은 접근이 발생했을 경우, 예외로 인해서 프로그램이 비정상 종료될 수 있습니다.

class User {
    // 객체가 초기화 되는 시점에 생성 시간이 오래 걸리는 객체가 초기화 된다면
    // 객체 생성의 전체적인 시간이 느려지는 문제가 발생합니다.
    // => 지연 초기화
    //    - 처음으로 접근되는 시점에 초기화되도록 코드를 작성해야 한다.
    //    - 스레드 안전하게 사용될 수 있어야 한다.
    // val data = Data()
    val data: Data by lazy {
        // 블록안에서 데이터에 대한 초기화 코드를 작성하면 됩니다.
        Data()
    }

    fun go() {
        println("User go - $data")
    }
}


// 2. 프로퍼티 변경을 관찰하는 객체
//     Delegates.observable
class TextView {
    // text가 변경되면, UI에 대한 업데이트를 수행하고자 합니다.
    var text: String by Delegates.observable("") { _: KProperty<*>, old: String, new: String ->
        // text의 프로퍼티가 변경되었을 때 수행하는 작업 블록
        println("$text UI 업데이트: $old -> $new")
    }
}

// 3. 조건에 부합되지 않는다면, 값이 변경되지 않도록 하고 싶다.
//    Delegate.vetoable
class Person {
    var age: Int by Delegates.vetoable(0) { _: KProperty<*>, _: Int, new: Int ->
        new in 1..100
    }
}

fun main() {
    val person = Person()
    person.age = 50
    println(person.age)

    person.age = -1
    println(person.age)
    
    val textView = TextView()
    textView.text = "Hello"
    textView.text = "Hi"

    val user = User()
    println("User 객체 생성 완료")

    user.go()
}