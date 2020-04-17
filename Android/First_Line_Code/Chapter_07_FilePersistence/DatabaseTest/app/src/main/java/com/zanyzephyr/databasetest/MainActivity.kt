package com.zanyzephyr.databasetest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = SQLiteOpenHelper(this, "BookStore.db", 3)
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
        }
    }
}
