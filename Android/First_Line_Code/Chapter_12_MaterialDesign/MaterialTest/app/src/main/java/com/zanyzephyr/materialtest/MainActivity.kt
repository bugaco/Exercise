package com.zanyzephyr.materialtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val msg = when (item.itemId) {
            R.id.backup -> "Backup"
            R.id.delete -> "Delete"
            R.id.settings -> "Settings"
            else -> "null"
        }
        Toast.makeText(this, "$msg", Toast.LENGTH_LONG)
            .show()
        return true
    }
}
