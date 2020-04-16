package com.zanyzephyr.broadcasttest

import android.app.AlertDialog
import android.app.Dialog
import android.content.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.zanyzephyr.activitytest.ActivityController
import com.zanyzephyr.activitytest.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forceOfflineButton.setOnClickListener {
            val intent = Intent(forceOfflineBroadcastName)
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }
    }

}