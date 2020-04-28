package com.zanyzephyr.dartthememanuadapter1

import android.content.Context
import android.content.res.Configuration
import java.util.*

fun isDarkTheme(context: Context): Boolean {
    val flag = context.resources.configuration.uiMode and
            Configuration.UI_MODE_NIGHT_YES
    return flag == Configuration.UI_MODE_NIGHT_YES
}

fun printFruits() {
    val fruitList: MutableList<String> =
        ArrayList()
    fruitList.add("Apple")
    fruitList.add("Banana")
    fruitList.add("Orange")
    fruitList.add("Pear")
    for (fruit in fruitList) {
        println(fruit)
    }
}