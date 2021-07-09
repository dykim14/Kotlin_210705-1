package com.lge.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lge.sampleapp.databinding.MainActivity4Binding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import kotlin.math.log


// https://api.github.com/users/JakeWharton
// - 코틀린에서도 HttpClient를 OkHttpClient를 사용합니다.
//  => 의존성 추가


//  => 버전을 편리하게 관리할 수 있는 방법 - BOM
//    def okhttp_version = "4.9.0"
//    implementation  "com.squareup.okhttp3:okhttp:$okhttp_version"
//    implementation  "com.squareup.okhttp3:logging-interceptor:$okhttp_version"

//    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.0"))
//
//    implementation 'com.squareup.okhttp3:okhttp'
//    implementation 'com.squareup.okhttp3:logging-interceptor'


// OkHttpClient
//   : 동기식 호출과 비동기식 호출을 모두 지원합니다.

class MainActivity4 : AppCompatActivity() {
    private val binding: MainActivity4Binding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loadButton.setOnClickListener {
            // 1. OKHttpClient 객체 생성
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()


        }
    }
}












