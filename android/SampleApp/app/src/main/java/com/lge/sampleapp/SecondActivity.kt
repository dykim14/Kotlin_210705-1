package com.lge.sampleapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lge.sampleapp.databinding.SecondActivityBinding

// val - final(상수)
// 1. 컴파일 타임 상수
//   => 메모리 공간을 사용하지 않는 상수값
//    : const val

// 2. 런타임 상수
//   => 변수처럼 메모리에 공간이 할당되어 있지만,
//      수정할 수 없습니다.


class SecondActivity : AppCompatActivity() {
    lateinit var binding: SecondActivityBinding

    companion object {
        const val TAG1 = "SecondActivity"
        val TAG2: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // val user = intent.getParcelableExtra<User>("user")
//        val user: User? = intent.getParcelableExtra("user")
//        if (user != null) {
//            Log.i(TAG1, "user: $user")
//        }
    }
}