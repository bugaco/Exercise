package com.zanyzephyr.servicetest

import android.app.Service
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate

class MainActivity : AppCompatActivity() {

    lateinit var downloadBind: MyService.DownloadBind
    private val connection = object : ServiceConnection {

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.i("MainActivity", "onServiceDisconnected")
        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            downloadBind = service as MyService.DownloadBind
            downloadBind.startDownload()
            val progress = downloadBind.getProgress()
            Log.i("MainActivity", "progress:$progress")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startServiceBtn.setOnClickListener {
            val serviceIntent = Intent(this, MyService::class.java)
            startService(serviceIntent)
        }
        stopServiceBtn.setOnClickListener {
            val intent = Intent(this, MyService::class.java)
            stopService(intent)
        }
        bindServiceBtn.setOnClickListener {
            val serviceIntent = Intent(this, MyService::class.java)
            bindService(serviceIntent, connection, Context.BIND_AUTO_CREATE)
        }
        unbindServiceBtn.setOnClickListener {
            unbindService(connection)
        }
        startMyIntentServiceBtn.setOnClickListener {
            // 打印主线程的id
            Log.i("MainActivity", "MainActivity Thread name is ${Thread.currentThread().name}")
            // MainActivity Thread name is main
            val intentService = Intent(this, MyIntentService::class.java)
            startService(intentService)
        }

        fun testReified() {
            startActivity<MainActivity>(this) {
                putExtra("name", "李懿哲")
                putExtra("age", "30")
            }
        }
    }
}
