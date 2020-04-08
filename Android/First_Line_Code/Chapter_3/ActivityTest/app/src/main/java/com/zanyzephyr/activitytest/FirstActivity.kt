package com.zanyzephyr.activitytest

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.makeText
import kotlinx.android.synthetic.main.first_layout.*

class FirstActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        Log.d("FirstActivity", "Task is is $taskId")
        button1.setOnClickListener {
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivityForResult(intent, 2020)
//            val intent = Intent(this, SecondActivity::class.java)
//            startActivity(intent)
            SecondActivity.actionStart(this,"ZanyZephyr", 30)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("FirstActivity", "onRestart()")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var buttonName = ""
        when (item.itemId) {
            R.id.add_item -> buttonName = "Add"
            R.id.remove_item -> buttonName = "Remove"
        }
        Toast.makeText(this, "You clicked $buttonName", Toast.LENGTH_SHORT).show()
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            2020 -> {
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        val returnData: String? = data?.getStringExtra("data_return")
                        Log.d("FirstActivity", returnData)
                    }
                }

            }
        }
    }
}