package com.zanyzephyr.playvideotest

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uri = Uri.parse("android.resource://$packageName/${R.raw.video}")
        videoView.setVideoURI(uri)

        play.setOnClickListener {
            if (!videoView.isPlaying) {
                videoView.start() // 开始播放
            }
            Log.i(TAG, "Video is playing")
        }
        pause.setOnClickListener {
            if (videoView.isPlaying) {
                videoView.pause() // 暂停播放
            }
            Log.i(TAG, "pause video")
        }
        replay.setOnClickListener {
            if (!videoView.isPlaying) {
                videoView.resume() // 重新播放
            }
            Log.i(TAG, "resume video")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        videoView.suspend()
    }
}
