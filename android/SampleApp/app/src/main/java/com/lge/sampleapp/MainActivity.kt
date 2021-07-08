package com.lge.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

// 1. build.gradle
//   - project level: build.gradle
//     :   ext.kotlin_version = "1.5.20"
//         classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

//   - app module level: build.gradle
//     : id 'kotlin-android'
//
//    kotlinOptions {
//        jvmTarget = '1.8'
//    }
//
//    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
//     : 코틀린 표준 라이브러리에 대한 의존성입니다.
//
//    implementation 'androidx.core:core-ktx:1.6.0'
//     : "Android Jetpack"이 제공하는 코틀린 확장 라이브러리 입니다.


// - Kotlin
//  View: Null X
// View?: Nullable

// View!: Platform Type
//   => 안드로이드 코드에서 이것이 "Null"인지 "Nullable" 인지의 정보를
//      제공하지 않습니다.

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. findViewById
        // val helloButton = findViewById<Button>(R.id.helloButton)
        val helloButton: Button = findViewById(R.id.helloButton)
        val nameTextView: TextView = findViewById(R.id.nameTextView)

        // SAM 지원 - Lambda Expression을 사용할 수 있습니다.
        /*
        helloButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

            }
        })
        */

        helloButton.setOnClickListener {
            nameTextView.text = "Hello, Kotlin"
        }

    }
}












