package com.example.filepersistencetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val input = load()
        if(input.isNotEmpty()) {
            editText.setText(input)
            editText.setSelection(input.length)
            Toast.makeText(this, "恢复成功", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val inputText = editText.text.toString()
        save(inputText)
    }

    private fun save(inputText: String) {
        try {
            val output = openFileOutput("lyzData", Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(output))
            writer.use {
                it.write(inputText)
                Log.d("test save", "存储完成")
            }
        } catch (e: IOException) {
            Log.d("test save", "存储失败")
            e.printStackTrace()
        }
    }

    private fun load(): String {
        val content = StringBuilder()
        try {
            val input = openFileInput("lyzData")
            val reader = BufferedReader(InputStreamReader(input))
            reader.use {
                it.forEachLine {
                    content.append(it)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return content.toString()
    }
}
