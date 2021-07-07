// 18_인라인2.kt
package ex18_2

import ex22.Button
import ex22.OnClickListener

class Intent(val context: Activity, val clazz: Class<out Activity>)

open class Activity {
    open fun onCreate() {}

    // Android Framework
    fun startActivity(intent: Intent) {
        // clazz로 전달된 액티비티를 생성해서, onCreate를 호출합니다.
        // => Reflection: 동적 생성
        //         안드로이드 프레임워크는 사용자의 액티비티의 정확한 타입을 알 수 없습니다.
        //         생성하고자 하는 클래스에 대한 Class 정보를 통해 객체를 생성합니다.
        val clazz = intent.clazz
        val activity = clazz.newInstance()
        activity.onCreate()
    }
}

fun main() {
    // Activity Manager
    val activity = MainActivity()
    activity.onCreate()
}
//------------------------------------

class SecondActivity : Activity() {
    override fun onCreate() {
        super.onCreate()

        println("SecondActivity onCreate")
    }
}

fun <T> add(a: T, b: T) {
}
// * 타입 소거 방식
// fun add(a: Any, b: Any) => 모든 호출이 동일한 함수를 이용합니다.
//  : 컴파일러가 컴파일 타임에 타입을 체크하는 목적으로만 사용합니다.
//    바이트 코드에는 어떤 타입 정보도 존재하지 않습니다.

// * 코드 생성 방식
// add(10, 20)     => fun add(a: Int, b: Int)
// add(1.0, 3.14)  => fun add(a: Double, b: Double)


// 자바에서는 아래와 같은 함수를 절대 제공할 수 없습니다.
//  : Generic(제네릭)
//  - 타입에 일반적인 알고리즘을 가지는 함수와 클래스를 만들 수 있습니다.

//  언어가 구현하는 방식
//   1) 코드 생성 방식
//     : C++ Template / C# Generic / Swift Generic
//      단점: 코드 메모리 사용량이 증가된다.
//      장점: 코드를 생성하는 기술을 이용해서 다양한 설계적인 활용이 가능합니다.
//        Meta Programming / Policy Based Design

//   2) 타입 소거 방식
//     장점: 코드 메모리 사용량이 증가되지 않는다.
//     단점: 활용이 제한적입니다.


// 코틀린은 함수를 호출하지 않고, 치환할 수 있습니다.
// : 함수의 호출이 아니라 인라인 치환을 하면, 타입 정보를 결정한 형태로 바이트 코드를 생성할 수 있습니다.
//  => Jetbrains Anko(Android Kotlin library)

inline fun <reified T : Activity> Activity.startActivity() {
    val intent = Intent(this, T::class.java)
    startActivity(intent)
}

class MainActivity : Activity() {
    override fun onCreate() {
        super.onCreate()

        // MainActivity에서 SecondActivity로 액티비티 전환
        // val intent = Intent(this, SecondActivity::class.java)
        // startActivity(intent)


        startActivity<SecondActivity>()

        val button = Button()

        // Anonymous Object
        button.onClickListener = object : OnClickListener {
            override fun onClick() {
                // this: 익명 객체의 this 입니다.
                //   Java: MainActivity.this
                // Kotlin: this@MainActivity
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(intent)
            }
        }

        // SAM - Lambda Expression
        button.onClickListener = OnClickListener {
            // this: 외부 MainActivity의 this를 의미합니다.
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


    }
}


// <인라인 사용처 2가지>
// 1) 함수를 인자로 전달받는 고차 함수에서 호출의 오버헤드를 없애는 목적
// 2) reified T
//    T의 타입을 결정해서 인라인화하는 목적








