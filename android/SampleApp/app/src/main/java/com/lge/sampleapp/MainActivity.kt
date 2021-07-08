package com.lge.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}