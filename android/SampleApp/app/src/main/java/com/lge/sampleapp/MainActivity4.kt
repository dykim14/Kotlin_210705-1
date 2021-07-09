package com.lge.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.lge.sampleapp.databinding.MainActivity4Binding
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException
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

    companion object {
        const val TAG = "MainActivity4"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loadButton.setOnClickListener {
            // 1. OKHttpClient 객체 생성
            /*
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            */
            val httpClient = OkHttpClient.Builder()
                .apply {
                    addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                }.build()

            // 2. Request 객체 생성
            //      URL: https://api.github.com/users/JakeWharton
            //   METHOD: GET / POST / PUT / DELETE
            val request = Request.Builder().apply {
                get()
                url("https://api.github.com/users/JakeWharton")
            }.build()

            // 3. 동기 / 비동기 - Call
            val call = httpClient.newCall(request)

            // execute: 동기
            //  - android.os.NetworkOnMainThreadException

            /*
            Thread(object : Runnable {
                override fun run() {

                }
            }).start()
            */

            Thread {
                try {
                    val response: Response = call.execute()

                    // HTTP 성공 / 실패
                    //  : Status Code
                    //  200 ~ 299 - Success
                    //  400 ~ 499 - Client Error
                    //  500 ~ 599 - Server Error
                    // val statusCode = response.code
                    // if (statusCode in 200..299)

                    if (response.isSuccessful) {

                        response.body?.string()?.let { json ->
                            Log.i(TAG, "JSON: $json")
                        }

                    }

                } catch (e: IOException) {
                    Log.e(TAG, e.localizedMessage, e)
                }

            }.start()


            // enqueue: 비동기
        }
    }
}












