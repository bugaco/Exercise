package com.zanyzephyr.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
//            Toast.makeText(this, editText.text.toString(), Toast.LENGTH_SHORT).show()
//            imageView.setImageResource(R.drawable.img_2)
//            if (progressBar.visibility == View.VISIBLE) {
//                progressBar.visibility = View.GONE
//            } else {
//                progressBar.visibility = View.VISIBLE
//            }
//            progressBar.progress += 10

            AlertDialog.Builder(this).apply {
                setTitle("This is a dialog")
                setMessage("Something important...")
                setCancelable(false)
                setPositiveButton("OK") { _, which ->
                    Log.i(javaClass.simpleName, "OK, which: $which")
                }
                setNegativeButton("Cancel") { _, which ->
                    Log.i(javaClass.simpleName, "Cancel, which: $which")
                }
            }.show()
        }


    }
}
