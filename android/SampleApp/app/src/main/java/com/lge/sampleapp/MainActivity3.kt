package com.lge.sampleapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.lge.sampleapp.databinding.MainActivity3Binding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class MainActivity3 : AppCompatActivity() {

    private val binding: MainActivity3Binding by viewBinding()
    // by ActivityBindingDelegate(MainActivity3Binding::class.java, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textView.text = "Hi"

    }
}

// ActivityBindingDelegate(MainActivity3Binding::class.java, this)
// => 복잡합니다.
// => 객체 생성 방법이 복잡할 경우, 제네릭 함수를 통해 복잡도를 감출 수 있습니다.
/*
inline fun <reified T : ViewBinding> Activity.viewBinding(): ActivityBindingDelegate<T> {
    return ActivityBindingDelegate(T::class.java, this)
}
*/
inline fun <reified T : ViewBinding> Activity.viewBinding() =
    ActivityBindingDelegate(T::class.java, this)


// 액티비티와 프래그먼트에서 View Binding을 사용할 때,
// 쉽게 사용할 수 있도록 하고 싶다.
//  => 프로퍼티 위임
//  => 프로퍼티에 대한 접근자 메소드의 호출을 다른 객체에게 위임한다.(by)
//  : Android Architecture Sample + AirBnb

class ActivityBindingDelegate<T : ViewBinding>(
    private val bindingClass: Class<T>,
    val activity: Activity
) : ReadOnlyProperty<Activity, T> {

    private var binding: T? = null

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        // 이미 binding 객체가 생성되어 있다면, 생성된 객체를 반환합니다.
        binding?.let { return it }

        // ViewBinding.inflate(LayoutInflater)
        val inflateMethod = bindingClass.getMethod(
            "inflate",
            LayoutInflater::class.java
        )

        @Suppress("UNCHECKED_CAST")
        binding = inflateMethod.invoke(null, thisRef.layoutInflater) as T

        return binding!!
    }
}


