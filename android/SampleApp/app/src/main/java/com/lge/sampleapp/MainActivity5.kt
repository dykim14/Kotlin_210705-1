package com.lge.sampleapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import coil.load
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.lge.sampleapp.databinding.MainActivity5Binding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


// 1. Retrofit 의존성 추가
//     implementation 'com.squareup.retrofit2:retrofit:2.9.0'
//     implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

// 2. API interface 정의
//    => 인터페이스를 이용해서, 자동으로 Request / Call 객체를 생성합니다.

// GithubApi.kt
interface GithubApi {

    @GET("/users/{login}")
    fun getUser(@Path("login") login: String): Call<User>
}

// 3. OKHttpClient 객체 생성
private val httpClient = OkHttpClient.Builder()
    .apply {
        addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
    }.build()

// 4. Retrofit 객체 생성
private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl("https://api.github.com")
    client(httpClient)

    val gson = GsonBuilder().apply {
        setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
    }.create()
    addConverterFactory(GsonConverterFactory.create(gson))

}.build()

// 5. 인터페이스 객체 생성
val githubApi: GithubApi = retrofit.create(GithubApi::class.java)
//-------


class MainActivity5 : AppCompatActivity() {
    companion object {
        const val TAG = "MainActivity5"
    }

    private val binding: MainActivity5Binding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loadButton.setOnClickListener {
            val call = githubApi.getUser("Google")

            call.enqueue(object : Callback<User> {
                override fun onResponse(
                    call: Call<User>,
                    response: Response<User>
                ) {
                    if (response.isSuccessful.not()) {
                        return
                    }

                    val user = response.body() ?: return
                    update(user)
                }

                override fun onFailure(
                    call: Call<User>,
                    t: Throwable
                ) {
                    Log.e(TAG, t.localizedMessage, t)
                }

            })

        }
    }

    private fun update(user: User) {
        runOnUiThread {
            binding.loginTextView.text = user.login

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












