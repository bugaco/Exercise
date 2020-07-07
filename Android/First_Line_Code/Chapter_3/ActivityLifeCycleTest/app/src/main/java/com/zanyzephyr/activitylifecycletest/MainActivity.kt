package com.zanyzephyr.activitylifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val tag = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(tag, "onCreate()")

        if (savedInstanceState != null) {
            val tempData = savedInstanceState.getString("extra_data")
            Log.d(tag, "获取到了之前存储的数据：$tempData")
        }

        startNormalActivity.setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }
        startDialogActivity.setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(tag, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(tag, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(tag, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(tag, "onStop()")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(tag, "onRestart()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(tag, "onDestroy()")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        val tempData = "Something you typed."
        outState.putString("extra_data", tempData)
        Log.d(tag, "$tempData 已保存")
    }
}
