package com.zanyzephyr.workmanagertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.BackoffPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkInfo
import androidx.work.WorkManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var request: OneTimeWorkRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        request = OneTimeWorkRequest.Builder(SimpleWorker::class.java)
                .setInitialDelay(5, TimeUnit.SECONDS) // 设置延迟时间
                .addTag("simple") // 添加标签，之后根据需要可以根据标签来取消任务
                .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 10, TimeUnit.SECONDS) // 设置返回 retry 的重新执行时间
                .build()

        doWorkBtn.setOnClickListener {

            WorkManager.getInstance(this).enqueue(request)
        }
//        return
        /*取消*/
        // 取消指定tag的
        WorkManager.getInstance(this).cancelAllWorkByTag("simple")
        // 取消全部
        WorkManager.getInstance(this).cancelAllWork()

        /*对返回结果监听*/
        WorkManager.getInstance(this)
                .getWorkInfoByIdLiveData(request.id)
                .observe(this, Observer {
                    if (it.state == WorkInfo.State.SUCCEEDED) {
                        Log.d("MainActivity", "do work  succeeded")
                    } else if (it.state == WorkInfo.State.FAILED) {
                        Log.d("MainActivity", "do work  failed")
                    }
                })
    }
}
