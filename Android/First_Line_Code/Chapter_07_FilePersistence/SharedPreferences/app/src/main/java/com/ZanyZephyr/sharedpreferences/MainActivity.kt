package com.ZanyZephyr.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveButton.setOnClickListener {
            val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
            editor.putString("name", "李懿哲")
            editor.putInt("age", 30)
            editor.putBoolean("married", true)
            editor.apply()

            getSharedPreferences("data", Context.MODE_PRIVATE).edit {
                putString("name", "李懿哲")
                putInt("age", 30)
                putBoolean("married", true)
            }
        }

        restoreButton.setOnClickListener {
            val prefs = getSharedPreferences("data", Context.MODE_PRIVATE)
            val name = prefs.getString("name", "")
            val age = prefs.getInt("age", 0)
            val married = prefs.getBoolean("married", false)
            Log.i(TAG, " \n" +
                    "name is $name\n" +
                    "age is $age\n" +
                    "married is $married")
        }
    }
}
