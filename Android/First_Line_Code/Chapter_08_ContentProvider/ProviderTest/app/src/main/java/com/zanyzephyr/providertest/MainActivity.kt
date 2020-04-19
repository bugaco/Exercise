package com.zanyzephyr.providertest

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.contentValuesOf
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bookId: String? = null
        val uriString = "content://com.zanyzephyr.databasetest.provider/book"

        addData.setOnClickListener {
            // 添加数据
            val uri = Uri.parse(uriString)
            val values = contentValuesOf(
                "name" to "A Clash of Kings",
                "author" to "George Martin",
                "page" to 1040,
                "price" to 22.85
            )
            val newUri = contentResolver.insert(uri, values)
            bookId = newUri?.pathSegments?.get(1)
            Log.d("MainActivity", "book added, book id: $bookId")
        }
        queryData.setOnClickListener {
            contentResolver.query(Uri.parse(uriString), null, null, null, null)?.apply {
                Log.d("MainActivity", "query result: ${this.count}")
                while (moveToNext()) {
                    val name = getString(getColumnIndex("name"))
                    val author = getString(getColumnIndex("author"))
                    val page = getString(getColumnIndex("page"))
                    val price = getString(getColumnIndex("price"))
                    Log.d("MainActivity", "book name is $name")
                    Log.d("MainActivity", "book author is $author")
                    Log.d("MainActivity", "book page is $page")
                    Log.d("MainActivity", "book price is $price")
                }
                close()
            }
        }
        updateData.setOnClickListener {
            // 更新数据
            bookId?.let {
                val newUri = Uri.parse("$uriString/$it")
                val values = contentValuesOf("name" to "A Storm of Swords",
                "page" to 1216, "price" to 24.05)
                contentResolver.update(newUri, values, null, null)
            }
        }
        deleteData.setOnClickListener {
            bookId?.let {
                val newUri = Uri.parse("$uriString/$it")
                contentResolver.delete(newUri, null, null)
            }
        }
    }
}
