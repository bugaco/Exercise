package com.zanyzephyr.activitytest

import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        Log.d("ThirdActivity", "Task is is $taskId")
        button3.setOnClickListener {
            ActivityController.finishAll()
        }
    }
}
