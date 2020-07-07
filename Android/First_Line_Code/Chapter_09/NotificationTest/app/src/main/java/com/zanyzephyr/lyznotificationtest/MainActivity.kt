package com.zanyzephyr.lyznotificationtest

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Build
import androidx.core.app.NotificationCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = getSystemService(Context.NOTIFICATION_SERVICE)
        as NotificationManager
        manager.cancel(1)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val chanel = NotificationChannel("normal", "Normal",
            NotificationManager.IMPORTANCE_DEFAULT)
            manager.createNotificationChannel(chanel)
            val chanel2 = NotificationChannel("important", "Important",
            NotificationManager.IMPORTANCE_HIGH)
            manager.createNotificationChannel(chanel2)

        }
        sendNotice.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            val pi = PendingIntent.getActivity(this,
            0, intent, 0)
            val notification = NotificationCompat.Builder(this, "important")
                    .setContentTitle("This is content title")
                    .setContentText("This is content text")
                    .setSmallIcon(R.drawable.small_icon)
//                    .setStyle(NotificationCompat.BigTextStyle().bigText("" +
//                            "这是一个很长很长的文本这是一个很长很长的文本这是一个很长很长的文本" +
//                            "这是一个很长很长的文本这是一个很长很长的文本这是一个很长很长的文本" +
//                            "这是一个很长很长的文本这是一个很长很长的文本这是一个很长很长的文本"))
//                    .setStyle(NotificationCompat.BigPictureStyle().bigPicture(
//                            BitmapFactory.decodeResource(resources, R.drawable.big_image)
//                    ))
                    .setLargeIcon(BitmapFactory.decodeResource(resources,
                    R.drawable.large_icon))
                    .setContentIntent(pi)
                    .setAutoCancel(true)
                    .build()
            manager.notify(1, notification)
        }
    }
}
