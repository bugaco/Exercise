package com.zanyzephyr.materialtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var msg = ""
        when (item.itemId) {
            R.id.backup -> {
                msg = "Backup"
            }
            R.id.delete -> {
                msg = "Delete"
            }
            R.id.settings -> {
                msg = "Settings"
            }
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START, true)
            }
            else -> "null"
        }
//        Toast.makeText(this, "$msg", Toast.LENGTH_LONG)
//            .show()
        return true
    }
}
