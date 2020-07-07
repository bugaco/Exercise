package com.zanyzephyr.activitytest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {
    var backCount: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val extraData: String? = intent.getStringExtra("extra_data")
        Log.d("SecondActivity", extraData ?: "nil")

        backCount = 0 // 初始化为0
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return", "Hello, FirstActivity!")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
