package com.lge.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity3)
    }
}

// 액티비티와 프래그먼트에서 View Binding을 사용할 때,
// 쉽게 사용할 수 있도록 하고 싶다.
//  => 프로퍼티 위임
//  => 프로퍼티에 대한 접근자 메소드의 호출을 다른 객체에게 위임한다.(by)
//  : Android Architecture Sample + AirBnb
