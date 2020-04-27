package com.zanyzephyr.androidtricktest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jumpButton.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            val me = Person("李懿哲", 30)
            intent.putExtra("person", me)
            startActivity(intent)
        }

        showToastBtn.setOnClickListener {
            this.toString().makeToast()
        }
    }
}
