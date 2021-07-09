package com.lge.sampleapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.viewbinding.ViewBinding
import com.lge.sampleapp.databinding.MainActivity3Binding
import com.lge.sampleapp.databinding.MainFragmentBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class MainActivity3 : AppCompatActivity() {

    /*
    private val binding: MainActivity3Binding by viewBinding()
    // by ActivityBindingDelegate(MainActivity3Binding::class.java, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(binding.root)

        binding.textView.text = "Hi"

    }
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        if (savedInstanceState == null) {
            val fragment = MainFragment2()
            supportFragmentManager.commit {
                replace(R.id.fragmentContainer, fragment)
            }
        }

    }
}


class MainFragment2 : Fragment(R.layout.main_fragment) {
    private val binding: MainFragmentBinding by viewBinding()

    override fun onStart() {
        super.onStart()

        binding.helloButton.setOnClickListener {
            binding.nameTextView.text = "Hello, Kotlin2"
        }
    }


    /*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = MainFragmentBinding.bind(view)
        binding.helloButton.setOnClickListener {
            binding.nameTextView.text = "Hello, Kotlin2"
        }
    }
    */
}


inline fun <reified T : ViewBinding> Fragment.viewBinding() =
    FragmentViewBindingDelegate(T::class.java, this)

class FragmentViewBindingDelegate<T : ViewBinding>(
    bindingClass: Class<T>,
    val fragment: Fragment
) : ReadOnlyProperty<Fragment, T> {
    private val clearBindingHandler by lazy(LazyThreadSafetyMode.NONE) { Handler(Looper.getMainLooper()) }
    private var binding: T? = null

    private val bindMethod = bindingClass.getMethod("bind", View::class.java)

    init {
        fragment.viewLifecycleOwnerLiveData.observe(fragment) { viewLifecycleOwner ->
            viewLifecycleOwner.lifecycle.addObserver(object : LifecycleObserver {
                @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                fun onDestroy() {
                    // Lifecycle listeners are called before onDestroyView in a Fragment.
                    // However, we want views to be able to use bindings in onDestroyView
                    // to do cleanup so we clear the reference one frame later.
                    clearBindingHandler.post { binding = null }
                }
            })
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        binding?.let { return it }

        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        if (!lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            error("Cannot access view bindings. View lifecycle is ${lifecycle.currentState}!")
        }

        binding = bindMethod.invoke(null, thisRef.requireView()) as T
        return binding!!
    }
}


// 액티비티 뷰 바인딩 위임 객체
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
        binding?.let {
            thisRef.setContentView(it.root)
        }


        return binding!!
    }
}


