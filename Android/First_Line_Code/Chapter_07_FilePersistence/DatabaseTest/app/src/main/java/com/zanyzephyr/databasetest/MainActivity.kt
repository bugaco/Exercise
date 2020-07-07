package com.zanyzephyr.databasetest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.contentValuesOf
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

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
            // 直接插入
            db.execSQL("insert into Book (name, author, price, page) values(?, ?, ?, ?)",
            arrayOf("知行合一王阳明", "度阴山", 50, 300))
            return@setOnClickListener

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

            val cv3 = cvOfV2("name" to "哈利·波特", "author" to "罗琳", "price" to 55, "page" to 88)
            db.insert("Book", null, cv3)

            val cv4 = contentValuesOf("name" to "哈利·波特", "author" to "罗琳", "price" to 55, "page" to 88)
            db.insert("Book", null, cv4)
        }

        updateButton.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.execSQL("update Book set price = ? where name = ?", arrayOf(8.9, "知行合一王阳明"))
            return@setOnClickListener
            val updateValue = ContentValues().apply {
                put("price", 9.9)
            }
            db.update("Book", updateValue, "name = ?", arrayOf("第一行代码"))
        }

        deleteButton.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.execSQL("delete from Book where name = ?", arrayOf("知行合一王阳明"))
            return@setOnClickListener
            db.delete("Book", "name = ?", arrayOf("第二行代码"))
        }

        queryButton.setOnClickListener {
            val db = dbHelper.writableDatabase
//            val cursor = db.query("Book", null, null, null, null, null, null)
            val cursor = db.rawQuery("select * from Book", null)
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

        replaceDataButton.setOnClickListener {
            val db = dbHelper.readableDatabase
            try {
                db.beginTransaction()
                db.delete("Book", null, null)
//                throw java.lang.Exception()

                val newValue = ContentValues().apply {
                    put("name", "Google测试之道")
                    put("author", "Goole")
                    put("price", 78)
                    put("page", 467)
                }
                db.insert("Book", null, newValue)

                db.setTransactionSuccessful()
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                db.endTransaction()
            }
        }
    }
}
