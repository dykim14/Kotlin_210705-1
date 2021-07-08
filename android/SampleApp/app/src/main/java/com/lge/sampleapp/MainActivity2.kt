package com.lge.sampleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // 액티비티가 최초 실행되었을 때
        //  : savedInstanceState == null

        if (savedInstanceState == null) {
            val fragment = MainFragment()

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
        }
    }
}

// fragment.MainFragment.kt
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.main_fragment,
            container, false
        )

        return view
    }


}

