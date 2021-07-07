// 18_인라인2.kt
package ex18_2

class Intent(context: Activity, clazz: Class<out Activity>)

open class Activity {
    open fun onCreate() {}

    fun startActivity(intent: Intent) {}
}

class MainActivity : Activity() {
    override fun onCreate() {
        super.onCreate()

        

    }
}

fun main() {
    // Activity Manager
    val activity = MainActivity()
    activity.onCreate()
}

