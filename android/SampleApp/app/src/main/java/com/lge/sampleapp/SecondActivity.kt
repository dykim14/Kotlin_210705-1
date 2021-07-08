package com.lge.sampleapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.lge.sampleapp.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: SecondActivityBinding

    companion object {
        val TAG = "SecondActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // val user = intent.getParcelableExtra<User>("user")
        val user: User? = intent.getParcelableExtra("user")
        if (user != null) {
            Log.i(TAG, "user: $user")
        }
    }
}