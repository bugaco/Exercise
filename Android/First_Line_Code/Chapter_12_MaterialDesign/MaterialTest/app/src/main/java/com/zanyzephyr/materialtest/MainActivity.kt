package com.zanyzephyr.materialtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val fruits = mutableListOf<Fruit>(
        Fruit("Apple", R.drawable.apple),
        Fruit("Banana", R.drawable.banana),
        Fruit("Watermelon", R.drawable.watermelon),
        Fruit("Grape", R.drawable.grape),
        Fruit("Strawberry", R.drawable.strawberry),
        Fruit("Mango", R.drawable.mango),
        Fruit("Orange", R.drawable.orange),
        Fruit("Pear", R.drawable.pear),
        Fruit("Pineapple", R.drawable.pineapple),
        Fruit("Cherry", R.drawable.cherry)
    )
    val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }
        navView.setCheckedItem(R.id.navFriends)
        navView.setNavigationItemSelectedListener {
            drawerLayout.closeDrawers()
            true
        }

        fab.setOnClickListener {
            Snackbar.make(it, "Data deleted", Snackbar.LENGTH_LONG)
                .setAction("Undo") {
                    Toast.makeText(this, "Data restored", Toast.LENGTH_LONG).show()
                }
                .show()
        }

        /* 设置RecyclerView */
        initFruits()
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(this, fruitList)
        recyclerView.adapter = adapter
    }

    private fun initFruits() {
        fruitList.clear()
        repeat(50) {
            val index = (0 until fruits.size).random()
            fruitList.add(fruits[index])
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
