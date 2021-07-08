package com.lge.sampleapp

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.lge.sampleapp.databinding.MainActivityBinding
import kotlinx.parcelize.Parcelize

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

/*
data class User(val name: String, val age: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}
*/

@Parcelize
data class User(val name: String, val age: Int) : Parcelable


class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)

        // 3. View-Binding
        //  - app module build.gradle
        //  buildFeatures {
        //        viewBinding true
        //  }

        // View Binding을 고려한다면, 레이아웃 파일에 대한 이름 규칙을
        // 변경하는 것이 좋습니다.
        // 기존: activity_main.xml
        //  - ActivityMainBinding
        // 권장: main_activity.xml
        //  - MainActivityBinding
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // binding.helloButton.setOnClickListener {
        //    binding.nameTextView.text = "Hello, Kotlin"
        // }

        // android:id=@+id/open_button -> binding.openButton
        // android:id=@+id/helloButton -> binding.helloButton

        val user = User("Tom", 42)
        with(binding) {
            helloButton.setOnClickListener {
                nameTextView.text = "Hello, Kotlin"
            }

            openButton.setOnClickListener {
                val intent = Intent(
                    this@MainActivity,
                    SecondActivity::class.java
                )

                // Parcelable 인터페이스를 만족해야 합니다.
                intent.putExtra("user", user)

                startActivity(intent)
            }
        }


        // 1. findViewById
        /*
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
        */

        // 2. kotlin-android-extensions
        //  : Deprecated!
        //     id 'kotlin-android-extensions'
        //     1) findViewById를 자동으로 처리하는 기능
        //        - import kotlinx.android.synthetic.main.activity_main.*
        //        - 오류 가능성(동일한 아이디를 사용한 레이아웃에서 임포트가 잘못되는 문제)
        //        - 캐싱: 리사이클러뷰에서는 제대로 캐싱되지 않기 때문에
        //               findViewById를 호출하는 비효율적인 문제
        //        => View Binding 으로 대체되었습니다.
        //
        //    2) Parcelable
        //      : kotlin-android-extensions에서 분리되어서
        //        kotlin-parcelize 으로 추가하면 됩니다.
        /*
        helloButton.setOnClickListener {
            nameTextView.text = "Hello, Kotlin"
        }
        */


    }
}












