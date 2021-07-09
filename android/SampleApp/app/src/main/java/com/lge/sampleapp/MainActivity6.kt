package com.lge.sampleapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.lge.sampleapp.databinding.MainActivity5Binding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


private val httpClient = OkHttpClient.Builder()
    .apply {
        addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
    }.build()


val githubApi: GithubApi = retrofit.create(GithubApi::class.java)

// RxJava3 / Android
// implementation 'io.reactivex.rxjava3:rxjava:3.0.13'
// implementation 'io.reactivex.rxjava3:rxkotlin:3.0.1'
// implementation 'io.reactivex.rxjava3:rxandroid:3.0.0'

// Retrofit
//  call-adapter
// implementation 'com.squareup.retrofit2:adapter-rxjava3:2.9.0'
//------------------------------

// Reactive Extension - Rx
// : 비동기의 연산을 컬렉션을 다루는 것처럼 일반적인 연산을 통해 처리할 수 있다.

// Collection 설계 기술
//  : Iterator Pattern
//  Iterable -  pull     - Iterator
//                         hasNext(): Boolean
//                            next(): E

// 비동기의 이벤트는 언제 발생하는지 알 수 없습니다.
//  : Observer Pattern
//   - 데이터의 변경이 발생하였을 경우, 등록된 객체에게 알려줍니다.

// Observable - push     - Observer
//                          onNext(E e)
//                          onComplete()
//                          onError(E)

// Rx 구성요소
// 1) Observable
//  : 이벤트를 발생하는 주체로, 이벤트 스트림을 통해 이벤트를 Observer에게 전달합니다.

// 2) Observer
//  : Observable에서 발생한 이벤트에 반응하는 객체
//    이벤트가 발생하였을 때 수행할 작업을 정의합니다.

//   "Observer"가 "Observable"을 구독(Subscribe)한다.
//    => 이벤트 스트림이 형성됩니다.

// 3) Operator
//  : 연산자(Operator)는 이벤트 스트림을 통해 전달되는 이벤트에 연산을 수행합니다.

// 4) Scheduler
//  : 작업을 수행하는 스레드를 제어할 수 있습니다.

// 5) Disposable
// : Observer가 Observable을 구독할 때 형성되는 이벤트 스트림은 자원입니다.
//   유효하지 않은 경우, 반드시 명시적인 해지가 필요합니다.

private val retrofit: Retrofit = Retrofit.Builder().apply {
    baseUrl("https://api.github.com")
    client(httpClient)

    val gson = GsonBuilder().apply {
        setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
    }.create()

    addConverterFactory(GsonConverterFactory.create(gson))

    // Call<T> -> Adapter -> Observable<T>
    addCallAdapterFactory(RxJava3CallAdapterFactory.create())

}.build()


interface GithubApi {
    @GET("/users/{login}")
    fun getUser(@Path("login") login: String): Call<User>

    @GET("/users/{login}")
    fun getUserRx(@Path("login") login: String): Observable<User>

    @GET("/search/users")
    fun searchUsers(
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 10
    ): Call<SearchResult>

    @GET("/search/users")
    fun searchUsersRx(
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 10
    ): Observable<SearchResult>
}


class MainActivity6 : AppCompatActivity() {
    companion object {
        private const val TAG = "MainActivity6"
    }

    private val binding: MainActivity5Binding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.loadButton.setOnClickListener {


            val observable = githubApi.getUserRx("Google")

            // observable.subscribe({ }, { }, { })
            observable.subscribeBy(
                onNext = { user ->
                    Log.i(TAG, "onNext: $user")
                },
                onError = { t ->
                    Log.e(TAG, "onError: ${t.localizedMessage}", t)
                },
                onComplete = {
                    Log.i(TAG, "onComplete")
                }
            )


        }
    }

}










