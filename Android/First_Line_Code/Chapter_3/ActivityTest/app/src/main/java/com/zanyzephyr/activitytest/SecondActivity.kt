package com.zanyzephyr.activitytest

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        Log.d("SecondActivity", "Task is is $taskId")
        button2.setOnClickListener {
            startActivity(Intent(this, ThirdActivity::class.java))
        }
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return", "Hello, FirstActivity!")
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
    companion object {
        fun actionStart(context: Context, name: String, age: Int) {
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra("name", name)
                putExtra("age", age)
            }
            context.startActivity(intent)
        }
    }
}
