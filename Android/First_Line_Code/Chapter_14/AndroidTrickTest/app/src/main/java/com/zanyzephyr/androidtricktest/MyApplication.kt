package com.zanyzephyr.androidtricktest

import android.app.Application
import android.content.Context
import android.widget.Toast

class MyApplication: Application() {
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}

fun String.makeToast() {
    Toast.makeText(MyApplication.context, this, Toast.LENGTH_LONG).show()
}