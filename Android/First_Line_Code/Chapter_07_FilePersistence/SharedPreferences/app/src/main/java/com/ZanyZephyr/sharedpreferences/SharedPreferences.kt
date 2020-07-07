package com.ZanyZephyr.sharedpreferences

import android.content.SharedPreferences

fun SharedPreferences.edit(block: SharedPreferences.Editor.() -> Unit) {
    val editor = edit()
    editor.block()
    editor.apply()
}