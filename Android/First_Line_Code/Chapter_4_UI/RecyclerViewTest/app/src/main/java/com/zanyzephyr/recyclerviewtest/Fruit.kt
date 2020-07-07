package com.zanyzephyr.recyclerviewtest

import android.util.Log
import java.lang.StringBuilder

class Fruit(var name: String, val imageId: Int) {
    init {
        val n = (1..20).random()
        var str = StringBuilder()
        repeat(n) {
            str.append(name)
        }
        name = str.toString()
        Log.i("Test", name)
    }
}
