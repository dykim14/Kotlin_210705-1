package com.lge.sampleapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.lge.sampleapp.databinding.MainActivity4Binding
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException


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
// Google Gson
//   의존성 추가
//   :  implementation 'com.google.code.gson:gson:2.8.7'

/*
{
    "login": "JakeWharton",
    "id": 66577,
    "avatar_url": "https://avatars.githubusercontent.com/u/66577?v=4",
    "type": "User",
    "name": "Jake Wharton",
}
*/

data class User(
    val login: String,
    val id: Int,
    // @field:SerializedName("avatar_url") val avatarUrl: String,
    val avatarUrl: String,
    val type: String,
    val name: String?
    // 위의 name이 Nullable이 되어야 하는 이유를 이해해야 합니다.
)

class MainActivity4 : AppCompatActivity() {
    private val binding: MainActivity4Binding by viewBinding()

    companion object {
        const val TAG = "MainActivity4"
    }

    /*
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

            // val gson = Gson()
            val gson = GsonBuilder().apply {
                setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            }.create()

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

                            val user: User = gson.fromJson(json, User::class.java)
                            Log.i(TAG, "User: $user")


                            update(user)
                        }

                    }

                } catch (e: IOException) {
                    Log.e(TAG, e.localizedMessage, e)
                }

            }.start()


            // enqueue: 비동기
        }
    }
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loadButton.setOnClickListener {
            val gson = GsonBuilder().apply {
                setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            }.create()

            val httpClient = OkHttpClient.Builder()
                .apply {
                    addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                }.build()

            val request = Request.Builder().apply {
                get()
                url("https://api.github.com/users/JakeWharton")
            }.build()

            val call = httpClient.newCall(request)

            // 비동기: enqueue
            // - 아래의 코드를 람다 표현식을 통해 수행할 수 있도록, 확장함수를 설계합니다.
            call.enqueue(
                onResponse = { response ->
                    if (!response.isSuccessful)
                        return@enqueue

                    val json = response.body?.string() ?: return@enqueue
                    Log.i(TAG, "JSON: $json")

                    val user: User = gson.fromJson(json, User::class.java)
                    Log.i(TAG, "User: $user")

                    update(user)
                },
                onFailure = { e ->
                    Log.e(TAG, e.localizedMessage, e)
                }
            )
            /*
            call.enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e(TAG, e.localizedMessage, e)
                }

                override fun onResponse(call: Call, response: Response) {
                    if (response.isSuccessful) {

                        response.body?.string()?.let { json ->
                            Log.i(TAG, "JSON: $json")

                            val user: User = gson.fromJson(json, User::class.java)
                            Log.i(TAG, "User: $user")


                            update(user)
                        }

                    }
                }
            })
            */

        }

    }


    private fun update(user: User) {
        // UI 업데이트는 UI 스레드에서 수행되어야 합니다.
        runOnUiThread {
            binding.loginTextView.text = user.login

            // Glide 의존성 추가
            // implementation 'com.github.bumptech.glide:glide:4.12.0'
            // annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
            //  : Java에서 사용하는 의존성

            // 1) id kotlin-kapt 플러그인 추가
            // 2) kapt 'com.github.bumptech.glide:compiler:4.12.0'
            /*
            Glide.with(this)
                .load(user.avatarUrl)
                .circleCrop()
                .into(binding.avatarImageView)
            */

            // Kotlin Image Processing Library - coil
            //  : implementation 'io.coil-kt:coil:1.2.2'
            //  => Extension Function
            binding.avatarImageView.load(user.avatarUrl) {
                transformations(
                    CircleCropTransformation(),
                    GrayscaleTransformation()
                )
                crossfade(300)
            }


        }

    }
}

// crossinline: 인라인 함수 안에서 다른 함수에서 호출되는 함수를 인라인화 한다.
inline fun Call.enqueue(
    crossinline onResponse: (response: Response) -> Unit,
    crossinline onFailure: (e: IOException) -> Unit
) {

    enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) =
            onFailure(e)

        override fun onResponse(call: Call, response: Response) =
            onResponse(response)
    })
}












