package com.zanyzephyr.databasetest

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.net.Uri

class DatabaseProvider : ContentProvider() {

    private val bookDir = 0
    private val bookItem = 1
    private val categoryDir = 2
    private val categoryItem = 3
    private val authority = "com.zanyzephyr.databasetest.provider"
    private var dbHelper: SQLiteOpenHelper? = null

    private val uriMatcher by lazy {
        val matcher = UriMatcher(UriMatcher.NO_MATCH)
        matcher.addURI(authority, "book", bookDir)
        matcher.addURI(authority, "book/#", bookItem)
        matcher.addURI(authority, "category", categoryDir)
        matcher.addURI(authority, "category/#", categoryItem)
        matcher
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<String>?) =
        dbHelper?.let {
            val db = it.writableDatabase
            val deletedRows = when (uriMatcher.match(uri)) {
                bookDir -> db.delete("Book", selection, selectionArgs)
                bookItem -> db.delete("Book", "id = ?", arrayOf(uri.pathSegments[1]))
                categoryDir -> db.delete("Category", selection, selectionArgs)
                categoryItem -> db.delete("Category", "id = ?", arrayOf(uri.pathSegments[1]))
                else -> 0
            }
            deletedRows
        } ?: 0

    override fun getType(uri: Uri) = when (uriMatcher.match(uri)) {
        bookDir -> "vnd.android.cursor.dir/vnd.com.zanyzephyr.databasetest.provider.book"
        bookItem -> "vnd.android.cursor.item/vnd.com.zanyzephyr.databasetest.provider.book"
        categoryDir -> "vnd.android.cursor.dir/vnd.com.zanyzephyr.databasetest.provider.category"
        categoryItem -> "vnd.android.cursor.item/vnd.com.zanyzephyr.databasetest.provider.category"
        else -> null
    }

    override fun insert(uri: Uri, values: ContentValues?) = dbHelper?.let {
        val db = it.writableDatabase
        val uriReturn = when (uriMatcher.match(uri)) {
            bookDir, bookItem -> {
                val newBookId = db.insert("Book", null, values)
                Uri.parse("content://$authority/book/$newBookId")
            }
            categoryDir, categoryItem -> {
                val categoryId = db.insert("Category", null, values)
                Uri.parse("content://$authority/category/$categoryId")
            }
            else -> null

        }
        uriReturn
    }


    override fun onCreate() = context?.let {
        dbHelper = SQLiteOpenHelper(it, "BookStore.db", 2)
        true
    } ?: false

    override fun query(
        uri: Uri, projection: Array<String>?, selection: String?,
        selectionArgs: Array<String>?, sortOrder: String?
    ) = dbHelper?.let {
        // 查询数据
        val db = it.readableDatabase
        val cursor = when (uriMatcher.match(uri)) {
            bookDir -> db.query(
                "Book", projection, selection, selectionArgs, null, null,
                sortOrder
            )
            bookItem -> {
                val bookId = uri.pathSegments[1]
                db.query(
                    "Book", projection, "id = ?", arrayOf(bookId), null, null,
                    sortOrder
                )
            }
            categoryDir -> db.query(
                "Category", projection, selection, selectionArgs, null, null,
                sortOrder
            )
            categoryItem -> {
                val categoryId = uri.pathSegments[1]
                db.query(
                    "Category", projection, "id = ?", arrayOf(categoryId), null, null,
                    sortOrder
                )
            }
            else -> null
        }
        cursor
    }

    override fun update(
        uri: Uri, values: ContentValues?, selection: String?,
        selectionArgs: Array<String>?
    ) = dbHelper?.let {
        // 更新数据
        val db = it.writableDatabase
        val updateRow = when (uriMatcher.match(uri)) {
            bookDir -> db.update("Book", values, selection, selectionArgs)
            bookItem -> {
                val bookId = uri.pathSegments[1]
                db.update("Book", values, "id = ?", arrayOf(bookId))
            }
            categoryDir -> db.update("Category", values, selection, selectionArgs)
            categoryItem -> {
                val categoryId = uri.pathSegments[1]
                db.update("Category", values, "id = ?", arrayOf(categoryId))
            }
            else -> 0
        }
        updateRow
    } ?: 0
}
