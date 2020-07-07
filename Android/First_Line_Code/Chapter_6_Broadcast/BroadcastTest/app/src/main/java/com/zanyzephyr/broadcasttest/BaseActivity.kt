package com.zanyzephyr.activitytest

import android.app.AlertDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.zanyzephyr.broadcasttest.LoginActivity

open class BaseActivity : AppCompatActivity() {

    companion object {
        val forceOfflineBroadcastName = "com.zanyzephyr.broadcasttest.FORCE_OFFLINE"
    }

    lateinit var forceOfflineBroadcastReceiver: ForceOfflineBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("BaseActivity", javaClass.simpleName)
        ActivityController.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityController.removeActivity(this)
    }

    override fun onResume() {
        super.onResume()

        val filter = IntentFilter()
        filter.addAction(forceOfflineBroadcastName)
        forceOfflineBroadcastReceiver = ForceOfflineBroadcastReceiver()
        registerReceiver(forceOfflineBroadcastReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(forceOfflineBroadcastReceiver)
    }

    inner class ForceOfflineBroadcastReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            AlertDialog.Builder(context).apply {
                setCancelable(false)
                setTitle("警告")
                setMessage("您已被强制下线，请尝试重新登录！")
                setPositiveButton("确定") { _, _ ->
                    ActivityController.finishAll()
                    val intent = Intent(context, LoginActivity::class.java)
                    startActivity(intent)
                }
            }.show()
        }
    }
}