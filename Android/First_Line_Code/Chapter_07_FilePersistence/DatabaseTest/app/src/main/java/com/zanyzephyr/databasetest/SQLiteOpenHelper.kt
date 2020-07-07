package com.zanyzephyr.databasetest

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

class SQLiteOpenHelper(private val context: Context, name: String, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {

    private val createBook = "create table Book(" +
            "id integer primary key autoincrement," +
            "author text," +
            "price real," +
            "page integer," +
            "name text," +
            "category_id integer)"

    private val createCategory = "create table Category(" +
            "id integer primary key autoincrement," +
            "category_name text," +
            "category_code integer)"

    override fun onCreate(db: SQLiteDatabase?) {
        Log.i("MainActivity", "onCreate")
        db?.execSQL(this.createBook)
        db?.execSQL(this.createCategory)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int){
        Log.i("MainActivity", "onUpgrade")
        if (oldVersion <= 1) {
            db?.execSQL(createCategory)
        }
        if (oldVersion <= 2) {
            db?.execSQL("alter table Book add column category_id integer")
        }
    }
}