package com.lge.sampleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.lge.sampleapp.databinding.MainFragmentBinding

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // 액티비티가 최초 실행되었을 때
        //  : savedInstanceState == null

        if (savedInstanceState == null) {
            val fragment = MainFragment()

            /*
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
           */

            // Kotlin 에서 안드로이드를 사용할 때
            // 편리하게 사용할 수 있는 Kotlin Android Extension 라이브러리가 있습니다.
            //    Jetpack Android KTX
            //  > 의존성 추가
            //    androidx.fragment:fragment-ktx:1.3.5

            supportFragmentManager.commit {
                replace(R.id.fragmentContainer, fragment)
            }



        }
    }
}

// fragment.MainFragment.kt
/*
class MainFragment : Fragment(R.layout.main_fragment) {

    lateinit var helloButton: Button
    lateinit var nameTextView: TextView

    /*
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(
        R.layout.main_fragment,
        container, false
    )
    */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        helloButton = view.findViewById(R.id.helloButton)
        nameTextView = view.findViewById(R.id.nameTextView)
    }

    override fun onStart() {
        super.onStart()

        helloButton.setOnClickListener {
            nameTextView.text = "Hello, Kotlin"
        }
    }
}
*/

// View Binding - Fragment

class MainFragment : Fragment() {

    // layout/main_fragment.xml
    private var _binding: MainFragmentBinding? = null

    private val binding: MainFragmentBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onStart() {
        super.onStart()

        binding.helloButton.setOnClickListener {
            binding.nameTextView.text = "Hello, Kotlin"
        }
    }

    // 주의사항: 프래그먼트에서 View binding을 사용할 때
    //         메모리 누수의 위험성이 있습니다.
    //  - .addToBackStack()
    //   => 프래그먼트는 유효하지만, 뷰는 유효하지 않을 수 있습니다.
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


class MainFragment2 : Fragment(R.layout.main_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 프로퍼티로 바인딩 객체를 사용하지 않는다면,
        // 메모리 관리에 대한 부분을 처리하지 않아도 됩니다.
        val binding = MainFragmentBinding.bind(view)
        binding.helloButton.setOnClickListener {
            binding.nameTextView.text = "Hello, Kotlin2"
        }
    }

}















