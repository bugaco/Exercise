package com.zanyzephyr.databasetest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = SQLiteOpenHelper(this, "BookStore.db", 2)
        createDatabaseButton.setOnClickListener {
            dbHelper.writableDatabase
        }

        addDataButton.setOnClickListener {
            val db = dbHelper.writableDatabase
            val value1 = ContentValues().apply {
                put("name", "第一行代码")
                put("author", "郭霖")
                put("price", 98)
                put("page", 700)
            }
            db.insert("Book", null, value1)
            val value2 = ContentValues().apply {
                put("name", "第二行代码")
                put("author", "李懿哲")
                put("price", 108)
                put("page", 500)
            }
            db.insert("Book", null, value2)
        }

        updateButton.setOnClickListener {
            val db = dbHelper.writableDatabase
            val updateValue = ContentValues().apply {
                put("price", 9.9)
            }
            db.update("Book", updateValue, "name = ?", arrayOf("第一行代码"))
        }

        deleteButton.setOnClickListener {
            val db = dbHelper.writableDatabase

            db.delete("Book", "name = ?", arrayOf("第二行代码"))
        }

        queryButton.setOnClickListener {
            val db = dbHelper.writableDatabase
            val cursor = db.query("Book", null, null, null, null, null, null)
            if (cursor.moveToFirst()) {
                do {
                    cursor.apply {  }
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val page = cursor.getString(cursor.getColumnIndex("page"))
                    val price = cursor.getString(cursor.getColumnIndex("price"))
                    Log.i("MainActivity", "name: $name")
                    Log.i("MainActivity", "author: $author")
                    Log.i("MainActivity", "page: $page")
                    Log.i("MainActivity", "price: $price")
                } while (cursor.moveToNext())
            }
        }
    }
}
