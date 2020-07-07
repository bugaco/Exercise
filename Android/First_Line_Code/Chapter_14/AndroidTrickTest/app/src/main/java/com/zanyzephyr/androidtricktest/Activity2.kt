package com.zanyzephyr.androidtricktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_2.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.showToastBtn

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val me = intent.getParcelableExtra("person") as Person
        if (me != null) {
            textView2.text = me.name
        }

        showToastBtn.setOnClickListener {
            this.toString().makeToast()
        }
    }
}
