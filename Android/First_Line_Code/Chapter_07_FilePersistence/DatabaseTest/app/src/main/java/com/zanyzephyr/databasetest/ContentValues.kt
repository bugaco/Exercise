package com.zanyzephyr.databasetest

import android.content.ContentValues

fun cvOf(vararg pairs: Pair<String, Any?>): ContentValues {
    val contentValues = ContentValues()
    for (pair in pairs) {
        val key = pair.first
        val value = pair.second
        when (value) {
            is Int -> contentValues.put(key, value)
            is Long -> contentValues.put(key, value)
            is Short -> contentValues.put(key, value)
            is Float -> contentValues.put(key, value)
            is Double -> contentValues.put(key, value)
            is Boolean -> contentValues.put(key, value)
            is String -> contentValues.put(key, value)
            is Byte -> contentValues.put(key, value)
            is ByteArray -> contentValues.put(key, value)
            null -> contentValues.putNull(key)
        }
    }
    return contentValues
}

fun cvOfV2(vararg pairs: Pair<String, Any?>) = ContentValues().apply {
    val contentValues = ContentValues()
    for (pair in pairs) {
        val key = pair.first
        val value = pair.second
        when (value) {
            is Int -> put(key, value)
            is Long -> put(key, value)
        is Short -> put(key, value)
            is Float -> put(key, value)
            is Double -> put(key, value)
            is Boolean -> put(key, value)
            is String -> put(key, value)
            is Byte -> put(key, value)
            is ByteArray -> put(key, value)
            null -> putNull(key)
        }
    }
    return contentValues
}