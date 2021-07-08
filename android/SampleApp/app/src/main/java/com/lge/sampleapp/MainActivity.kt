package com.lge.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// 1. build.gradle
//   - project level: build.gradle
//     :   ext.kotlin_version = "1.5.20"
//         classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

//   - app module level: build.gradle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}