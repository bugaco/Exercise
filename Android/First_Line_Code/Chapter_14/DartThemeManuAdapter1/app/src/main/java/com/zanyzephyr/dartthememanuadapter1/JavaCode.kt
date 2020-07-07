package com.zanyzephyr.dartthememanuadapter1

import java.util.*

class JavaCode {
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
}