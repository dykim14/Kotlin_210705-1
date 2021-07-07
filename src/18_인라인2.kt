// 18_인라인2.kt
package ex18_2

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

class SecondActivity : Activity() {
    override fun onCreate() {
        super.onCreate()

        println("SecondActivity onCreate")
    }
}


class MainActivity : Activity() {
    override fun onCreate() {
        super.onCreate()

        // MainActivity에서 SecondActivity로 액티비티 전환
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}

fun main() {
    // Activity Manager
    val activity = MainActivity()
    activity.onCreate()
}

