package com.zanyzephyr.servicetest

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService: IntentService("MyIntentService") {
    override fun onHandleIntent(intent: Intent?) {
        // 打印当前线程的id
        Log.i("MyIntentService", "Thread name is ${Thread.currentThread().name}")
        // Thread name is IntentService[MyIntentService]
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MyIntentService", "onDestroy executed")
    }
}